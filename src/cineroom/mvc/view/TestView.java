package cineroom.mvc.view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cineroom.mvc.model.dto.Genre;
import cineroom.mvc.model.dto.Member;
import cineroom.mvc.util.DBUtil;

public class TestView {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from member";
		List<Member> list = new ArrayList<Member>();
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Member(rs.getString(1),rs.getString(2),rs.getString(3), rs.getString(4), rs.getInt(5)));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(con, ps, rs);
		}
		for(Member m : list) {
			System.out.println(m);
		}
		
		List<Genre> genreList = new ArrayList<Genre>();
		sql = "select * from genre";
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				genreList.add(new Genre(rs.getInt(1), rs.getString(2)));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(con, ps, rs);
		}
		for(Genre g : genreList) {
			System.out.println(g);
		}
		
	}
}
