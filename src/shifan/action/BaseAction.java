package shifan.action;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import shifan.util.LogUtil;

public class BaseAction implements SessionAware,ServletRequestAware,ServletResponseAware,ServletContextAware{
	protected Map<String,Object> session;
	protected HttpServletRequest httpRequest;
	protected HttpServletResponse response;
	protected HttpSession httpSession;
	protected ServletContext context;
	protected Logger log = LogUtil.getLogger();
	

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		this.response = arg0;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.httpRequest = arg0;
		httpSession = arg0.getSession();
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	
	}
	
	

	@Override
	public void setServletContext(ServletContext arg0) {
		this.context = arg0;
	}
	

}
