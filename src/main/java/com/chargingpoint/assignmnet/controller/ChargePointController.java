package com.chargingpoint.assignmnet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.chargingpoint.assignmnet.service.IChargePointService;


@CrossOrigin
@RestController
public class ChargePointController {


	@Autowired
	private IChargePointService chargePointService;


	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public @ResponseBody String handleFileUpload( 
			@RequestParam("file") MultipartFile multipart){
		return chargePointService.processFile(multipart);
	}

	@RequestMapping(method=RequestMethod.DELETE)
	boolean deleteChargingPoint(String chargeDeviceID) throws Exception {
		return chargePointService.deleteChargePointById(chargeDeviceID);
	}

	@RequestMapping(value ="/add", method=RequestMethod.POST)
	boolean addChargingPoint(@RequestBody String chargingPoint) throws Exception {
		return chargePointService.addChargePoint(chargingPoint);
	}

	@RequestMapping(method=RequestMethod.GET)
	String[] findNearestChargingPoint(String latitude, String longitude) throws Exception {
		return chargePointService.findNearestChargingPoint(latitude, longitude);
	}

	public IChargePointService getChargePointService() {
		return chargePointService;
	}


	public void setChargePointService(IChargePointService chargePointService) {
		this.chargePointService = chargePointService;
	}

}