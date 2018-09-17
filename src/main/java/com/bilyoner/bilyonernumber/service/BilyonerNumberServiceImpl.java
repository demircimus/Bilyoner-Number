package com.bilyoner.bilyonernumber.service;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bilyoner.bilyonernumber.model.BilyonerNumber;
import com.bilyoner.bilyonernumber.repository.BilyonerNumberRepository;

@Service
public class BilyonerNumberServiceImpl implements BilyonerNumberService {
	
	@Autowired
	private BilyonerNumberRepository repository;
	
	public List<BilyonerNumber> findAllNumbers() {
		return repository.findAll();
	}

	public BilyonerNumber findOneNumber(Integer value) {
		return repository.findByValue(value);
	}

	public String createNumber(Integer value) {
		String successMessage = "Number added successfully";
		String errorMessage = "The number exists.";
		BilyonerNumber searchedNumber = repository.findByValue(value);
		
		if (searchedNumber != null) {
			return errorMessage;
		} else {
			BilyonerNumber bilyonerNumber = new BilyonerNumber();
			bilyonerNumber.setId(ObjectId.get().toHexString());
			bilyonerNumber.setValue(value);
			bilyonerNumber.setCreateDate(new Date());
			repository.save(bilyonerNumber);
			
			return successMessage;
		}		
	}

	public String deleteNumber(Integer value) {
		String successMessage = "Number deleted";
		String errorMessage = "Number could not be found";
		BilyonerNumber searchedNumber = repository.findByValue(value);

		if (searchedNumber == null) {
			return errorMessage;
		} else {
			repository.delete(searchedNumber);
			return successMessage;
		}
	}
	
	public BilyonerNumber findMaxNumber() {
		return repository.findFirstByOrderByValueDesc();
	}
	
	public BilyonerNumber findMinNumber() {
		return repository.findFirstByOrderByValueAsc();
	}
}
