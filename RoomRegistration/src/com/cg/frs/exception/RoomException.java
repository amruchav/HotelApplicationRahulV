package com.cg.frs.exception;

public class RoomException extends Exception {

	/*public RoomException(String message) {
		
		super(message);

	}
	*/
	
	
	int data;
	public RoomException(int data){
		
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "This id = [" + data + "] does not exist in the database \n\n";
	}
	
	
	
}
