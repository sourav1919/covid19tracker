package com.covid19tracker.Service;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.covid19tracker.Driver.Driver;
import com.covid19tracker.Model.Countries;
import com.covid19tracker.Model.Daywise;
import com.covid19tracker.Model.Total;
import com.covid19tracker.repository.TotalsRepository;

@Service
public class Schedular {

	@Autowired
	private APIService service;
	
	@Autowired
	private Driver driver;
	
	
	
//	@Autowired
//	private TotalsRepository theTotalRepository;
	
	private List<Countries> listCountries;
	
	
	@Scheduled(cron="0 0 */1 * * *")  // Run in every 1hours
	public void updateCountries() {
//		Long b=(long) 0;
		System.out.println("***********in scheduler Countries***************");
		listCountries=driver.driverCountries();
		service.setAllCountries(listCountries);
		System.out.println("*********out of scheduler Countries**********");
		System.out.println("***********in scheduler Total***************");
		Total total=driver.driverTotal();
//		List<Total> getTotalResponse=theTotalRepository.findFirstByOrderByLocalDateTimeDesc();
//		for(Total to : getTotalResponse) {
//			 b=to.getUpdates();
//		}
//		if(b>37) {
//			theTotalRepository.deleteAll();
			service.setAllTotal(total);
			System.out.println("*********out of scheduler Total**********");
//		}
//		else
//		{
//		service.setAllTotal(total);
//		System.out.println("*********out of scheduler update Total**********");
	}
	
	

//	public void onEmergency() throws IOException {
//	
//		System.out.println("***********in scheduler Countries***************");
//	listCountries=driver.driverCountries();
//	service.setAllCountries(listCountries);
//	System.out.println("*********out of scheduler Countries**********");
//	System.out.println("***********in scheduler Total***************");
//	Total total=driver.driverTotal();
//	service.setAllTotal(total);
//	System.out.println("*********out of scheduler Total**********");
//	}
	
	
	@Scheduled(cron="0 0 13 * * *")  //every day at 1pm
	public void updateDaywise() {
	System.out.println("***********in scheduler Daywise***************");
	List<List<Daywise>> listOfListDaywise=driver.driverDaywise();
	service.setAllDaywise(listOfListDaywise);
	System.out.println("*********out of scheduler Daywise**********");
	}
	
}
