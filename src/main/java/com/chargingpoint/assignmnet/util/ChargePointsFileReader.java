package com.chargingpoint.assignmnet.util;

import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.multipart.MultipartFile;

import com.chargingpoint.assignmnet.model.ChargingPoints;
import com.opencsv.CSVReader;

public class ChargePointsFileReader {

	private static final String DOUBLE_REGEXP = "^[\\+\\-]{0,1}[0-9]+[\\.\\,]{1}[0-9]+$";
	
	public boolean readCSVFile(MultipartFile multipart) throws Exception {
		if (!multipart.isEmpty()) {
			try (
					CSVReader csvreader = new CSVReader(new InputStreamReader(multipart.getInputStream()));
					){

				populateColumnsHeader(csvreader.readNext());

				List<String[]> cpList = csvreader.readAll().stream().filter(cp -> (cp[ChargingPoints.LATITUDE_NO].matches(DOUBLE_REGEXP) && cp[ChargingPoints.LONGITUDE_NO].matches(DOUBLE_REGEXP))).collect(Collectors.toList());
				ChargingPoints.INSTANCE.setCpList(cpList);

				return true;
			} catch (Exception e) {
				System.out.println("ERROR: Parsing given Charging point file failed.");
				throw e;
			}
		} else {
			return false;
		}
	}

	private void populateColumnsHeader(String[] columns ) {
		for (int index = 0; index< ChargingPoints.NOOFCOLUMNS_READ ; index++) {
			ChargingPoints.INSTANCE.getColumnNames().put(index, columns[index]);
		}
	}
}
