package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.CustomerDAO;
import bean.CustomerDTO;

public class _19JoinPro implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		request.setCharacterEncoding("UTF-8");
		
		CustomerDTO dto  = new CustomerDTO();
		
		dto.setId(request.getParameter("id"));
		dto.setPw(request.getParameter("pw"));
		dto.setName(request.getParameter("name"));
		dto.setTel(request.getParameter("tel"));
		dto.setAddress(request.getParameter("address"));
		dto.setEmail(request.getParameter("email"));
		
		CustomerDAO.getInstance().insertCustomer(dto);
		
		request.setAttribute("type", 1);
		
		return "/19_joinPro.jsp";
	}

}
