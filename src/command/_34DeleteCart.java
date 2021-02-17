package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.CartDAO;

public class _34DeleteCart implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		int cart_num = Integer.parseInt(request.getParameter("cart_number"));
		
		CartDAO.getInstance().deleteCart(cart_num);
		
		// 사용자(1)
		request.setAttribute("type", 1);
		
		return "/34_deleteCart.jsp";
	}

}
