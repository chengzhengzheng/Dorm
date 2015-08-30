package shifan.action;


import shifan.dao.StudentDAO;
import shifan.dao.TeacherDAO;
import shifan.pojo.Admin;
import shifan.pojo.Teacher;
import shifan.util.Constants;

public class GoLoginAction extends BaseAction {
	private String Username;
	private String Password;
	private String type;
	private StudentDAO studentDao;
	private String message;
	private TeacherDAO teacherDao;
	private String url;

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setTeacherDao(TeacherDAO teacherDao) {
		this.teacherDao = teacherDao;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setStudentDao(StudentDAO studentDao) {
		this.studentDao = studentDao;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		this.Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		this.Password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String execute() {
		// ��������Ա�û�
		
		try {
			if (Constants.ADMIN.equals(type)){
				Admin admin = studentDao.checkLogin(Username, Password);
				if (null == admin) {
					// ��½ʧ��
					message = Constants.LOGIN_ERROR;
					return "fail";
				} else {
					// ��½�ɹ�
					httpSession.setAttribute(Constants.USER, admin);// ����ǰ�û�����session����
					httpSession.setAttribute("loginType", type);// ����ǰ�û����������session����
					String url1 = (String) httpSession.getAttribute("url");
					if (url1 != null) {
						url = url1;
						return "review";
					} 
					return "admin";
				}
			} else if (Constants.TEACHER.equals(type)) {
				Teacher teacher = teacherDao.checkLogin(Username, Password);
				if (null == teacher){
					// ��¼ʧ��
					message = Constants.LOGIN_ERROR;
					return "fail";
				}
				else {
					// ��¼�ɹ�,����ǰ�û����û����ͷ���session����
					httpSession.setAttribute(Constants.USER, teacher);
					httpSession.setAttribute("loginType", type);
					return "teacher";
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		return "error";
	}

}
