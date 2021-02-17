package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class _00ShopMain implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		/*
		 * type변수는 관리자와 사용자를 구분하기 위한 변수
		 * . 관리자	type = 0
		 * . 사용자 	type = 1
		 */
		request.setAttribute("type", 1);
		
		return "/00_shopMain.jsp";
	}
	
}
