package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ManagerDAO;

public class _01ManagerMain implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int memberCnt = ManagerDAO.getInstance().getCustomerCnt();
		int itemCnt = ManagerDAO.getInstance().getItemCnt();
		int buyCnt = ManagerDAO.getInstance().getOrderCnt();
		
		request.setAttribute("memberCnt", memberCnt);
		request.setAttribute("itemCnt", itemCnt);
		request.setAttribute("buyCnt", buyCnt);
		
		// 관리자(0)
		request.setAttribute("type", 0);
		
		return "/01_managerMain.jsp";
	}

}
