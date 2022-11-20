package com.flightadmin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flightadmin.entity.AirLine;
import com.flightadmin.service.AirLineServiceImpl;

/*
 * @RestController
 * 
 * @CrossOrigin(origins = "http://localhost:4200") public class
 * AirlineAdminController {
 * 
 * @Autowired private AirLineServiceImpl service;
 * 
 * @GetMapping("/admin/getAirLines") public List<AirLine> getAirLines() { return
 * service.getAllAirLines(); }
 * 
 * @PostMapping("/admin/addAirLine") public AirLine addAirLine(@RequestBody
 * AirLine airLine) { return service.addAirLine(airLine); }
 * 
 * }
 */
