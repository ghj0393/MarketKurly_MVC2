package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.BoardDAO;

public class _42BoardDeleteForCustomer implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
	
		int num = Integer.parseInt(request.getParameter("num"));
		
		BoardDAO.getInstance().deleteBoard(num);
		
		// 사용자(1)
		request.setAttribute("type", 1);
		
		return "/42_boardDeleteForCustomer.jsp";
	}

}
