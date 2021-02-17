package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.CustomerDAO;

public class _20CheckDoubleId implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		int check = CustomerDAO.getInstance().checkDoubleId(id);
		
		// check : 1(중복) 0(중복X)
		request.setAttribute("check", check);
		
		// 사용자(1)
		request.setAttribute("type", 1);
		
		return "/20_checkDoubleId.jsp";
	}

}
