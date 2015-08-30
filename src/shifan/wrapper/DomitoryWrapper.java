package shifan.wrapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import shifan.pojo.Domitory;

public class DomitoryWrapper implements RowMapper{
	@Override
	public Object mapRow(ResultSet rs, int arg1) throws SQLException {
		Domitory d = new Domitory();
		d.setDomitory_BuildingID(rs.getInt("Domitory_BuildingID"));
		d.setDomitory_ID(rs.getInt("Domitory_ID"));
		d.setDomitory_Name(rs.getString("Domitory_Name"));
		d.setDomitory_Number(rs.getInt("Domitory_Person"));
		d.setDomitory_totalNumber(rs.getInt("Domitory_Number"));
		d.setDomitory_Tel(rs.getString("Domitory_Tel"));
		return d;
	}

}
