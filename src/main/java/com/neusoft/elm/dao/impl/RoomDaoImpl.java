package com.neusoft.elm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neusoft.elm.dao.RoomDao;
import com.neusoft.elm.po.Room;
import com.neusoft.elm.util.DBUtil;

public class RoomDaoImpl implements RoomDao {
	
	private Connection con = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;

	@Override
	public List<Room> listRoomByBusinessId(Integer businessId) {
		List<Room> list = new ArrayList<>();
		String sql = "select * from food where businessId=?";
		try {
			con = DBUtil.getConnection();
			pst = con.prepareStatement(sql);
			pst.setInt(1, businessId);
			rs = pst.executeQuery();
			while(rs.next()) {
				Room food = new Room();
				food.setRoomID(rs.getInt("roomId"));
				food.setRoomName(rs.getString("roomName"));
				food.setRoomExplain(rs.getString("roomExplain"));
				food.setRoomPrice(rs.getDouble("roomPrice"));
				food.setBusinessId(rs.getInt("businessId"));
				list.add(food);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, pst, con);
		}
		return list;
	}
	
	@Override
	public int saveRoom(Room food) {
		int result = 0;
		String sql = "insert into food values(null,?,?,?,?)";
		try {
			con = DBUtil.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, food.getRoomName());
			pst.setString(2, food.getRoomExplain());
			pst.setDouble(3, food.getRoomPrice());
			pst.setInt(4, food.getBusinessId());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(null, pst, con);
		}
		return result;
	}
	
	@Override
	public Room getRoomById(Integer foodId) {
		Room food = null;
		String sql = "select * from food where foodId=?";
		try {
			con = DBUtil.getConnection();
			pst = con.prepareStatement(sql);
			pst.setInt(1, foodId);
			rs = pst.executeQuery();
			while(rs.next()) {
				food = new Room();
				food.setRoomID(rs.getInt("roomId"));
				food.setRoomName(rs.getString("roomName"));
				food.setRoomExplain(rs.getString("roomExplain"));
				food.setRoomPrice(rs.getDouble("roomPrice"));
				food.setBusinessId(rs.getInt("businessId"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, pst, con);
		}
		return food;
	}
	
	@Override
	public int updateRoom(Room food) {
		int result = 0;
		String sql = "update food set foodName=?,foodExplain=?,foodPrice=? where foodId=?";
		try {
			con = DBUtil.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, food.getRoomName());
			pst.setString(2, food.getRoomExplain());
			pst.setDouble(3, food.getRoomPrice());
			pst.setInt(4, food.getRoomID());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(null, pst, con);
		}
		return result;
	}
	
	@Override
	public int removeRoom(Integer foodId) {
		int result = 0;
		String sql = "delete from food where foodId=?";
		try {
			con = DBUtil.getConnection();
			pst = con.prepareStatement(sql);
			pst.setInt(1, foodId);
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(null, pst, con);
		}
		return result;
	}
}
