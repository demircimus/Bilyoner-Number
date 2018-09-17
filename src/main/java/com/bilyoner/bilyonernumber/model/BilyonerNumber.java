package com.bilyoner.bilyonernumber.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "numbers")
public class BilyonerNumber {
	
	@Id
	private String id;
	private Integer value;
	private Date createDate;
	
	public BilyonerNumber(String id, int value, Date createDate) {
		this.id = id;
		this.value = value;
		this.createDate = createDate;
	}
	public BilyonerNumber() {

	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	

}
