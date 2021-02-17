package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.CommandAction;
import command._00ShopMain;
import command._01ManagerMain;
import command._02ManagerLogin;
import command._03ManagerLoginPro;
import command._04ManagerLogout;
import command._05AddNewItem;
import command._06AddNewItemPro;
import command._07UpdateItem;
import command._08UpdateItemPro;
import command._09DeleteItemPro;
import command._10CheckOrderList;
import command._11ItemListForManager;
import command._18Join;
import command._19JoinPro;
import command._20CheckDoubleId;
import command._21CheckDoubleEmail;
import command._22Login;
import command._23LoginPro;
import command._24Logout;
import command._25ShowAllItem;
import command._26ShowOneItem;
import command._27ShowNewItem;
import command._28ShowBestItem;
import command._29ShowDiscountedItem;
import command._30InsertCart;
import command._31CartInfo;
import command._32Order;
import command._33InsertOrderList;
import command._34DeleteCart;
import command._35MyOrderList;
import command._36ShowBoardListForCustomer;
import command._37BoardWriteForCustomer;
import command._38BoardWriteForCustomerPro;
import command._39ShowBoardContentForCustomer;
import command._40BoardUpdateForCustomer;
import command._41BoardUpdateForCustomerPro;
import command._42BoardDeleteForCustomer;

@WebServlet("*.do")
public class Controller extends HttpServlet {
	private Map<String, Object> commandMap = new HashMap<String, Object>();
	
	@Override
	public void init() throws ServletException {
		commandMap.put("/index.do", new _00ShopMain());
		commandMap.put("/managerMain.do", new _01ManagerMain());
		commandMap.put("/managerLogin.do", new _02ManagerLogin());
		commandMap.put("/managerLoginPro.do", new _03ManagerLoginPro());
		commandMap.put("/managerLogout.do", new _04ManagerLogout());
		commandMap.put("/addNewItem.do", new _05AddNewItem());
		commandMap.put("/addNewItemPro.do", new _06AddNewItemPro());
		commandMap.put("/updateItem.do", new _07UpdateItem());
		commandMap.put("/updateItemPro.do", new _08UpdateItemPro());
		commandMap.put("/deleteItemPro.do", new _09DeleteItemPro());
		commandMap.put("/checkOrderList.do", new _10CheckOrderList());
		commandMap.put("/itemListForManager.do", new _11ItemListForManager());
//		//--------------------------------------------------------------------------
		commandMap.put("/join.do", new _18Join());
		commandMap.put("/joinPro.do", new _19JoinPro());
		commandMap.put("/checkDoubleId.do", new _20CheckDoubleId());
		commandMap.put("/checkDoubleEmail.do", new _21CheckDoubleEmail());
		commandMap.put("/login.do", new _22Login());
		commandMap.put("/loginPro.do", new _23LoginPro());
		commandMap.put("/logout.do", new _24Logout());
		commandMap.put("/showAllItem.do", new _25ShowAllItem());
		commandMap.put("/showOneItem.do", new _26ShowOneItem());
		commandMap.put("/showNewItem.do", new _27ShowNewItem());
		commandMap.put("/showBestItem.do", new _28ShowBestItem());
		commandMap.put("/showDiscountedItem.do", new _29ShowDiscountedItem());
		commandMap.put("/insertCart.do", new _30InsertCart());
		commandMap.put("/cartInfo.do", new _31CartInfo());
		commandMap.put("/order.do", new _32Order());
		commandMap.put("/insertOrderList.do", new _33InsertOrderList());
		commandMap.put("/deleteCart.do", new _34DeleteCart());
		commandMap.put("/checkMyOrderList.do", new _35MyOrderList());
		commandMap.put("/showBoardListForCustomer.do", new _36ShowBoardListForCustomer());
		commandMap.put("/boardWriteForCustomer.do", new _37BoardWriteForCustomer());
		commandMap.put("/boardWriteForCustomerPro.do", new _38BoardWriteForCustomerPro());
		commandMap.put("/showBoardContentForCustomer.do", new _39ShowBoardContentForCustomer());
		commandMap.put("/boardUpdateForCustomer.do", new _40BoardUpdateForCustomer());
		commandMap.put("/boardUpdateForCustomerPro.do", new _41BoardUpdateForCustomerPro());
		commandMap.put("/boardDeleteForCustomer.do", new _42BoardDeleteForCustomer());
	}
	
	protected void requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = null;
		CommandAction com=null;
		
		try {
			// request.getRequestURI() == MarketKurly_MVC2/index.do
			String command = request.getRequestURI();
			// command.indexOf(request.getContextPath() == 0 있으면 0 없으면 -1
	        if(command.indexOf(request.getContextPath()) == 0) {
	        	// request.getContextPath() == MarketKurly_MVC2
	           command = command.substring(request.getContextPath().length());
	           // command == /index.do
	        }
	        // commandMap.put("/index.do", new _00ShopMain());
	        com = (CommandAction)commandMap.get(command);  
	        view = com.requestPro(request, response);
	        
	        // com = command._00ShopMain@eec48b5
	        System.out.println("com = " + com);
	        // view = /00_shopMain.jsp
	        System.out.println("view = " + view);
	        
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
		/*
		 *	. 경로 : /MarketKurly_MVC2/index.do
		 *	. 이처럼 JSP페이지에서 경로마다 프로젝트명을 적어줘야 하는데 프로젝트명을 수정할 경우,
		 * 	    모든 페이지의 이름을 바꿔줘야하는 번거로움이 있다.	
		 * 	. 이를 위해 프로젝트명을 얻어올 수 있는 명령어(request.contextPath)를 통해 
			    변수에 저장하고, 이것을 재사용한다.
		 */
		String path = request.getContextPath();
		
		request.setAttribute("contextPath",path);
		request.setAttribute("cont",view);
	    
		RequestDispatcher dispatcher = request.getRequestDispatcher("/00_index.jsp");
		dispatcher.forward(request, response);		
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request, response);
	}

}
