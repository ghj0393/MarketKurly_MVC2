package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.BoardDAO;
import bean.BoardDTO;

public class _38BoardWriteForCustomerPro implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("UTF-8");
		
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String pw = request.getParameter("pw");
		
		BoardDTO dto = new BoardDTO();
		dto.setWriter(writer);
		dto.setTitle(title);
		dto.setContent(content);
		dto.setPw(pw);

		BoardDAO.getInstance().insertBoard(dto);
		
		// 사용자(1)
		request.setAttribute("type", 1);
		
		return "38_boardWriteForCustomerPro.jsp";
	}

}
