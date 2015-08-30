package shifan.wrapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import shifan.pojo.Building;

public class BuildingWrapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int arg1) throws SQLException {
		Building b = new Building();
		b.setBuilding_ID(rs.getInt("Building_ID"));
		b.setBuilding_Name(rs.getString("Building_Name"));
		b.setBuilding_Introduction(rs.getString("Building_Introduction"));
		return b;
	}

}
