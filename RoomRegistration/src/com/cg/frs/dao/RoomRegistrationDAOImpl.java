package com.cg.frs.dao;

import java.beans.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.frs.DbUtil.DbUtil;
import com.cg.frs.exception.RoomException;
import com.cg.orb.dto.RoomRegistrationDTO;

public class RoomRegistrationDAOImpl implements IRoomRegistrationDAO{
	Connection conn=null;
	Logger logger=Logger.getRootLogger();
	public RoomRegistrationDAOImpl(){
		PropertyConfigurator.configure("log4j.properties");	 
		
	}
	
	@Override
	public int registerRoom(RoomRegistrationDTO flat) throws RoomException {
		int result=0, id=0;
		try{
		conn=DbUtil.getConnection();
		String insertQuery="Insert into room_registration values(room_no.nextval,?,?,?,?,?)";
		PreparedStatement ps=conn.prepareStatement(insertQuery);
		ps.setInt(1,flat.getHotelId());
		ps.setInt(2,flat.getRoomType());
		ps.setInt(3,flat.getRoomArea());
		ps.setFloat(4, flat.getRentAmount());
		ps.setFloat(5, flat.getPaidAmount());
		result = ps.executeUpdate();
		System.out.println(result+" row inserted");
		String selectQuery = "SELECT room_no.CURRVAL FROM room_registration";
		java.sql.Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(selectQuery);
		
		while(rs.next()){
			id = rs.getInt(1);
		}
		
		
		System.out.println("Room successfully registered.");
		
		logger.info("Execute successfully");
		return id;
	}
		catch(IOException e){
			logger.error("Error Occured");
			e.printStackTrace();
		}
		catch(SQLException e){
			logger.error("Error Occured");
			System.out.println(e.getMessage());
		}
		return result;
		
		
	}
		
		@Override
		public ArrayList<Integer> retrieveDetails() {
			// TODO Auto-generated method stub
			ArrayList<Integer> list=new ArrayList<Integer>();
			int id=0;
			try
			{
				conn=DbUtil.getConnection();
				String selectquery1="select hotel_ID from hotel_owners";
				PreparedStatement ps=conn.prepareStatement(selectquery1);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next())
				{
					id=rs.getInt(1);
					list.add(id);
					
				}
			}
			catch(SQLException|IOException e)
			{
				logger.error("Error Occured");
				System.out.println(e.getMessage());
			}
			
			return list;
		}

		
}
