package shifan.wrapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import shifan.pojo.Student;

public class StudentWrapper implements RowMapper{

	@Override
	public Object mapRow(ResultSet rs, int arg1) throws SQLException {
		Student s = new Student();
		s.setStudent_ID(rs.getInt("Student_ID"));
		s.setDomitory_ID(rs.getInt("Student_DomitoryID"));
		s.setStudent_Name(rs.getString("Student_Name"));
		s.setStudent_Username(rs.getString("Student_Username"));
		s.setStudent_Password(rs.getString("Student_Password"));
		s.setStudent_Sex(rs.getString("Student_Sex"));
		s.setStudent_Class(rs.getString("Student_Class"));
		s.setStudent_State(rs.getString("Student_State"));
		
		return s;
	}
	

}
