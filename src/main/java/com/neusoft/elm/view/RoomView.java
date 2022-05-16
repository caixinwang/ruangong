package com.neusoft.elm.view;

import java.util.List;

import com.neusoft.elm.po.Room;

public interface RoomView {

	public List<Room> showRoomList(Integer businessId);
	public void saveFood(Integer businessId);
	public void updateFood(Integer businessId);
	public void removeFood(Integer businessId);
}
