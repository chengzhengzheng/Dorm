package shifan.interceptor;

import java.util.Map;

import org.apache.struts2.ServletActionContext;
import shifan.util.Constants;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class CheckLoginInterceptor extends AbstractInterceptor {
	private static final long serialVersionUID = 1L;	
	public String intercept(ActionInvocation invocation) throws Exception {
		
		Map<String,Object> session=invocation.getInvocationContext().getSession();
		
		if(session.get(Constants.USER)==null){
			String url=ServletActionContext.getRequest().getServletPath();
			System.out.println("url «£∫"+url);
			session.put("url", url);
			return "login";
		}else{
			return invocation.invoke();
		}
	}
}