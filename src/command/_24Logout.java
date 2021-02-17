package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class _24Logout implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		// 사용자(1)
		request.setAttribute("type", 1);
		
		return "/24_logout.jsp";
	}

}
