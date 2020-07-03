package controller;

import dao.LeaveDao;
import dao.SignListDao;
import entity.LeaveRecord;
import entity.Sign;
import entity.SignRecord;
import entity.User;
import model.Leave;
import service.SignListService;
import service.SignRecordService;
import service.UserService;
import serviceImpl.SignListServiceImpl;
import serviceImpl.SignRecordServiceImpl;
import serviceImpl.UserServiceImpl;
import util.DateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

//@WebServlet(name = "Servlet")
public class Servlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        request.setCharacterEncoding("utf-8");
        String s = request.getParameter("s");
//System.out.println("~~~~~~~~~~~~~~Servlet~~~~~~~~~~~~~doPost()");
        switch (s) {
            case "login":
                login(request, response);
                break;
            case "addSign":
                try {
                    addSign(request, response);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            case "deleteSign":
                try {
                    deleteSign(request,response);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            case  "updateSign":
                try {
                    updateSign(request,response);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            case  "userSign":
                userSign(request,response);
                break;
            case "update1":
                update1(request, response);
                break;
            case "update2":
                update2(request, response);
                break;
            case "addUser":
                addUser(request, response);
                break;
            case "deleteUser":
                deleteUser(request, response);
                break;
            case "updateUser":
                updateUser(request, response);
                break;
        }
    }

    /*添加用户方法*/
    private void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userID = Integer.parseInt(request.getParameter("userID"));
        String name = request.getParameter("name");
        UserService userService = new UserServiceImpl();
        userService.addUser(userID, name, 0);

        /*更新所有用户信息集合*/
        List<User> list3 = userService.listAllUsers();
        request.getSession().setAttribute("list3", list3);

//        request.getRequestDispatcher("view/userInfo.jsp").forward(request, response);
        response.sendRedirect("view/userInfo.jsp");
    }

    /*删除用户方法*/
    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userID = Integer.parseInt(request.getParameter("userID"));
        String name = request.getParameter("name");
        UserService userService = new UserServiceImpl();
        userService.deleteUser(userID, name);

        /*更新所有用户信息集合*/
        List<User> list3 = userService.listAllUsers();
        request.getSession().setAttribute("list3", list3);

//        request.getRequestDispatcher("view/userInfo.jsp").forward(request, response);
        response.sendRedirect("view/userInfo.jsp");
    }

    private void update2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userID = request.getParameter("userID");
        String name = request.getParameter("name");
//        request.setAttribute("userID", userID);
//        request.setAttribute("name", name);
        request.getSession().setAttribute("userID", userID);
        request.getSession().setAttribute("name", name);
//        request.getRequestDispatcher("view/updateUser.jsp").forward(request, response);
        response.sendRedirect("view/updateUser.jsp");
    }

    /*更新用户信息方法*/
    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userID = Integer.parseInt(request.getParameter("userID"));
        String name = request.getParameter("name");
        int userID2 = Integer.parseInt(request.getParameter("userID2"));
        String name2 = request.getParameter("name2");
        UserService userService = new UserServiceImpl();
        userService.updateUser(userID2, name2, userID, name);

        /*更新所有用户信息集合*/
        List<User> list3 = userService.listAllUsers();
        request.getSession().setAttribute("list3", list3);

//        request.getRequestDispatcher("view/userInfo.jsp").forward(request, response);
        response.sendRedirect("view/userInfo.jsp"); 
    }

    /*用户签到方法*/
    private void userSign(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String beginTime = request.getParameter("beginTime");
        String endTime = request.getParameter("endTime");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        System.out.println("------节点4-------");

        SignRecordService srs = new SignRecordServiceImpl();
        int re = srs.userSign(beginTime, endTime, user);
//        结果返回1则签到成功
        if(re==1){
            System.out.println("------节点5-------");

            /*签到成功则更新list4*/
            SignRecordService signRecordService = new SignRecordServiceImpl();
            List<SignRecord> list4 = signRecordService.searchUserSignToday(user);
            request.getSession().setAttribute("list4", list4);

//            request.setAttribute("beginTime",beginTime);
//            request.setAttribute("signMessage", "签到----成功！");
            request.getSession().setAttribute("beginTime",beginTime);
            request.getSession().setAttribute("signMessage", "签到----成功！");
        }
//        结果为0则表示签到时间未开始
        else if (re==0){
//            request.setAttribute("signMessage", "签到未开始！");
        	request.getSession().setAttribute("signMessage", "签到未开始！");

        }
//        结果为2表示签到时间已过
        else if (re==2){
//            request.setAttribute("signMessage", "签到已结束！");
        	request.getSession().setAttribute("signMessage", "签到已结束！");
        }
        System.out.println("------节点3-------");
        //发送请求 返回userSign.jsp页面
//        request.getRequestDispatcher("view/userSign.jsp").forward(request, response);
        response.sendRedirect("view/userSign.jsp"); 
    }

    /*添加签到项方法*/
    private void addSign(HttpServletRequest request, HttpServletResponse response) throws ParseException, ServletException, IOException {
        /*接收前台传来的新建签到项的日期、开始时间和结束时间*/
        Date date = DateUtil.stringToUdate(request.getParameter("signDate"));
        Time time1 = DateUtil.stringToTime(request.getParameter("beginTime"));
        Time time2 = DateUtil.stringToTime(request.getParameter("endTime"));
        SignListService sLService = new SignListServiceImpl();
        sLService.addSign(date,time1,time2);

        /*更新list和list2*/
        List<Sign> list2 = sLService.listAllSigns();
        List<Sign> list = sLService.listAllSignsByToday();
        request.getSession().setAttribute("list", list);
        request.getSession().setAttribute("list2", list2);

//        request.getRequestDispatcher("view/admin.jsp").forward(request, response);
        response.sendRedirect("view/admin.jsp"); 
    }

    /*删除签到项方法*/
    private void deleteSign(HttpServletRequest request, HttpServletResponse response) throws ParseException, ServletException, IOException {
        Date date = DateUtil.stringToUdate(request.getParameter("signDate"));
        Time time1 = DateUtil.stringToTime(request.getParameter("beginTime"));
        Time time2 = DateUtil.stringToTime(request.getParameter("endTime"));

        SignListService signListService = new SignListServiceImpl();
        signListService.deleteSign(date, time1, time2);

        /*更新list和list2*/
        List<Sign> list2 = signListService.listAllSigns();
        List<Sign> list = signListService.listAllSignsByToday();
        request.getSession().setAttribute("list", list);
        request.getSession().setAttribute("list2", list2);

//        request.getRequestDispatcher("view/admin.jsp").forward(request, response);
        response.sendRedirect("view/admin.jsp");
    }

    private void update1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String signDate = request.getParameter("signDate");
        String beginTime = request.getParameter("beginTime");
        String endTime = request.getParameter("endTime");
