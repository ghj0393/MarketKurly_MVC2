package command;

import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import bean.ItemDTO;
import bean.ManagerDAO;

public class _08UpdateItemPro implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		request.setCharacterEncoding("UTF-8");

		String saveFolder="/img";
		String encType = "utf-8";
		int max_size=1 * 1024 * 1024;	

		ServletContext context = request.getSession().getServletContext();
		String realFolder = context.getRealPath(saveFolder);

		MultipartRequest multiRequest = 
		new MultipartRequest(request, realFolder, max_size,encType, new DefaultFileRenamePolicy());
		Enumeration<?> files = multiRequest.getFileNames();
		
		String filename="";
		while(files.hasMoreElements()){
			String name =(String)files.nextElement();
			filename = multiRequest.getFilesystemName(name);
		}

		int item_number = Integer.parseInt(multiRequest.getParameter("item_number"));
		String item_category = multiRequest.getParameter("item_category");
		String item_name = multiRequest.getParameter("item_name");
		String item_price = multiRequest.getParameter("item_price");
		String item_stock = multiRequest.getParameter("item_stock");
		String item_info = multiRequest.getParameter("item_info");
		int discount_rate = Integer.parseInt(multiRequest.getParameter("discount_rate"));
		
		ItemDTO dto = new ItemDTO();
		dto.setItem_category(item_category);
		dto.setItem_number(item_number);
		dto.setItem_name(item_name);
		dto.setItem_price(Integer.parseInt(item_price));
		dto.setItem_stock(Integer.parseInt(item_stock));
		dto.setItem_info(item_info);
		dto.setDiscount_rate(discount_rate);
		
		if(filename == null || filename.equals("")){
			// item_number를 통해 본래 이미지 파일명을 가져옴으로써
			// 이미지를 재 업로드 하지 않아도 수정하는데 문제가 없도록 함
			String item_image = ManagerDAO.getInstance().getItemImage(item_number);
			dto.setItem_image(item_image);
		}else{
			dto.setItem_image(filename);
		}
		
		ManagerDAO.getInstance().updateItem(dto);
		
		request.setAttribute("type", new Integer(0));
		return "08_updateItemPro.jsp";
	}

}
