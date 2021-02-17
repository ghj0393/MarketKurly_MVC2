package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.CustomerDAO;

public class _21CheckDoubleEmail implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		request.setCharacterEncoding("UTF-8");
		
		String email = request.getParameter("email");
		int check = CustomerDAO.getInstance().checkDoubleEmail(email);
		
		request.setAttribute("check", check);
		
		// 사용자(1)
		request.setAttribute("type", 1);
		
		return "/21_checkDoubleEmail.jsp";
	}

}
