package com.bilyoner.bilyonernumber;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bilyoner.bilyonernumber.model.BilyonerNumber;
import com.bilyoner.bilyonernumber.repository.BilyonerNumberRepository;
import com.bilyoner.bilyonernumber.service.BilyonerNumberServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
public class BilyonerNumberServiceTest {

	@Mock
	private BilyonerNumberRepository bilyonerRepository;

	@InjectMocks
	private BilyonerNumberServiceImpl bilyonerService;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetAllNumbers() {
		List<BilyonerNumber> toDoList = new ArrayList<BilyonerNumber>();
		toDoList.add(new BilyonerNumber(ObjectId.get().toHexString(), 1, new Date()));
		toDoList.add(new BilyonerNumber(ObjectId.get().toHexString(), 2, new Date()));
		toDoList.add(new BilyonerNumber(ObjectId.get().toHexString(), 3, new Date()));
		when(bilyonerRepository.findAll()).thenReturn(toDoList);

		List<BilyonerNumber> result = bilyonerService.findAllNumbers();
		assertEquals(3, result.size());
	}

	@Test
	public void testFindOneNumber() {
		BilyonerNumber result = bilyonerService.findOneNumber(10000);
		assertNull(result);
	}

	@Test
	public void testDeleteNumberNotExists() {
		String result = bilyonerService.deleteNumber(3);
		assertEquals(result, "Number could not be found");
	}

	@Test
	public void testCreateNumber() {
		String result = bilyonerService.createNumber(365);
		assertEquals(result, "Number added successfully");
	}

}
