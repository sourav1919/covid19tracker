package com.project.covid19tracker;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import com.project.covid19tracker.model.Countries;

@SpringBootApplication
public class Covid19trackerApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(Covid19trackerApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(Covid19trackerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
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
		List<String> countryName=new ArrayList<String>();
		List<Integer> activeCase=new ArrayList<Integer>();
		List<Integer> totalDeathCase=new ArrayList<Integer>();
		List<Integer> totalRecovered=new ArrayList<Integer>();
		List<Integer> totalCase=new ArrayList<Integer>();
		List<Integer> todayCase=new ArrayList<Integer>();
		List<Integer> todayDeath=new ArrayList<Integer>();
		List<Integer> todayRecovered=new ArrayList<Integer>();
		for(Countries countries : list) {
			
//			System.out.println("Country name :"+countries.getCountry());
			countryName.add(countries.getCountry());
			activeCase.add(countries.getActive());
			totalDeathCase.add(countries.getDeaths());
			totalRecovered.add(countries.getRecovered());
			totalCase.add(countries.getCases());
			todayCase.add(countries.getTodayCases());
			todayDeath.add(countries.getTodayDeaths());
			todayRecovered.add(countries.getTodayRecovered());
//			System.out.println("Today case :"+countries.getTodayCases());
//			System.out.println("Today Deaths :" +countries.getTodayDeaths());
//			System.out.println("Today Recovered :"+countries.getTodayRecovered());
//			System.out.println("Total Deaths :"+countries.getDeaths());
//			System.out.println("Total Active :"+countries.getActive());
//			System.out.println("Total case :"+countries.getCases());
			
//			System.out.println("----------------");
		}
		System.out.println("countryName"+countryName);
		System.out.println("activeCase"+activeCase);
		System.out.println("totalDeathCase"+totalDeathCase);
		System.out.println("totalRecovered"+totalRecovered);
		System.out.println("totalCase"+totalCase);
		System.out.println("todayCase"+todayCase);
		System.out.println("todayDeath"+todayDeath);
		System.out.println("todayRecovered"+todayRecovered);
	}
}
//		JSONParser parse=new JSONParser();
//		
//		JSONObject jobj=(JSONObject)parse.parse(inline);
//		JSONArray jsonarr=(JSONArray)jobj.get(0);
//		
//		for(int i=0;i<jsonarr.size();i++) {
//			JSONObject jsonobj=(JSONObject)jsonarr.get(i);
//			System.out.println(jsonobj.get("country"));
//		}
//	}
//				String json = HttpUtil.decodePath(url);
//		 JSONArray jsonarray = new JSONArray(new URL(url1));
//		 for (int i = 0; i < jsonarray.length(); i++) {
//		     JSONObject jsonobject = jsonarray.getJSONObject(i);
//		     String name = jsonobject.getString("country");
//		     String url = jsonobject.getString("todayDeaths");
//		     System.out.println(name);
		 
		 
//		JSONParser jsonParser =new JSONParser();
//		JSONObject jsonObject=(JSONObject)jsonParser.parse(new URL("https://corona.lmao.ninja/v3/covid-19/countries"));
//		RestTemplate restTemplate = new RestTemplate();
//		Countries response= restTemplate.getForObject("https://gturnquist-quoters.cfapps.io/api/random",Countries.class);
//		log.info("Data "+response.toString());
//	}

//}
