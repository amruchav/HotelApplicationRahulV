package com.cg.orb.dto;

public class RoomRegistrationDTO {
private int roomNumber;
private int hotelId;
private int roomType;
private int roomArea;
private float rentAmount;
private float paidAmount;
public int getRoomNumber() {
	return roomNumber;
}
public void setRoomNumber(int roomNumber) {
	this.roomNumber = roomNumber;
}
public int getHotelId() {
	return hotelId;
}
public void setHotelId(int hotelId) {
	this.hotelId = hotelId;
}
public int getRoomType() {
	return roomType;
}
public void setRoomType(int roomType) {
	this.roomType = roomType;
}
public int getRoomArea() {
	return roomArea;
}
public void setRoomArea(int roomArea) {
	this.roomArea = roomArea;
}
public float getRentAmount() {
	return rentAmount;
}
public void setRentAmount(float rentAmount) {
	this.rentAmount = rentAmount;
}
public float getPaidAmount() {
	return paidAmount;
}
public void setPaidAmount(float paidAmount) {
	this.paidAmount = paidAmount;
}
public RoomRegistrationDTO(int hotelId, int roomType, int roomArea,
		float rentAmount, float paidAmount) {
	super();
	this.hotelId = hotelId;
	this.roomType = roomType;
	this.roomArea = roomArea;
	this.rentAmount = rentAmount;
	this.paidAmount = paidAmount;
}
public RoomRegistrationDTO() {
	
}


}
