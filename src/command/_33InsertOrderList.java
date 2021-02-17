package command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.BuyDAO;
import bean.BuyDTO;
import bean.CartDAO;
import bean.CartDTO;
import bean.CustomerDAO;
import bean.CustomerDTO;

public class _33InsertOrderList implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
	
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		int payhow = Integer.parseInt(request.getParameter("howpay"));
		String howpay = "";		
		if(payhow == 1) {
			howpay = "계좌이체";
		}else if(payhow == 2) {
			howpay = "신용카드";
		}
		
		CustomerDTO customerBean = CustomerDAO.getInstance().getCustomerInfo(id);
		String customer_name =customerBean.getName();		
		String address = customerBean.getAddress();

		ArrayList<CartDTO> cartList = CartDAO.getInstance().getCartList(id);
		
		for(int i=0;i<cartList.size();i++){
			
			CartDTO bean = cartList.get(i);
			
			int cart_number = bean.getCart_number();
			String item_name = bean.getItem_name();	
			int buy_price = bean.getBuy_price();
			int buy_count = bean.getBuy_count();
			String item_image = bean.getItem_image();		
			
			BuyDTO dto = new BuyDTO();
			dto.setCustomer_id(id);
			dto.setCustomer_name(customer_name);
			dto.setCart_number(cart_number);
			dto.setItem_name(item_name);
			dto.setBuy_price(buy_price);
			dto.setBuy_count(buy_count);
			dto.setItem_image(item_image);
			dto.setHowpay(howpay);
			dto.setAddress(address);
			
			BuyDAO.getInstance().insertOrderList(dto);
			BuyDAO.getInstance().updateSold(item_name, buy_count);
		}
		
		BuyDAO.getInstance().deleteCartList(id);
		
		return "/33_insertOrderList.jsp";
	}

}
