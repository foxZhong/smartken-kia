package shoes.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import shoes.dao.NewsDao;
import shoes.entity.News;

public class NewsDaoImpl extends BaseDao implements NewsDao {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public int addNews(String Title,String Content) {
		int result = 0;
		String time = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
		String sql = "insert into News (Title,[Content],Published) values (?,?,?)";
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			String[] parameters = {Title, Content, time};
			result = executeUpdate(pstmt, parameters);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll(con, pstmt, rs);
		}
		return result;
	}
	
	public int deleteNews(int nId) {
		int result = 0;
		String sql = "delete from News where NId="+nId;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			String[] parameters = null;
			result = executeUpdate(pstmt, parameters);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll(con, pstmt, rs);
		}
		return result;
	}
	
	public List findAllNews() {
		List list = new ArrayList();
		String sql = "select * from News";
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				News news = new News();
				news.setNId(rs.getInt("nId"));
				news.setTitle(rs.getString("Title"));
				news.setContent(rs.getString("Content"));
				news.setPublished(rs.getString("Published"));
				list.add(news);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll(con, pstmt, rs);
		}
		return list;
	}

	public List findNewFiveNews() {
		List list = new ArrayList();
		String sql = "select Top 5 * from News order by Published desc";
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				News news = new News();
				news.setNId(rs.getInt("nId"));
				news.setTitle(rs.getString("Title"));
				news.setContent(rs.getString("Content"));
				news.setPublished(rs.getString("Published"));
				list.add(news);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll(con, pstmt, rs);
		}
		return list;
	}

	public News findNews(int NId) {
		News news = null;
		String sql = "select * from News where NId="+NId;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				news = new News();
				news.setNId(NId);
				news.setTitle(rs.getString("Title"));
				news.setContent(rs.getString("Content"));
				news.setPublished(rs.getString("Published"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll(con, pstmt, rs);
		}
		return news;
	}
}
