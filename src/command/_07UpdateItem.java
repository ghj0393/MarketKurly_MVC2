package command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ItemDTO;
import bean.ManagerDAO;

public class _07UpdateItem implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		int item_number = Integer.parseInt(request.getParameter("item_number"));
		
		ArrayList<ItemDTO> itemList = ManagerDAO.getInstance().getOneItem(item_number);
		
		request.setAttribute("itemList", itemList);
		request.setAttribute("type", new Integer(0));
		
		return "/07_updateItem.jsp";
	}

}
