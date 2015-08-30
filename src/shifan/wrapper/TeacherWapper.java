package shifan.wrapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import shifan.pojo.Teacher;

public class TeacherWapper implements RowMapper{

	@Override
	public Object mapRow(ResultSet rs, int arg1) throws SQLException {
		Teacher teacher = new Teacher();
		teacher.setTeacher_ID(rs.getInt("Teacher_ID"));
		teacher.setTeacher_Name(rs.getString("Teacher_Name"));
		teacher.setTeacher_Password(rs.getString("Teacher_Password"));
		teacher.setTeacher_Sex(rs.getString("Teacher_Sex"));
		teacher.setTeacher_Tel(rs.getString("Teacher_Tel"));
		teacher.setTeacher_Username(rs.getString("Teacher_Username"));
		return teacher;
	}

}
