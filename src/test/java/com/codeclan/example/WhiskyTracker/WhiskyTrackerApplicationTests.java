package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@ActiveProfiles("test") //Indicates it's a test profile so will not run DataLoader
@SpringBootTest
public class WhiskyTrackerApplicationTests {
	@Autowired
	WhiskyRepository whiskyRepository;
	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}
	//MVP
	@Test
	public void canGetWhiskeisByYear(){
		List<Whisky> whiskiesByYear = whiskyRepository.findWhiskiesByYear(2018);
		assertTrue(!whiskiesByYear.isEmpty());
	}
	//extension
	@Test
	public void canGetWhiskyByRegion(){
		List<Whisky> whiskies = whiskyRepository.findByDistilleryRegion("Highland");
//		assertTrue(!whiskies.isEmpty());

	}
	@Test
	public void canGetDistilleriesByWhiskyAge(){
		List<Distillery> distilleries = distilleryRepository.findByWhiskiesAge(12);
		assertTrue(!distilleries.isEmpty());
	}
	@Test
	public void canGetDistillerByRegion(){
		List<Distillery> distilleriesByRegion = distilleryRepository.findByRegion("Island");
		assertTrue(!distilleriesByRegion.isEmpty());
	}
//	@Test
//	public void canGetWhiskyByAgeAndDistillery(){
//		List<Whisky> whiskiesByAgeAndDistillery = whiskyRepository.findByAgeAndDistilleryId(12, distilleryRepository.getById(1L);
//		assertTrue(!whiskiesByAgeAndDistillery.isEmpty());
//	}


}
