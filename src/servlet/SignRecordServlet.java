package servlet;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SignRecordDao;
import model.SignRecord;
//import model.User;

//import dao.SelectedCourseDao;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
//import model.Course;
import model.Page;
//import model.SelectedCourse;
//import model.User;
import util.DateFormatUtil;

public class SignRecordServlet extends HttpServlet{


	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		
//		String signDate = request.getParameter("signDate");
		
		String method = request.getParameter("method");
		
		if("toAttendanceServletListView".equals(method)){
			request.getRequestDispatcher("view/signRecordList.jsp").forward(request, response);
		
		}else if("getSelectedDate".equals(method)){
			try {
				getSelectedDate(request, response);
			} catch (SQLException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("getSelectedDateOrderByID".equals(method)){
			try {
				getSelectedDateOrderByID(request, response);
			} catch (SQLException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("getSelectedDateOrderByCount".equals(method)){
			try {
				getSelectedDateOrderByCount(request, response);
			} catch (SQLException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}else if("getSelectedTime".equals(method)){
			try {
				getSelectedTime(request, response);
			} catch (SQLException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}else if("getSelectedTimeOrderByID".equals(method)){
			try {
				getSelectedTimeOrderByID(request, response);
			} catch (SQLException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("getSelectedTimeOrderByCount".equals(method)){
			try {
				getSelectedTimeOrderByCount(request, response);
			} catch (SQLException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
//		else if("AddAttendance".equals(method)){
//			AddAttendance(request,response);
//		}else if("AttendanceList".equals(method)){
//			attendanceList(request,response);
//		}else if("DeleteAttendance".equals(method)){
//			deleteAttendance(request,response);
//		}
	}
	
//	private void getSelectedDate(HttpServletRequest request,HttpServletResponse response) {
//		String signDate = request.getParameter("signDate");
//	}
	
	
	private void getSelectedDateOrderByID(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException, SQLException, ParseException {
		String signDate = (String) request.getSession().getAttribute("signDate");
		List<SignRecord> signRecordList = SignRecordDao.getSelectedDateOrderByID(signDate);
		request.getSession().setAttribute("signRecordList", signRecordList);
		response.sendRedirect("view/signRecordList.jsp");
	}
	private void getSelectedDateOrderByCount(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException, SQLException, ParseException {
		String signDate = (String) request.getSession().getAttribute("signDate");
		List<SignRecord> signRecordList = SignRecordDao.getSelectedDateOrderByCount(signDate);
		request.getSession().setAttribute("signRecordList", signRecordList);
		response.sendRedirect("view/signRecordList.jsp");
	}
	
	private void getSelectedDate(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException, SQLException, ParseException {
/*		
		String signDate = request.getParameter("signDate");
		response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out=response.getWriter();
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("code",0);
        jsonObject.put("msg","");
        jsonObject.put("count",1000);
        JSONArray result=null;
        try{
            
            result = JSONArray.fromObject( SignRecordDao.getSelectedDate(signDate));
        }catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        jsonObject.put("data",result);
        PrintStream print=new PrintStream("C://Users//wuqiwen2017//eclipse-workspace//SignSystem1//WebContent//json//test1.txt");
		System.setOut(print);
        System.out.println(jsonObject.toString());
        print.flush();
        print.close();
*/
		
		
		String signDate = request.getParameter("signDate");
		
		request.getSession().setAttribute("signDate", signDate);
		
		List<SignRecord> signRecordList = SignRecordDao.getSelectedDate(signDate);
		request.getSession().setAttribute("signRecordList", signRecordList);
		response.sendRedirect("view/signRecordList.jsp");
		

		
//		request.getRequestDispatcher("view/signRecordList.jsp").forward(request,response);
	

	}
	
	private void getSelectedTime(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException, SQLException, ParseException {
		String beginTime = request.getParameter("beginTime");
		String endTime = request.getParameter("endTime");
		request.getSession().setAttribute("beginTime", beginTime);
		request.getSession().setAttribute("endTime", endTime);
		List<SignRecord> signRecordList = SignRecordDao.getSelectedTime(beginTime, endTime);
		request.getSession().setAttribute("signRecordList", signRecordList);
		response.sendRedirect("view/signRecordList2.jsp");
	}
	
	private void getSelectedTimeOrderByID(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException, SQLException, ParseException {
		String beginTime = (String) request.getSession().getAttribute("beginTime");
		String endTime = (String) request.getSession().getAttribute("endTime");
		List<SignRecord> signRecordList = SignRecordDao.getSelectedTimeOrderByID(beginTime, endTime);
		request.getSession().setAttribute("signRecordList", signRecordList);
		response.sendRedirect("view/signRecordList2.jsp");
	}
	
	private void getSelectedTimeOrderByCount(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException, SQLException, ParseException {
		String beginTime = (String) request.getSession().getAttribute("beginTime");
		String endTime = (String) request.getSession().getAttribute("endTime");
		List<SignRecord> signRecordList = SignRecordDao.getSelectedTimeOrderByCount(beginTime, endTime);
		request.getSession().setAttribute("signRecordList", signRecordList);
		response.sendRedirect("view/signRecordList2.jsp");
	}
}
