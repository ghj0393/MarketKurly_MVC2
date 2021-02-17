package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.CustomerDAO;

public class _23LoginPro implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		int check = CustomerDAO.getInstance().userCheck(id, pw);
		
		request.setAttribute("check", check);
		request.setAttribute("id", id);
		
		// 사용자(1)
		request.setAttribute("type", 1);
		
		return "/23_loginPro.jsp";
	}

}
