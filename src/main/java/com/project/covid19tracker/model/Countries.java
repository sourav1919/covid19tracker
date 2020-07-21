package com.project.covid19tracker.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;







@JsonIgnoreProperties(ignoreUnknown=true)
public class Countries {

	private Long  updated;
	private String country;
	private CountryInfo countryInfo;
	private int todayCases;
	private int todayDeaths;
	private int todayRecovered;
	private int deaths;
	private int active;
	private int cases;
	private int recovered;
//	private Response value;
//	private int todayCases;
//	private int todayDeaths;
	
	
	public Countries() {
		
	}


	public long getUpdated() {
		return updated;
	}


	public void setUpdated(long updated) {
		this.updated = updated;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public CountryInfo getCountryInfo() {
		return countryInfo;
	}


	public void setCountryInfo(CountryInfo countryInfo) {
		this.countryInfo = countryInfo;
	}


	public int getTodayCases() {
		return todayCases;
	}


	public void setTodayCases(int todayCases) {
		this.todayCases = todayCases;
	}


	public int getTodayDeaths() {
		return todayDeaths;
	}


	public void setTodayDeaths(int todayDeaths) {
		this.todayDeaths = todayDeaths;
	}


	public int getDeaths() {
		return deaths;
	}


	public void setDeaths(int deaths) {
		this.deaths = deaths;
	}


	public int getActive() {
		return active;
	}


	public void setActive(int active) {
		this.active = active;
	}


	public int getTodayRecovered() {
		return todayRecovered;
	}


	public void setTodayRecovered(int todayRecovered) {
		this.todayRecovered = todayRecovered;
	}


	public int getCases() {
		return cases;
	}


	public void setCases(int cases) {
		this.cases = cases;
	}


	public int getRecovered() {
		return recovered;
	}


	public void setRecovered(int recovered) {
		this.recovered = recovered;
	}
	
	
	

//	public Response getValue() {
//		return value;
//	}
//
//
//	public void setValue(Response value) {
//		this.value = value;
//	}



//
//	@Override
//	public String toString() {
//		return "Countries [value=" + value + "]";
//	}



	
//	public String getCountry() {
//		return country;
//	}
//
//	public void setCountry(String country) {
//		this.country = country;
//	}

//	public int getTodayCases() {
//		return todayCases;
//	}
//
//	public void setTodayCases(int todayCases) {
//		this.todayCases = todayCases;
//	}
//
//	public int getTodayDeaths() {
//		return todayDeaths;
//	}
//
//	public void setTodayDeaths(int todayDeaths) {
//		this.todayDeaths = todayDeaths;
//	}

//	@Override
//	public String toString() {
//		return "Countries [country=" + country + ", todayCases=" + todayCases + ", todayDeaths=" + todayDeaths + "]";
//	}
//	
	
	
}