//        request.setAttribute("signDate", signDate);
//        request.setAttribute("beginTime", beginTime);
//        request.setAttribute("endTime", endTime);
        request.getSession().setAttribute("signDate", signDate);
        request.getSession().setAttribute("beginTime", beginTime);
        request.getSession().setAttribute("endTime", endTime);
System.out.println("%%%%%%%%%%%%begin");
//        request.getRequestDispatcher("view/updateSign.jsp").forward(request, response);
        response.sendRedirect("view/updateSign.jsp");
    }

    /*修改签到项方法*/
    private void updateSign(HttpServletRequest request, HttpServletResponse response) throws ParseException, ServletException, IOException {
        Date date = DateUtil.stringToUdate(request.getParameter("signDate"));
        Time time1 = DateUtil.stringToTime(request.getParameter("beginTime"));
        Time time2 = DateUtil.stringToTime(request.getParameter("endTime"));
        String now = request.getParameter("signDateNew");
        Date dateNew = DateUtil.stringToUdate(now);
        Time time1New = DateUtil.stringToTime(request.getParameter("beginTimeNew"));
        Time time2New = DateUtil.stringToTime(request.getParameter("endTimeNew"));
        SignListService signListService = new SignListServiceImpl();
        signListService.updateSign(date, time1, time2, dateNew, time1New, time2New);

        /*更新list和list2*/
        List<Sign> list2 = signListService.listAllSigns();
        List<Sign> list = signListService.listAllSignsByToday();
        request.getSession().setAttribute("list", list);
        request.getSession().setAttribute("list2", list2);

//        request.getRequestDispatcher("view/admin.jsp").forward(request, response);
        response.sendRedirect("view/admin.jsp");
    }

    /*登录方法*/
    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userID = Integer.parseInt(request.getParameter("userID"));
        String uname = request.getParameter("uname");
      
        System.out.println("-----"+userID+"--------"+uname+"--------");

        User user = new User(userID, uname, 0);
        System.out.println(user.toString());
        UserService us = new UserServiceImpl();
        int result = us.login(userID, uname);

        SignListService signListService = new SignListServiceImpl();
        /*获取当前日期对应的签到项集合*/
        List<Sign> list = signListService.listAllSignsByToday();
        /*获取所有的签到项集合*/
        List<Sign> list2 = signListService.listAllSigns();


        for(Sign sign: list){
            System.out.println(sign.getBeginTime());
            System.out.println(sign.getEndTime());
        }
        /*返回值为1则普通用户登录成功，跳转到用户签到页面*/
        if (result == 1){
            System.out.println("----用户登录成功--------");
            /*将该用户今日的签到记录从数据库中取出来*/
            SignRecordService signRecordService = new SignRecordServiceImpl();
            List<SignRecord> list4 = signRecordService.searchUserSignToday(user);
            
            List<Leave> list5 = new LeaveDao().listLeave();
            
            request.getSession().setAttribute("user", user);
            request.getSession().setAttribute("list", list);
            request.getSession().setAttribute("list4", list4);
            request.getSession().setAttribute("leaves", list5);
//            request.getRequestDispatcher("view/userSign.jsp").forward(request, response);
            response.sendRedirect("view/userSign.jsp");
        }/*返回值为2则管理员登录成功，跳转到管理员页面*/
        else if (result == 2){
            /*获取所有用户信息集合*/
            UserService userService = new UserServiceImpl();
            List<User> list3 = userService.listAllUsers();

            request.getSession().setAttribute("user", user);
            request.getSession().setAttribute("list2", list2);
            request.getSession().setAttribute("list3", list3);
            System.out.println("----管理员登录成功--------");
//            request.getRequestDispatcher("view/admin.jsp").forward(request, response);
            response.sendRedirect("view/admin.jsp");
        }else {
                request.setAttribute("loginInfo", "账号或密码----------错误！");
                request.getRequestDispatcher("view/login.jsp").forward(request, response);
        }
    }
}


