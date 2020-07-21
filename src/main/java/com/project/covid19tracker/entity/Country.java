package com.project.covid19tracker.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="country")
public class Country {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="country_name")
//	@ElementCollection
//	private List<String> countryName= new ArrayList<String>();
	private String countryName;
	
	@Column(name="active_case")
	private int activeCase;
	
	@Column(name="total_death")
	private int totalDeathCase;
	
	@Column(name="total_recovered")
	private int totalRecovered;
	
	@Column(name="total_case")
	private int totalCase;
	
	@Column(name="today_case")
	private int todayCase;
	
	@Column(name="today_death")
	private int todayDeath;
	
	@Column(name="today_recovered")
	private int todayRecovered;
	
	public Country() {
		
	}

	public Country(Long id, String countryName, int activeCase, int totalDeathCase, int totalRecovered, int totalCase,
			int todayCase, int todayDeath, int todayRecovered) {
		super();
		this.id = id;
		this.countryName = countryName;
		this.activeCase = activeCase;
		this.totalDeathCase = totalDeathCase;
		this.totalRecovered = totalRecovered;
		this.totalCase = totalCase;
		this.todayCase = todayCase;
		this.todayDeath = todayDeath;
		this.todayRecovered = todayRecovered;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public int getActiveCase() {
		return activeCase;
	}

	public void setActiveCase(int activeCase) {
		this.activeCase = activeCase;
	}

	public int getTotalDeathCase() {
		return totalDeathCase;
	}

	public void setTotalDeathCase(int totalDeathCase) {
		this.totalDeathCase = totalDeathCase;
	}

	public int getTotalRecovered() {
		return totalRecovered;
	}

	public void setTotalRecovered(int totalRecovered) {
		this.totalRecovered = totalRecovered;
	}

	public int getTotalCase() {
		return totalCase;
	}

	public void setTotalCase(int totalCase) {
		this.totalCase = totalCase;
	}

	public int getTodayCase() {
		return todayCase;
	}

	public void setTodayCase(int todayCase) {
		this.todayCase = todayCase;
	}

	public int getTodayDeath() {
		return todayDeath;
	}

	public void setTodayDeath(int todayDeath) {
		this.todayDeath = todayDeath;
	}

	public int getTodayRecovered() {
		return todayRecovered;
	}

	public void setTodayRecovered(int todayRecovered) {
		this.todayRecovered = todayRecovered;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", countryName=" + countryName + ", activeCase=" + activeCase + ", totalDeathCase="
				+ totalDeathCase + ", totalRecovered=" + totalRecovered + ", totalCase=" + totalCase + ", todayCase="
				+ todayCase + ", todayDeath=" + todayDeath + ", todayRecovered=" + todayRecovered + "]";
	}


}
