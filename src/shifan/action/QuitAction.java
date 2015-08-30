package shifan.action;

import shifan.util.Constants;

public class QuitAction extends BaseAction {
	public String execute(){
		Object obj = httpSession.getAttribute(Constants.USER);
		if(obj != null)
			httpSession.setAttribute(Constants.USER, null);
		return "success";
	}

}
