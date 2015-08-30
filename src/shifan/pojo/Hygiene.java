package shifan.pojo;


public class Hygiene {
	private int id;
	private int building_ID;
	private String building_Name;
	private String domitory_Name;
	private int score;
	private int teacher_ID;
	private String teacher_Name;
	private Integer week;
	private int teacher_Type;
	public void setTeacher_Type(int teacher_Type) {
		this.teacher_Type = teacher_Type;
	}
	public int getTeacher_Type() {
		return teacher_Type;
	}
	public void setWeek(Integer week) {
		this.week = week;
	}
	public Integer getWeek() {
		return week;
	}
	private int domitory_ID;
	public int getBuilding_ID() {
		return building_ID;
	}
	public void setBuilding_ID(int building_ID) {
		this.building_ID = building_ID;
	}
	public void setDomitory_ID(int domitory_ID) {
		this.domitory_ID = domitory_ID;
	}
	public int getDomitory_ID() {
		return domitory_ID;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDomitory_Name() {
		return domitory_Name;
	}
	public void setDomitory_Name(String domitory_Name) {
		this.domitory_Name = domitory_Name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getTeacher_ID() {
		return teacher_ID;
	}
	public void setTeacher_ID(int teacher_ID) {
		this.teacher_ID = teacher_ID;
	}
	
	public String getTeacher_Name() {
		return teacher_Name;
	}
	public void setTeacher_Name(String teacher_Name) {
		this.teacher_Name = teacher_Name;
	}
	public void setBuilding_Name(String building_Name) {
		this.building_Name = building_Name;
	}
	public String getBuilding_Name() {
		return building_Name;
	}

}
