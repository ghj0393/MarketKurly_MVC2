package command;

import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import bean.ItemDTO;
import bean.ManagerDAO;

public class _06AddNewItemPro implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		request.setCharacterEncoding("UTF-8");
		
		String saveFolder = "/img";
		String encType = "utf-8";
		int maxSize = 2 * 1024 * 1024;	

		ServletContext context = request.getSession().getServletContext();
		String realFolder = context.getRealPath(saveFolder);		
		
		MultipartRequest multiRequest = 
		new MultipartRequest(request, realFolder, maxSize, encType, new DefaultFileRenamePolicy());
		
		String fileName = "";
		
		Enumeration<?> files = multiRequest.getFileNames();
		while(files.hasMoreElements()) {
			String name = (String)files.nextElement();
			fileName = multiRequest.getFilesystemName(name);			
		}
		
		String item_name = multiRequest.getParameter("item_name");
		String item_category = multiRequest.getParameter("item_category");
		String item_price = multiRequest.getParameter("item_price");
		String item_stock = multiRequest.getParameter("item_stock");
		String item_info = multiRequest.getParameter("item_info");
		String discount_rate = multiRequest.getParameter("discount_rate");
		
		ItemDTO dto = new ItemDTO();
		dto.setItem_name(item_name);
		dto.setItem_category(item_category);
		dto.setItem_price(Integer.parseInt(item_price));
		dto.setItem_stock(Integer.parseInt(item_stock));
		dto.setItem_info(item_info);
		dto.setDiscount_rate(Integer.parseInt(discount_rate));		

		if(fileName == null || fileName.equals("")) {
			dto.setItem_image("error.jpg");
		}else {
			dto.setItem_image(fileName);
		}
		
		ManagerDAO.getInstance().insertNewItem(dto);
		
		// 관리자(0)
		request.setAttribute("type", 0);
		
		return "/06_addNewItemPro.jsp";
	}

}
