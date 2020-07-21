package com.project.covid19tracker.service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.project.covid19tracker.entity.Country;
import com.project.covid19tracker.model.Countries;
import com.project.covid19tracker.repository.CountryRepository;

@Service
public class CountryService {

	@Autowired
	private CountryRepository countryRepository;

	
	public CountryService(CountryRepository countryRepository) {
		this.countryRepository=countryRepository;
	}
	
	@PostConstruct
	public void saveData() throws IOException {
		String inline="";
		URL url=new URL("https://corona.lmao.ninja/v3/covid-19/countries");
		HttpURLConnection conn=(HttpURLConnection)url.openConnection();
		conn.setRequestMethod("GET");
		conn.connect();
		
		int responsecode=conn.getResponseCode();
		
		if(responsecode!=200)
			throw new RuntimeException("HttpRespnseCode"+responsecode);
		else {
		Scanner sc=new Scanner(url.openStream());
			while(sc.hasNext())
			{
				inline+=sc.nextLine();
			}
			System.out.println(inline);
			sc.close();
		}
		
		ObjectMapper mapper = new ObjectMapper();
		List<Countries> list = mapper.readValue(inline,TypeFactory.defaultInstance().constructCollectionType(List.class, Countries.class));

		for(Countries countries : list) {
			
			Country country=new Country();
			country.setTodayDeath(countries.getTodayDeaths());
			country.setTodayRecovered(countries.getTodayRecovered());;
			country.setTodayCase(countries.getTodayCases());
			country.setTotalRecovered(countries.getRecovered());
			country.setTotalDeathCase(countries.getDeaths());
			country.setTotalCase(countries.getCases());
			country.setActiveCase(countries.getActive());
			country.setCountryName(countries.getCountry());
			countryRepository.save(country);
		}	
	}
}
