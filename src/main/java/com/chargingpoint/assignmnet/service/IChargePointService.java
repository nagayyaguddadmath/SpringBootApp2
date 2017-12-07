package com.chargingpoint.assignmnet.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface IChargePointService {

	String processFile(MultipartFile multipart);

	boolean deleteChargePointById(String chargeDeviceID);

	String[] findNearestChargingPoint(String latitude, String longitude);

	boolean addChargePoint(String chargingPointLine) throws IOException;

}
