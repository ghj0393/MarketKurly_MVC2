package command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ItemDAO;
import bean.ItemDTO;

public class _26ShowOneItem implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		int item_num = Integer.parseInt(request.getParameter("item_num"));
		
		ItemDTO item = ItemDAO.getInstance().getOneItem(item_num);
		
		request.setAttribute("item_num", item_num);
		request.setAttribute("item", item);
		
		// 사용자(1)
		request.setAttribute("type", 1);
		
		return "/26_showOneItem.jsp";
	}

}
