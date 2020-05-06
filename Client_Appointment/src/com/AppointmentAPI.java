package com;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Servlet implementation class AppointmentAPI
 */
@WebServlet("/AppointmentAPI")
public class AppointmentAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Appointments AppObj = new Appointments();
       
 
    public AppointmentAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
		String PID = request.getParameter("PID").toString();
		String PName = request.getParameter("PName").toString();
		String Gender=request.getParameter("Gender").toString();
		String DName =request.getParameter("DName").toString();
	    String RoomNo = request.getParameter("RoomNo").toString();
	    String stringdate=request.getParameter("Date").toString();
	    String stringtime=request.getParameter("Time").toString();
	    String HName = request.getParameter("HName").toString(); 
	    
		 String output = AppObj.insertAppointments( 
				 PID,
				 PName,
				 Gender,
				 DName,
				 RoomNo,
				 stringdate,
				 stringtime,
		         HName);
		 
		 System.out.println(output);
		 
		 response.getWriter().write(output);
	
		
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
			
			{
			Map paras = getParasMap(request);
			
			String output = AppObj.updateAppointments(paras.get("hidAIDSave").toString(),
			paras.get("DName").toString(),
			paras.get("RoomNo").toString(),
            paras.get("Date").toString(),
            paras.get("Time").toString(),
            paras.get("HName").toString());
			
			response.getWriter().write(output);
			}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
			{
			Map paras = getParasMap(request);
			String output = AppObj.deleteAppointments(paras.get("AID").toString());
			response.getWriter().write(output);
			System.out.println(output);
			}
	

	
	
	private static Map getParasMap(HttpServletRequest request)
	{
	Map<String, String> map = new HashMap<String, String>();
	try
	{
	Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");
	String queryString = scanner.hasNext() ?
	scanner.useDelimiter("\\A").next() : "";
	scanner.close();
	String[] params = queryString.split("&");
	for (String param : params)
	{
	
	String[] p = param.split("=");
	map.put(p[0], p[1]);
	}
	}
	catch (Exception e)
	{
	}
	return map;
	}

}
