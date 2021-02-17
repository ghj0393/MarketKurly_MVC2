package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ManagerDAO;

public class _09DeleteItemPro implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		int item_number = Integer.parseInt(request.getParameter("item_number"));
		
		ManagerDAO.getInstance().deleteItem(item_number);
		
		request.setAttribute("type", 0);
		
		return "/09_deleteItemPro.jsp";
	}

}
