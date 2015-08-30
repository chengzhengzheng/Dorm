package shifan.pojo;

public class Student {
	   private int student_ID ;
	    private int domitory_ID ;
	    private String domitory_Name;
	    private int building_ID;
	    private String building_Name;
	    private String student_Username ;
	    private String student_Password ;
	    private String student_Name ;
	    private String student_Sex ;
	    private String student_Class ;
	    private String student_State ;
	    
		public String getDomitory_Name() {
			return domitory_Name;
		}
		public void setDomitory_Name(String domitory_Name) {
			this.domitory_Name = domitory_Name;
		}
		public String getBuilding_Name() {
			return building_Name;
		}
		
		public int getBuilding_ID() {
			return building_ID;
		}
		public void setBuilding_ID(int building_ID) {
			this.building_ID = building_ID;
		}
		public String toString(){
			return "姓名："+student_Name+"用户名："+student_Username+"密码："+student_Password+"宿舍id："+domitory_ID
					+",student_DomitroyName :"+domitory_Name+",student_BuildingName:"+building_Name;
		}
		public void setBuilding_Name(String building_Name) {
			this.building_Name = building_Name;
		}
		public int getStudent_ID() {
			return student_ID;
		}
		public void setStudent_ID(int student_ID) {
			this.student_ID = student_ID;
		}
		public int getDomitory_ID() {
			return domitory_ID;
		}
		public void setDomitory_ID(int domitory_ID) {
			this.domitory_ID = domitory_ID;
		}
		public String getStudent_Username() {
			return student_Username;
		}
		public void setStudent_Username(String student_Username) {
			this.student_Username = student_Username;
		}
		public String getStudent_Password() {
			return student_Password;
		}
		public void setStudent_Password(String student_Password) {
			this.student_Password = student_Password;
		}
		public String getStudent_Name() {
			return student_Name;
		}
		public void setStudent_Name(String student_Name) {
			this.student_Name = student_Name;
		}
		public String getStudent_Sex() {
			return student_Sex;
		}
		public void setStudent_Sex(String student_Sex) {
			this.student_Sex = student_Sex;
		}
		public String getStudent_Class() {
			return student_Class;
		}
		public void setStudent_Class(String student_Class) {
			this.student_Class = student_Class;
		}
		public String getStudent_State() {
			return student_State;
		}
		public void setStudent_State(String student_State) {
			this.student_State = student_State;
		}
	

}
