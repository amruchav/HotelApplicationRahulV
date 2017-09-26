package com.cg.orb.ui;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.cg.frs.exception.RoomException;
import com.cg.orb.dto.RoomRegistrationDTO;
import com.cg.orb.service.IRoomRegistrationService;
import com.cg.orb.service.RoomRegistrationServiceImpl;

public class Client 
{
	static Scanner sc=new Scanner(System.in);
	static int choice=0;
	static RoomRegistrationDTO flat=null;
	static IRoomRegistrationService Service=new RoomRegistrationServiceImpl();
	public static void main(String[] args) throws RoomException, IOException, SQLException 
	{
		System.out.println("Room Registration Application");
		while(true)
		{
			System.out.println("1.Booking Room");
			System.out.println("2.Exit");
			System.out.println("Enter your choice:1 or 2");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:getRoomDetails();
			break;
			case 2:
				System.out.println("Thank you.");
				System.exit(0);
			break;
			}
		}
	}
		private static void getRoomDetails() throws RoomException, IOException, SQLException {
			int res=0;
			sc.nextLine();
			//Service=new RoomRegistrationServiceImpl();
			ArrayList<Integer> list = Service.retrieveDetails();
			System.out.println("Existing HotelOwner IDS Are:- "+list);
			try{
			System.out.println("Please enter your hotel owner id from above list:");
			int id=sc.nextInt();
			if(Service.validHotelId(id, list))
			{
			System.out.println("Select  room type Type (1-1AC, 2-2NON-AC):");
			int type=sc.nextInt();
			//if(Service.validRoomType(type))
			//{
			System.out.println("Enter room area in sq. ft.:");
			int area=sc.nextInt();
			
			System.out.println("Enter desired rent amount Rs:");
			float rent=sc.nextInt();
			System.out.println("Enter desired paid amount Rs:");
			float paid=sc.nextInt();
			if(Service.validTotalAmount(rent,paid))
			{
				flat=new RoomRegistrationDTO(id,type,area,rent,paid);
				
				res = Service.registerRoom(flat);
				System.out.println("Room no: "+res);
				
				if(res>0)
				{
					System.out.println("Value added in database");
					
				}
				else
				{
					System.out.println("Value not added");
				}
				}}
			
			
			}
			catch(RoomException e){
				System.out.println(e);
			}
			
		}
			
}	

		
		
		
	
