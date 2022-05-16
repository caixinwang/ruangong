package com.neusoft.elm.dao;

import java.util.List;

import com.neusoft.elm.po.Room;

public interface RoomDao {

	public List<Room> listRoomByBusinessId(Integer businessId);
	public int saveRoom(Room food);
	public Room getRoomById(Integer foodId);
	public int updateRoom(Room food);
	public int removeRoom(Integer foodId);
}
