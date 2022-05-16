package com.neusoft.elm.po;

public class Room {

	private Integer RoomID;
	private String RoomName;
	private String RoomExplain;
	private Double RoomPrice;
	private Integer businessId;
	
	@Override
	public String toString() {
		return "\n房间编号："+this.RoomID +
			   "\n房间名称："+this.RoomName +
			   "\n房间介绍："+this.RoomExplain +
			   "\n房间价格："+this.RoomPrice +
			   "\n所属酒店："+this.businessId;
	}
	
	public Integer getRoomID() {
		return RoomID;
	}
	public void setRoomID(Integer roomID) {
		this.RoomID = roomID;
	}
	public String getRoomName() {
		return RoomName;
	}
	public void setRoomName(String roomName) {
		this.RoomName = roomName;
	}
	public String getRoomExplain() {
		return RoomExplain;
	}
	public void setRoomExplain(String roomExplain) {
		this.RoomExplain = roomExplain;
	}
	public Double getRoomPrice() {
		return RoomPrice;
	}
	public void setRoomPrice(Double roomPrice) {
		this.RoomPrice = roomPrice;
	}
	public Integer getBusinessId() {
		return businessId;
	}
	public void setBusinessId(Integer businessId) {
		this.businessId = businessId;
	}
}
