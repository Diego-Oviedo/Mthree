package com.diego.DVDLibrary.dao.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.*;
import com.diego.DVDLibrary.dao.*;
import com.diego.DVDLibrary.dto.Item;

@Component
class DVDLibraryDAOImplTest {
	
	@Autowired
	@Qualifier("dao")
	private DVDLibraryDAO dao_test;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {//set the known good state before each test.
		
		Date current_date = new Date();
		SimpleDateFormat date_formatted = new SimpleDateFormat("yyyy-MM-dd:HH-mm-ss");
		String transaction_date = date_formatted.format(current_date);
		
		String testFile = "DVD_Library_TEST_"+transaction_date.toString()+".txt";
		new FileWriter(testFile);
		dao_test = new DVDLibraryDAOImpl(testFile);
	}
	
	/***************************************************************************************************************/
	
	@Test
	void testAddGetDVD() throws DVDLibraryExceptionDAO {
		Item retreived_dvd;
		//ARRANGE
		Item dvd_test = new Item("0001");
		dvd_test.setTitle("House of Cards");
		dvd_test.setRelease_date(dvd_test.yearToDateFormatter("2020"));
		dvd_test.setMPAA_rating(7.9);
		dvd_test.setAuthor("Michael Collins");
		dvd_test.setStudio("Marvel");
		dvd_test.setUser_note("N/A");
		
		String sku = dvd_test.getSKU();//I am storing the sku into a String as I have a key generator over my DAO
		
		//ACT
		dao_test.addDVD(dvd_test.getSKU(), dvd_test);
		
		
		//ACT & ASSERT
		retreived_dvd = dao_test.findDVDByTitle(dvd_test.getTitle());
		assertEquals(retreived_dvd,dvd_test,"Checking Object matches");
		
		
		//ASSERT
		assertEquals(dvd_test.getSKU(),retreived_dvd.getSKU(),"Checking SKU matches");
		
		assertEquals(dvd_test.getTitle(),retreived_dvd.getTitle(),"Checking Title matches");
		
		assertEquals(dvd_test.getRelease_date(),retreived_dvd.getRelease_date(),"Checking Release Date matches");
		
		assertEquals(dvd_test.getMPAA_rating(),retreived_dvd.getMPAA_rating(),"Checking MPAA Rating matches");
		
		assertEquals(dvd_test.getAuthor(),retreived_dvd.getAuthor(),"Checking Author matches");
		
		assertEquals(dvd_test.getStudio(),retreived_dvd.getStudio(),"Checking Studio matches");
		
		assertEquals(dvd_test.getUser_note(),retreived_dvd.getUser_note(),"Checking User Note matches");
		
	}
	
	@Test
	void testGetAllDVDs() throws DVDLibraryExceptionDAO {
		//ARRANGE
		Item dvd_test_01 = new Item("0001");
		dvd_test_01.setTitle("House of Cards");
		dvd_test_01.setRelease_date(dvd_test_01.yearToDateFormatter("2020"));
		dvd_test_01.setMPAA_rating(7.9);
		dvd_test_01.setAuthor("Michael Collins");
		dvd_test_01.setStudio("Marvel");
		dvd_test_01.setUser_note("N/A");
		
		Item dvd_test_02 = new Item("0002");
		dvd_test_02.setTitle("Breaking Bad");
		dvd_test_02.setRelease_date(dvd_test_02.yearToDateFormatter("2010"));
		dvd_test_02.setMPAA_rating(9.9);
		dvd_test_02.setAuthor("Michael Collins & friends");
		dvd_test_02.setStudio("Dreamworks");
		dvd_test_02.setUser_note("N/A");
		
		String sku_dvd_01 = dvd_test_01.getSKU();//I am storing the sku into a String as I have a key generator over my DAO
		String sku_dvd_02 = dvd_test_02.getSKU();//I am storing the sku into a String as I have a key generator over my DAO
		
	
		//ACT
		
		dao_test.addDVD(sku_dvd_01, dvd_test_01);
		dao_test.addDVD(sku_dvd_02, dvd_test_02);
		
		List<Item> allDVDs =dao_test.retreiveAllDVDs();
		
		//ASSERT
		assertNotNull(allDVDs,"The list of DVDs must not be null");
		assertTrue(dao_test.retreiveAllDVDs().contains(dvd_test_01),"The listshould contain the test object dvd_test_01 created");
		assertTrue(dao_test.retreiveAllDVDs().contains(dvd_test_02),"The listshould contain the test object dvd_test_02 created");
		
	}
	
