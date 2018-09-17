package com.bilyoner.bilyonernumber.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bilyoner.bilyonernumber.model.BilyonerNumber;

@Repository
public interface BilyonerNumberRepository extends MongoRepository<BilyonerNumber, String> {

	BilyonerNumber findByValue(Integer number);		
	BilyonerNumber findFirstByOrderByValueDesc();	
	BilyonerNumber findFirstByOrderByValueAsc();

}
