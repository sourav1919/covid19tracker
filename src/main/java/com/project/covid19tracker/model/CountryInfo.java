package com.project.covid19tracker.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class CountryInfo {
	
	private List<Countries> countryInfo;

	public List<Countries> getCountryInfo() {
		return countryInfo;
	}

	public void setCountryInfo(List<Countries> countryInfo) {
		this.countryInfo = countryInfo;
	}
	
	

}