	@Test
	void testRemoveDVD() throws DVDLibraryExceptionDAO {
		List<Item> dvds = dao_test.retreiveAllDVDs();

		//ARRANGE
		Item dvd_test_01 = new Item("HOMA02020");
		dvd_test_01.setTitle("House of Cards");
		dvd_test_01.setRelease_date(dvd_test_01.yearToDateFormatter("2020"));
		dvd_test_01.setMPAA_rating(7.9);
		dvd_test_01.setAuthor("Michael Collins");
		dvd_test_01.setStudio("Marvel");
		dvd_test_01.setUser_note("N/A");
		
		Item dvd_test_02 = new Item("BRDR02010");
		dvd_test_02.setTitle("Breaking Bad");
		dvd_test_02.setRelease_date(dvd_test_02.yearToDateFormatter("2010"));
		dvd_test_02.setMPAA_rating(9.9);
		dvd_test_02.setAuthor("Michael Collins & friends");
		dvd_test_02.setStudio("Dreamworks");
		dvd_test_02.setUser_note("N/A");
		
		String sku_dvd_01 = dvd_test_01.getSKU();//I am storing the sku into a String as I have a key generator over my DAO (HOMA02020)
		String sku_dvd_02 = dvd_test_02.getSKU();//I am storing the sku into a String as I have a key generator over my DAO (BRDR02010)
		
		
		
		dao_test.addDVD(sku_dvd_01, dvd_test_01);
		dao_test.addDVD(sku_dvd_02, dvd_test_02);
		
		//ACT
		
		Item dvd_removed = dao_test.removeDVD(dvd_test_01.getSKU());
		dvds = dao_test.retreiveAllDVDs();

		//ASSERT
		assertNotNull(dao_test.retreiveAllDVDs(),"The list of DVDs must not be null");
		assertNotNull(dvd_removed,"The returning value should be the element deleted and not null");
		assertEquals(sku_dvd_01,dvd_removed.getSKU(),"The returning value should be the element deleted");
		assertFalse(dvds.contains(dvd_test_01), "The list should NOT contain the element deleted");
		assertTrue(dvds.contains(dvd_test_02), "The list should contain the element remaining");
		
		//ACT 
		dvd_removed = dao_test.removeDVD(dvd_test_02.getSKU());
		dvds = dao_test.retreiveAllDVDs();
		
		
		//ASSERT
		assertTrue(dao_test.retreiveAllDVDs().isEmpty(),"The list of DVDs should be now null");
		assertNotNull(dvd_removed,"The returning value should be the element deleted and not null");
		assertEquals(sku_dvd_02,dvd_removed.getSKU(),"The returning value should be the element deleted");
		assertFalse(dvds.contains(dvd_test_01), "The list should NOT contain the element deleted");
		assertFalse(dvds.contains(dvd_test_02), "The list should contain the element remaining");
		
		
		
	}
	
	@Test
	void testUpdateDVD() throws DVDLibraryExceptionDAO {
		List<Item> dvds = dao_test.retreiveAllDVDs();
		
		//ARRANGE
		Item dvd_test_01 = new Item("HOMA02020");
		dvd_test_01.setTitle("House of Cards");
		dvd_test_01.setRelease_date(dvd_test_01.yearToDateFormatter("2020"));
		dvd_test_01.setMPAA_rating(7.9);
		dvd_test_01.setAuthor("Michael Collins");
		dvd_test_01.setStudio("Marvel");
		dvd_test_01.setUser_note("N/A");
		
		Item dvd_test_02 = new Item("BRDR02010");
		dvd_test_02.setTitle("Breaking Bad");
		dvd_test_02.setRelease_date(dvd_test_02.yearToDateFormatter("2010"));
		dvd_test_02.setMPAA_rating(9.9);
		dvd_test_02.setAuthor("Michael Collins & friends");
		dvd_test_02.setStudio("Dreamworks");
		dvd_test_02.setUser_note("N/A");
		
		
		dao_test.addDVD(dvd_test_01.getSKU(), dvd_test_01);
		dao_test.addDVD(dvd_test_02.getSKU(), dvd_test_02);
		dvds = dao_test.retreiveAllDVDs();
		
		Item dvd_test_01_updated = new Item();
		dvd_test_01_updated.setTitle("Spiderman");//Data modified
		dvd_test_01_updated.setRelease_date(dvd_test_01_updated.yearToDateFormatter("2015"));//Data modified
		dvd_test_01_updated.setMPAA_rating(7.9);
		dvd_test_01_updated.setAuthor("Michael Mayers");//Data modified
		dvd_test_01_updated.setStudio("Dreamworks");//Data modified
		dvd_test_01_updated.setUser_note("N/A");
		
		Item dvd_test_02_updated = new Item();
		dvd_test_02_updated.setTitle("UP");//Data modified
		dvd_test_02_updated.setRelease_date(dvd_test_02_updated.yearToDateFormatter("2017"));//Data modified
		dvd_test_02_updated.setMPAA_rating(9.9);
		dvd_test_02_updated.setAuthor("Michael Ashton");//Data modified
		dvd_test_02_updated.setStudio("Marvel");//Data modified
		dvd_test_02_updated.setUser_note("N/A");
		
		
		//ACT	
		String SKU_01 = dvd_test_01.getSKU();
		String SKU_02 = dvd_test_02.getSKU();

		
		Item dvd_updates_01 = dao_test.updateDVD(SKU_01, dvd_test_01_updated);
		Item dvd_updates_02 = dao_test.updateDVD(SKU_02, dvd_test_02_updated);
		dvds = dao_test.retreiveAllDVDs();
		
		//ASSERT
		assertFalse(dvds.contains(dvd_test_01), "The list should NOT contain the previous version of element updated");
		assertFalse(dvds.contains(dvd_test_02), "The list should NOT contain the previous version of element updated");
		assertTrue(dvds.contains(dvd_test_01_updated), "The list should contain the element updated");
		assertTrue(dvds.contains(dvd_test_02_updated), "The list should contain the element updated");
		assertNotEquals(dvd_test_01_updated.getSKU(), dvd_test_01.getSKU(), "The SKU for both objects must be different.");
		assertNotEquals(dvd_test_02_updated.getSKU(), dvd_test_02.getSKU(), "The SKU for both objects must be different.");
		
	}
	
	
	/**************************************************************************************************************/

	@AfterEach
	void tearDown() throws Exception {
	}

	

}
