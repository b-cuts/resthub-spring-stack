package org.resthub.booking.dao;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.resthub.booking.model.Hotel;
import org.resthub.core.test.dao.AbstractResourceDaoTest;

public class TestHotelDao extends AbstractResourceDaoTest<Hotel, HotelDao> {

	private static final String CHANGED_TEST_HOTEL_NAME = "changedTestHotelName";
	private static final String TEST_HOTEL_NAME = "testHotelName";

	@Override
	@Inject
	@Named("hotelDao")
	public void setResourceDao(HotelDao hotelDao) {
		this.resourceDao = hotelDao;
	}
	
	@Override
	protected Hotel createTestRessource() throws Exception {
		Hotel hotel = new Hotel();
		hotel.setName(TEST_HOTEL_NAME);
		hotel.setAddress("testHotelAddress");
		hotel.setCity("testHotelCity");
		hotel.setZip("ZIP");
		hotel.setCountry("testHotelCountry");
		return hotel;
	}

	@Override
	public void testUpdate() throws Exception {
		
		List<Hotel> hotels = this.resourceDao.findEquals("name", TEST_HOTEL_NAME);
		assertTrue("hotels list should contain an unique result", hotels.size() == 1);
		
		Hotel hotel = hotels.get(0);
		hotel.setName(CHANGED_TEST_HOTEL_NAME);
		hotel = this.resourceDao.save(hotel);
		assertEquals("hotel name should have been modified", CHANGED_TEST_HOTEL_NAME, hotel.getName());
	}



}