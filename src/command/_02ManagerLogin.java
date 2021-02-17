package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class _02ManagerLogin implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		// 관리자(0)
		request.setAttribute("type", 0);
		
		return "/02_managerLogin.jsp";
	}

}
