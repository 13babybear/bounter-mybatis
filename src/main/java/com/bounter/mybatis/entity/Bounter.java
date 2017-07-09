package com.bounter.mybatis.entity;

import java.io.Serializable;

public class Bounter implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String name;
	
	private String value;
	
	private Long timestamp;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

}
