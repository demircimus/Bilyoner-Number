package com.bilyoner.bilyonernumber.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bilyoner.bilyonernumber.model.BilyonerNumber;
import com.bilyoner.bilyonernumber.service.BilyonerNumberService;

@RestController
@RequestMapping("/numbers")
public class BilyonerNumberController {

	@Autowired
	private BilyonerNumberService service;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<BilyonerNumber> findAllNumbers() {
		return service.findAllNumbers();
	}

	@RequestMapping(value = "/{value}", method = RequestMethod.GET)
	public BilyonerNumber findOneNumber(@PathVariable Integer value) {
		return service.findOneNumber(value);
	}

	@RequestMapping(value = "/{value}", method = RequestMethod.POST)
	public String createNumber(@PathVariable Integer value) {
		return service.createNumber(value);
	}

	@RequestMapping(value = "/{value}", method = RequestMethod.DELETE)
	public String deleteNumber(@PathVariable Integer value) {
		return service.deleteNumber(value);
	}
	
	@RequestMapping(value = "/max", method = RequestMethod.GET)
	public BilyonerNumber findMaxNumber() {
		return service.findMaxNumber();
	}
	
	@RequestMapping(value = "/min", method = RequestMethod.GET)
	public BilyonerNumber findMinNumber() {
		return service.findMinNumber();
	}

}
