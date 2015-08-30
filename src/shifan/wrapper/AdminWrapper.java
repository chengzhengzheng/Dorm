package shifan.wrapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import shifan.pojo.Admin;

public class AdminWrapper implements RowMapper{

	@Override
	public Object mapRow(ResultSet rs, int arg1) throws SQLException {
		Admin admin = new Admin();
		admin.setAdmin_ID(rs.getInt("Admin_ID"));
		admin.setAdmin_Name(rs.getString("Admin_Name"));
		admin.setAdmin_Password(rs.getString("Admin_Password"));
		admin.setAdmin_Sex(rs.getString("Admin_Sex"));
		admin.setAdmin_Tel(rs.getString("Admin_Tel"));
		admin.setAdmin_Username(rs.getString("Admin_Username"));
		return admin;
	}

}
