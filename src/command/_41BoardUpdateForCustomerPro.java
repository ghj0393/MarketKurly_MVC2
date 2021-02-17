package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.BoardDAO;

public class _41BoardUpdateForCustomerPro implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("UTF-8");
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		BoardDAO.getInstance().updateBoard(num, title, content);
		
		return "/41_boardUpdateForCustomerPro.jsp";
	}

}
