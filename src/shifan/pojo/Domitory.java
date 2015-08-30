package shifan.pojo;

public class Domitory {
	private int domitory_ID;
	
	private int domitory_BuildingID;
	private String domitory_BuildingName;
	public void setDomitory_BuildingName(String domitory_BuildingName) {
		this.domitory_BuildingName = domitory_BuildingName;
	}
	public String getDomitory_BuildingName() {
		return domitory_BuildingName;
	}
	private String domitory_Name;
	private Integer domitory_totalNumber;//总人数
	public Integer getDomitory_totalNumber() {
		return domitory_totalNumber;
	}
	public void setDomitory_totalNumber(Integer domitory_totalNumber) {
		this.domitory_totalNumber = domitory_totalNumber;
	}
	private int domitory_Number;//已住人数
	private String domitory_Tel;
	public int getDomitory_ID() {
		return domitory_ID;
	}
	public void setDomitory_ID(int domitory_ID) {
		this.domitory_ID = domitory_ID;
	}
	public int getDomitory_BuildingID() {
		return domitory_BuildingID;
	}
	public void setDomitory_BuildingID(int domitory_BuildingID) {
		this.domitory_BuildingID = domitory_BuildingID;
	}
	public String getDomitory_Name() {
		return domitory_Name;
	}
	public void setDomitory_Name(String domitory_Name) {
		this.domitory_Name = domitory_Name;
	}
	public int getDomitory_Number() {
		return domitory_Number;
	}
	public void setDomitory_Number(int domitory_Number) {
		this.domitory_Number = domitory_Number;
	}
	public String getDomitory_Tel() {
		return domitory_Tel;
	}
	public void setDomitory_Tel(String domitory_Tel) {
		this.domitory_Tel = domitory_Tel;
	}
	

}
