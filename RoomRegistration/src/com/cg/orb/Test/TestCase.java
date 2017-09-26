package com.cg.orb.Test;
import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.Test;
import org.junit.BeforeClass;



import com.cg.frs.dao.RoomRegistrationDAOImpl;
import com.cg.orb.dto.RoomRegistrationDTO;
import com.cg.frs.exception.RoomException;

	
	public class TestCase {
		static com.cg.frs.dao.IRoomRegistrationDAO dao=null;
		static com.cg.orb.dto.RoomRegistrationDTO bean=null;
		
		
		@BeforeClass
		public static void initialize() throws RoomException
		{
			System.out.println("hi");
			dao=new RoomRegistrationDAOImpl();
			bean=new RoomRegistrationDTO();
		}
		

		@Test
		public void test() {
			
			bean.setHotelId(1);;
			bean.setRoomNumber(1001);;
			bean.setRoomType(1);;
			bean.setRoomArea(20);;
			bean.setRentAmount(30);;
			bean.setPaidAmount(40);;
		}
			 

	@Test

	public void testAddDetails() throws RoomException, IOException, SQLException {
		assertNotNull(dao.registerRoom(bean));
	}


	@Test

	public void getDetails()
	{
		assertNotNull(dao.retrieveDetails());
	}
	} 
