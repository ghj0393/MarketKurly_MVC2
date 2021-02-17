package command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ItemDAO;
import bean.ItemDTO;

public class _11ItemListForManager implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		ArrayList<ItemDTO> registeredItemList = ItemDAO.getInstance().getAllItemList();
		int cnt = registeredItemList.size();
		
		System.out.println("cnt = " + cnt);
		
		if(cnt > 0) {
			request.setAttribute("registeredItemList", registeredItemList);
		}
		
		request.setAttribute("type", 0);
		request.setAttribute("cnt", cnt);
		
		return "/11_itemListForManager.jsp";
	}

}
