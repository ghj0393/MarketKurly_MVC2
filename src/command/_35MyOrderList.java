package command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.BuyDAO;
import bean.BuyDTO;

public class _35MyOrderList implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		ArrayList<BuyDTO> buyList = BuyDAO.getInstance().getBuyList(id);
		int cnt = buyList.size();
		
		request.setAttribute("buyList", buyList);
		request.setAttribute("cnt", cnt);
		request.setAttribute("type", 1);
		
		return "/35_myOrderList.jsp";
	}

}
