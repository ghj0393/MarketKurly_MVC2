package command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ItemDAO;
import bean.ItemDTO;

public class _25ShowAllItem implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		ArrayList<ItemDTO> itemList = ItemDAO.getInstance().getAllItem();
		
		request.setAttribute("itemList", itemList);
		
		// 사용자(1)
		request.setAttribute("type", 1);
		
		return "/25_showAllItem.jsp";
	}

}
