package shifan.wrapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import shifan.pojo.Hygiene;

public class HygieneWrapper implements RowMapper {
	@Override
	public Object mapRow(ResultSet rs, int arg1) throws SQLException {
		Hygiene hygiene = new Hygiene();
		hygiene.setId(rs.getInt("id"));
		hygiene.setBuilding_ID(rs.getInt("Domitory_BuildingID"));
		hygiene.setDomitory_ID(rs.getInt("Domitory_ID"));
		hygiene.setDomitory_Name(rs.getString("Domitory_Name"));
		hygiene.setScore(rs.getInt("score"));
		hygiene.setTeacher_ID(rs.getInt("Teacher_ID"));
		hygiene.setWeek(rs.getInt("week"));
		hygiene.setTeacher_Type(rs.getInt("teacher_Type"));
		return hygiene;
	}

}
