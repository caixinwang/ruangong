package com.neusoft.elm.view.impl;

import java.util.List;
import java.util.Scanner;

import com.neusoft.elm.dao.RoomDao;
import com.neusoft.elm.dao.impl.RoomDaoImpl;
import com.neusoft.elm.po.Room;
import com.neusoft.elm.view.RoomView;

public class RoomViewImpl implements RoomView {
	
	private Scanner input = new Scanner(System.in);

	@Override
	public List<Room> showRoomList(Integer businessId) {
		RoomDao dao = new RoomDaoImpl();
		List<Room> list = dao.listRoomByBusinessId(businessId);
		System.out.println("房间编号\t房间名称\t食品==房间介绍\t房间价格");
		for(Room food : list) {
			System.out.println(food.getRoomID()+"\t"+food.getRoomName()+"\t"+food.getRoomExplain()+"\t"+food.getRoomPrice());
		}
		return list;
	}
	
	@Override
	public void saveFood(Integer businessId) {
		Room food = new Room();
		System.out.println("请输入房间名称：");
		food.setRoomName(input.next());
		System.out.println("请输入房间介绍：");
		food.setRoomExplain(input.next());
		System.out.println("请输入房间价格：");
		food.setRoomPrice(input.nextDouble());
		food.setBusinessId(businessId);
		
		RoomDao dao = new RoomDaoImpl();
		int result = dao.saveRoom(food);
		if(result>0) {
			System.out.println("\n新增房间成功！\n");
		}else {
			System.out.println("\n新增房间失败！\n");
		}
	}
	
	@Override
	public void updateFood(Integer businessId) {
		RoomDao dao = new RoomDaoImpl();
		List<Room> list = showRoomList(businessId);
		
		if(list.size()==0) {
			System.out.println("没有任何房间！");
		}else {
			System.out.println("请选择要更新的房间编号：");
			int foodId = input.nextInt();
			Room food = dao.getRoomById(foodId);
			System.out.println(food);
			
			String inputStr = "";
			System.out.println("是否更新房间名称(y/n)：");
			inputStr = input.next();
			if(inputStr.equals("y")) {
				System.out.println("请输入新的房间名称：");
				food.setRoomName(input.next());
			}
			
			System.out.println("是否更新房间介绍(y/n)：");
			inputStr = input.next();
			if(inputStr.equals("y")) {
				System.out.println("请输入新的房间介绍：");
				food.setRoomExplain(input.next());
			}
			
			System.out.println("是否更新房间价格(y/n)：");
			inputStr = input.next();
			if(inputStr.equals("y")) {
				System.out.println("请输入新的房间价格：");
				food.setRoomPrice(input.nextDouble());
			}
			
			int result = dao.updateRoom(food);
			if(result>0) {
				System.out.println("\n修改房间成功！\n");
			}else {
				System.out.println("\n修改房间失败！\n");
			}
		}
	}
	
	@Override
	public void removeFood(Integer businessId) {
		RoomDao dao = new RoomDaoImpl();
		List<Room> list = showRoomList(businessId);
		
		if(list.size()==0) {
			System.out.println("没有任何房间！");
		}else {
			System.out.println("请选择要删除的房间编号：");
			int foodId = input.nextInt();
			
			System.out.println("确认要删除吗(y/n)：");
			if(input.next().equals("y")) {
				int result = dao.removeRoom(foodId);
				if(result>0) {
					System.out.println("\n删除房间成功！\n");
				}else {
					System.out.println("\n删除房间失败！\n");
				}
			}
		}
	}
}
