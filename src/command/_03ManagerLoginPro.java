package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ManagerDAO;

public class _03ManagerLoginPro implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		 
		int check = ManagerDAO.getInstance().checkManager(id, pw);
		
		System.out.println("check = " + check);
		
		request.setAttribute("check", check);
		request.setAttribute("id", id);
		
		return "/03_managerLoginPro.jsp";
	}

}
