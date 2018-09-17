package com.bilyoner.bilyonernumber;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;

import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bilyoner.bilyonernumber.model.BilyonerNumber;
import com.bilyoner.bilyonernumber.repository.BilyonerNumberRepository;

@RunWith(SpringJUnit4ClassRunner.class)
public class BilyonerNumberRepositoryTest {

	@Mock
	BilyonerNumberRepository numberRepository;


	@Test
	public void testGetOneNumber() throws Exception {
		BilyonerNumber result = numberRepository.findByValue(3);
		assertNull(result);
	}
	
	@Test
	public void testCreateNumber() throws Exception {
		BilyonerNumber bilyonerNumber = new BilyonerNumber();
		bilyonerNumber.setId(ObjectId.get().toHexString());
		bilyonerNumber.setValue(3);
		bilyonerNumber.setCreateDate(new Date());
		BilyonerNumber result = numberRepository.save(bilyonerNumber);
		assertNull(result);
	}
	
}
