package command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.CartDAO;
import bean.CartDTO;

public class _31CartInfo implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		int cnt = CartDAO.getInstance().getItemCount(id);
		ArrayList<CartDTO> myCartList = CartDAO.getInstance().getCartList(id);
		
		request.setAttribute("myCartList", myCartList);
		request.setAttribute("cnt", cnt);
		
		// 사용자(1)
		request.setAttribute("type", 1);
		
		return "/31_cartInfo.jsp";
	}

}
