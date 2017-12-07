package com.chargingpoint.assignmnet.service;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.chargingpoint.assignmnet.model.ChargingPoints;
import com.chargingpoint.assignmnet.util.ChargePointsFileReader;
import com.opencsv.CSVParser;

public class ChargepointServiceImpl implements IChargePointService {

	@Autowired
	ChargePointsFileReader fileReader;


	@Override
	public String processFile(MultipartFile multipart) {

		try {
			fileReader.readCSVFile(multipart);
		} catch (Exception e) {
			System.out.println("ERROR: Error occurred while reading given File" + e.getMessage());
			return "You failed to upload charging points file, error is: " + e.getMessage();
		}
		return "You successfully uploaded all charging points !";
	}

	@Override
	public boolean deleteChargePointById(String chargeDeviceID) {
		if (chargeDeviceID != null && chargeDeviceID.length() > 0) {
			ChargingPoints.INSTANCE.getCpList().removeIf(cp -> cp[ChargingPoints.CPID_NO].equals(chargeDeviceID));
			return true;
		}
		return false;

	}

	@Override
	public boolean addChargePoint(String chargingPointLine) throws IOException {
		CSVParser csvParser = new CSVParser();
		try {
			String[] chargingPoint = csvParser.parseLine(chargingPointLine);
			if (chargingPoint != null && chargingPoint.length == ChargingPoints.INSTANCE.getCpList().get(0).length) {
				ChargingPoints.INSTANCE.getCpList().add(chargingPoint);
				return true;
			}
		} catch (IOException e) {
			System.out.println("ERROR: Parsing given Charging point failed: " + chargingPointLine);
			throw e;
		}
		return false;
	}

	@Override
	public String[] findNearestChargingPoint(String latitude, String longitude) {

		return findNearestChargeingPoint(Double.parseDouble(latitude), Double.parseDouble(longitude));
	}

	private String[] findNearestChargeingPoint(double latitude, double longitude) {

		List<String[]> sortedCPList = ChargingPoints.INSTANCE.getCpList().stream().sorted(Comparator.comparing(cp -> findDistanceBetweenTwoPoints(latitude, longitude, Double.parseDouble(cp[ChargingPoints.LATITUDE_NO]),
				Double.parseDouble(cp[ChargingPoints.LONGITUDE_NO])))).collect(Collectors.toList());

		return sortedCPList.get(0);
	}

	private double findDistanceBetweenTwoPoints(double lat1, double lng1, double lat2, double lng2) {
		double diffLat = Math.abs(lat1 - lat2);
		double diffLng = Math.abs(lng1 - lng2);
		if (diffLng > 180) {
			diffLng = 360 - diffLng;
		}
		return diffLat * diffLat + diffLng * diffLng;
	}

	/*
	private String[] findNearestChargeingPoint(double latitude, double longitude) {
		String[] currentMinCP = null;
		double minDistance = Double.MAX_VALUE;
		double curDistance;
		for (String[] cp : ChargingPoints.INSTANCE.getCpList()) {
			curDistance = findDistanceBetweenTwoPoints(latitude, longitude, Double.parseDouble(cp[ChargingPoints.LATITUDE_NO]),
					Double.parseDouble(cp[ChargingPoints.LONGITUDE_NO]));
			if (minDistance > curDistance) {
				minDistance = curDistance;
				currentMinCP = cp;
			}
		}
		return currentMinCP;

	}

	 */

}
