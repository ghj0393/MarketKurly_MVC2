package command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.CartDAO;
import bean.CartDTO;
import bean.ItemDAO;
import bean.ItemDTO;

public class _30InsertCart implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		HttpSession session = request.getSession();
		String buyer = (String)session.getAttribute("id");
		
		int item_number = Integer.parseInt(request.getParameter("item_number"));
		int buy_count = Integer.parseInt(request.getParameter("buy_count"));
		
		ItemDTO item = ItemDAO.getInstance().getOneItem(item_number);
		
		String item_name = item.getItem_name();
		int buy_price = item.getItem_price() - item.getItem_price()*item.getDiscount_rate()/100;
		String item_image = item.getItem_image();
		
		CartDTO dto = new CartDTO();
		dto.setBuyer(buyer);
		dto.setItem_name(item_name);
		dto.setBuy_price(buy_price);
		dto.setBuy_count(buy_count);
		dto.setItem_image(item_image);
		
		CartDAO.getInstance().insertCart(dto);
		
		return "/30_insertCart.jsp";
	}

}
