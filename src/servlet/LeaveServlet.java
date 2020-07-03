package servlet;

import java.io.IOException;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.LeaveDao;
import dao.SignRecordDao;
import entity.Sign;
import entity.User;
import model.Leave;
import model.SignRecord;

/**
 * Servlet implementation class LeaveServlet
 */

public class LeaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LeaveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
	    response.setContentType("text/html");
	    request.setCharacterEncoding("utf-8");
		String method = request.getParameter("method");

		if("doLeave".equals(method)){
System.out.println("--------------------************"+method);
			try {
				doLeave(request,response);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("takeLeave".equals(method)){
//System.out.println("--------------------************"+method);
			try {
				takeLeave(request,response);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("listLeave".equals(method)) {
			listLeave(request,response);
		}else if("updateState".equals(method)) {
			updateState(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Content-Type", "text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8"); 	
		doGet(request, response);
	}
	
	private void takeLeave(HttpServletRequest request,HttpServletResponse response) throws IOException, ParseException, ServletException {
		User user = (User) request.getSession().getAttribute("user");
		String beginTime = request.getParameter("beginTime");
		String endTime = request.getParameter("endTime");
System.out.println("****LeaveServlet************takeLeave()************beginTime:"+beginTime);			
System.out.println("****LeaveServlet************takeLeave()************endTime:"+endTime);	
		int userID = user.getUserID();
//		request.setAttribute("beginTime", beginTime);
//		request.setAttribute("endTime", endTime);
//		request.setAttribute("userID", userID);
//		request.getRequestDispatcher("view/reason.jsp").forward(request, response);
		request.getSession().setAttribute("beginTime", beginTime);
		request.getSession().setAttribute("endTime", endTime);
		request.getSession().setAttribute("userID", userID);
		response.sendRedirect("view/reason.jsp");
	}

	private void doLeave(HttpServletRequest request,HttpServletResponse response) throws IOException, ParseException {
		 	
		 	String reason = request.getParameter("reason");
	        
			User user = (User) request.getSession().getAttribute("user");
//			List<Sign> list = (List<Sign>) request.getSession().getAttribute("list");
//			String beginTime = (String) request.getSession().getAttribute("beginTime");
//			String endTime = (String) request.getSession().getAttribute("endTime");
			String beginTime = request.getParameter("beginTime");
			String endTime = request.getParameter("endTime");
			Date date = new Date();
	        SimpleDateFormat adf = new SimpleDateFormat("yyyy-MM-dd");
	        String today = adf.format(date);
			int state = 3;
System.out.println("****LeaveServlet************doLeave()***beginTime:"+beginTime);	
System.out.println("****LeaveServlet************doLeave()***endTime:"+endTime);			
System.out.println("****LeaveServlet************doLeave()***reason:"+reason);	

			
			
			
			Leave leave = new Leave();
			leave.setUserID(user.getUserID());
	        leave.setName(user.getName());
	        leave.setBeginTime(beginTime);
			leave.setEndTime(endTime);
	        leave.setReason(reason);
	        leave.setState(state);
	        leave.setSignDate(today);
System.out.println("*******************LeaveServlet****************doLeave()**********");	        
	        new LeaveDao().doLeave(leave);
	        
	        List<Leave> leaves = new ArrayList<Leave>();
			leaves = new LeaveDao().listLeave();
			request.getSession().setAttribute("leaves", leaves);
	        
	        request.getSession().setAttribute("state", state);
//	        Hero hero = new Hero();
//	        hero.setName(name);
//	        hero.setHp(hp);
//	        new HeroDAO().add(hero);
	        
	        request.getSession().setAttribute("signMessage", "«ÎºŸ“—Ã·Ωª");

	        response.sendRedirect("view/userSign.jsp");
	}
	
	private void listLeave(HttpServletRequest request,HttpServletResponse response) throws IOException {
//System.out.println("-------------------------------------");		
		List<Leave> leaveRecordList = new LeaveDao().listLeave();
		request.getSession().setAttribute("leaveRecordList", leaveRecordList);
//		response.sendRedirect("view/manager_leavelist.jsp");
		response.sendRedirect("view/manager_leavelist.jsp");
	}

/*	
	private void updateStateTo1(HttpServletRequest request,HttpServletResponse response) throws IOException {
		int userID = Integer.parseInt(request.getParameter("userID"));
        new LeaveDao().updateTo1(userID);
//        request.setAttribute("leave", leave);
        listLeave(request,response);
	}
	
	private void updateStateTo2(HttpServletRequest request,HttpServletResponse response) throws IOException {
		int userID = Integer.parseInt(request.getParameter("userID"));
        new LeaveDao().updateTo2(userID);
//        request.setAttribute("leave", leave);
        listLeave(request,response);
	}
*/	
	private void updateState(HttpServletRequest request,HttpServletResponse response) throws IOException {
//		String userIDs = request.getParameter("userID");
//		String position = request.getParameter("position");
//		int p = Integer.parseInt(position);
//System.out.println("************pppppppp:"+position+"***********");	
		int userID = Integer.parseInt(request.getParameter("id"));
System.out.println("************"+userID+"***********");
		String methodTo = request.getParameter("to");
//		String smethodTo = new String(methodTo.getBytes("ISO-8859-1"),"UTF-8"); 
System.out.println(methodTo+"-------------------------------------to-----------");
		if("1".equals(methodTo)) {
//System.out.println("-------------------------------------yes2-----------");
			new LeaveDao().updateTo1(userID);
		}else {
			new LeaveDao().updateTo2(userID);
		}
		
//        new LeaveDao().updateTo2(userID);
//        request.setAttribute("leave", leave);
        listLeave(request,response);
	}
	
}
