package command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.CartDAO;
import bean.CartDTO;
import bean.CustomerDAO;
import bean.CustomerDTO;

public class _32Order implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
	
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		int total = Integer.parseInt(request.getParameter("total"));
		
		ArrayList<CartDTO> orderList = CartDAO.getInstance().getCartList(id);
		CustomerDTO customer = CustomerDAO.getInstance().getCustomerInfo(id);
		
		request.setAttribute("orderList", orderList);
		request.setAttribute("total", total);
		request.setAttribute("customer", customer);
		
		// 사용자(1)
		request.setAttribute("type", 1);
		
		return "/32_order.jsp";
	}

}
