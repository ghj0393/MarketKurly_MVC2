package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.BoardDAO;
import bean.BoardDTO;


public class _39ShowBoardContentForCustomer implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		int num = Integer.parseInt(request.getParameter("num"));
		
		BoardDTO board = BoardDAO.getInstance().getOneBoard(num);
		
		request.setAttribute("board", board);

		// 사용자(1)
		request.setAttribute("type", 1);
		
		return "/39_showBoardContent.jsp";
	}

}
