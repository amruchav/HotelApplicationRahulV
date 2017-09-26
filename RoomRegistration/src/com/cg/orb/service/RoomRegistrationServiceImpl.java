package com.cg.orb.service;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cg.frs.dao.IRoomRegistrationDAO;
import com.cg.frs.dao.RoomRegistrationDAOImpl;
import com.cg.frs.exception.RoomException;
import com.cg.orb.dto.RoomRegistrationDTO;

public class RoomRegistrationServiceImpl implements IRoomRegistrationService {
	IRoomRegistrationDAO dao=null;
	@Override
	public int registerRoom(RoomRegistrationDTO flat) throws IOException, SQLException, RoomException {
		dao=new RoomRegistrationDAOImpl();
		return dao.registerRoom(flat);
		
		
	}

	/*@Override
	public boolean validHotelId(int id) {
		if(id==1||id==2||id==3)
		{
			return true;
		}
		else{
			System.out.println("Hotel Owner ID does not exist");
			return false;
	}
	}

	@Override
	public boolean validRoomType(int type) {
		if(type==1||type==2)
		{
			return true;
		}
		else
		{
			System.out.println("Please select from these two mentioned only");
			return false;
		}
		
	}*/

	@Override
	public boolean validTotalAmount(float rent, float paid) {
		if(paid>rent)
		{
			return true;
		}
		else
		{
			System.out.println("Paid amount should not be less than rent amount.");
			return false;
		}
		
	}
	/*public boolean isValidDetails(RoomRegistrationDTO flat) throws Exception{
		List<String> validation=new ArrayList<String>();
		boolean set=true;
		
		if(!(validHotelId(flat.getHotelId()))){
			validation.add("\n It should be from the above mentioned list");
		}

		if(!(validRoomType(flat.getRoomType()))){
			validation.add("\n It should be from the above mentioned list");
		}
		if(!(validTotalAmount(flat.getRentAmount(),flat.getPaidAmount())))
		{
			validation.add("\n Paid amount should not be less than rent amount.");
		}
		if(!(validation.isEmpty()))
		{
			set=false;
			throw new Exception(validation+"");
		}
		return true;
	}*/

	public boolean validHotelId(int id,ArrayList<Integer> list) throws RoomException
	{
		
		if(list.contains(id)){
			return true; 
		}
		else {
			throw new RoomException(id);
		}
		/*boolean flag=false;
		for(Integer out:list)
		{
			if(out==id){
				flag=true;
				break;
			}
		}
		return flag;*/
	}

	@Override
	public ArrayList<Integer> retrieveDetails() {
		// TODO Auto-generated method stub
		dao=new RoomRegistrationDAOImpl();
		return dao.retrieveDetails();
	}

	


	

}
