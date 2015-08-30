package shifan.pojo;

public class Admin {
	private int admin_ID;
	private String admin_Username;
	private String admin_Password;
	private String admin_Name;
	private String admin_Sex;
	private String admin_Tel;
	public int getAdmin_ID() {
		return admin_ID;
	}
	public void setAdmin_ID(int admin_ID) {
		this.admin_ID = admin_ID;
	}
	public String getAdmin_Username() {
		return admin_Username;
	}
	public void setAdmin_Username(String admin_Username) {
		this.admin_Username = admin_Username;
	}
	public String getAdmin_Password() {
		return admin_Password;
	}
	public void setAdmin_Password(String admin_Password) {
		this.admin_Password = admin_Password;
	}
	public String getAdmin_Name() {
		return admin_Name;
	}
	public void setAdmin_Name(String admin_Name) {
		this.admin_Name = admin_Name;
	}
	public String getAdmin_Sex() {
		return admin_Sex;
	}
	public void setAdmin_Sex(String admin_Sex) {
		this.admin_Sex = admin_Sex;
	}
	public String getAdmin_Tel() {
		return admin_Tel;
	}
	public void setAdmin_Tel(String admin_Tel) {
		this.admin_Tel = admin_Tel;
	}
	
	
	public String toString(){
		return this.admin_Username;
	}

}
