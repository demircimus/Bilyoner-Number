package com.bilyoner.bilyonernumber.service;

import java.util.List;

import com.bilyoner.bilyonernumber.model.BilyonerNumber;

public interface BilyonerNumberService {

	public List<BilyonerNumber> findAllNumbers();
	public BilyonerNumber findOneNumber(Integer value);
	public String createNumber(Integer value);
	public String deleteNumber(Integer value);	
	public BilyonerNumber findMaxNumber();
	public BilyonerNumber findMinNumber();
}
