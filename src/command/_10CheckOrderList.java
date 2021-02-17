package command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.BuyDTO;
import bean.ManagerDAO;

public class _10CheckOrderList implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("UTF-8");
		
		ArrayList<BuyDTO> orderList = ManagerDAO.getInstance().getAllOrderList();
		
		request.setAttribute("orderList", orderList);
		
		// 관리자(0)
		request.setAttribute("type", 0);
		
		return "/10_checkOrderList.jsp";
	}

}
