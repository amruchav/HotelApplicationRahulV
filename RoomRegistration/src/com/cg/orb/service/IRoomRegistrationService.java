package com.cg.orb.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.frs.exception.RoomException;
import com.cg.orb.dto.RoomRegistrationDTO;

public interface IRoomRegistrationService {
	int registerRoom(RoomRegistrationDTO flat) throws IOException, SQLException, RoomException;
	//public boolean isValidDetails(RoomRegistrationDTO flat) throws Exception;
	//boolean validHotelId(int id);
	

	boolean validTotalAmount(float rent, float paid);
	public boolean validHotelId(int id,ArrayList<Integer> list) throws RoomException;


	ArrayList<Integer> retrieveDetails();


	
}


