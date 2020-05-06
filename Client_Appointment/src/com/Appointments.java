package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Appointments {

	private Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			// Provide the correct details: DBServer/DBName, username, password
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/appointment", "root", "");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	/*
	 * public String insertAppointments(String pid, String pname, String gender,
	 * String dname, String roomNo, String date, String time, String hname) { String
	 * output = "";
	 * 
	 * try { Connection con = connect(); if (con == null) { return
	 * "Error while connecting to the database for inserting."; }
	 * 
	 * // create a prepared statement String query =
	 * " insert into appointment('AID','PID' ,'PName','Gender','DName','RoomNo','Date','Time','HName') "
	 * + " values (NULL,?,?,?,?,?,?,?,?)"; PreparedStatement preparedStmt =
	 * con.prepareStatement(query);
	 * 
	 * // binding values //preparedStmt.setInt(1, 0); preparedStmt.setString(1,
	 * pid); preparedStmt.setString(2, pname); preparedStmt.setString(3, gender);
	 * preparedStmt.setString(4, dname); preparedStmt.setString(5, roomNo);
	 * preparedStmt.setString(6, date); preparedStmt.setString(7, time);
	 * preparedStmt.setString(8, hname);
	 * 
	 * // execute the statement preparedStmt.execute(); con.close(); String
	 * newAppointments = readAppointments(); output =
	 * "{\"status\":\"success\", \"data\": \"" + newAppointments + "\"}";
	 * 
	 * } catch (Exception e) { output =
	 * "{\"status\":\"error\", \"data\":\"Error while inserting the appointment.\"}"
	 * ; System.err.println(e.getMessage()); } return output; }
	 */

	public String insertAppointments(String pid,String pname,String gender,String dname,String roomNo,String date,String time,String hname)
	{
		
		String output = "";
		 try
		 {
		 Connection con = connect();
		 if (con == null)
		 {
		 return "Error while connecting to the database for inserting.";
		 }
		 // create a prepared statement
		 String query = " insert into appointment (`AID`,`PID`,`PName`,`Gender`,`DName`,`RoomNo`,`Date`,`Time`,`HName`)"
		 + " values (?,?, ?, ?, ?, ?,?,?,?)";
		 
		 PreparedStatement preparedStmt = con.prepareStatement(query);
		 // binding values
		 preparedStmt.setInt(1, 0);
		 preparedStmt.setString(2, pid);
		 preparedStmt.setString(3, pname);
		 preparedStmt.setString(4, gender);
		 preparedStmt.setString(5, dname);
		 preparedStmt.setString(6, roomNo);
		 preparedStmt.setString(7, date);
		 preparedStmt.setString(8, time);
		 preparedStmt.setString(9, hname);
		 
		 // execute the statement
		 preparedStmt.execute();
		 con.close();
		 String newAppointments = readAppointments();
		 output = "{\"status\":\"success\", \"data\": \"" + newAppointments + "\"}";
		 }
		 catch (Exception e)
		 {
		 output = "{\"status\":\"error\", \"data\":\"Error while inserting the item.\"}";
		 System.err.println(e.getMessage());
		 }
		 return output;
		 }

	public String readAppointments() {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			// Prepare the html table to be displayed

			output = "<table border='1'><tr><th>Appointment ID</th>"
					+ " <th>Patient ID</th> <th>Patient Name</th> <th>Gender</th> "
					+ "<th>Doctor Name</th> <th>Room Number</th> <th>Date</th> <th>Time</th>"
					+ " <th>Hospital Name</th>" + "<th>Update</th><th>Remove</th></tr>";

			String query = "select * from appointment";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			// iterate through the rows in the result set

			while (rs.next()) {
				String AID = Integer.toString(rs.getInt("AID"));
				String PID = rs.getString("PID");
				String PName = rs.getString("PName");
				String Gender = rs.getString("Gender");
				String DName = rs.getString("DName");
				String RoomNo = rs.getString("RoomNo");
				String Date = rs.getString("Date");
				String Time = rs.getString("Time");
				String HName = rs.getString("HName");

				// Add into the html table
				output += "<tr><td><input id='hidAIDUpdate'name='hidAIDUpdate' type='hidden'value='" + AID + "'>" + AID
						+ "</td>";
				output += "<td>" + PID + "</td>";
				output += "<td>" + PName + "</td>";
				output += "<td>" + Gender + "</td>";
				output += "<td>" + DName + "</td>";
				output += "<td>" + RoomNo + "</td>";
				output += "<td>" + Date + "</td>";
				output += "<td>" + Time + "</td>";
				output += "<td>" + HName + "</td>";

				// buttons
				output += "<td><input name='btnUpdate' type='button'value='Update'"
						+ "class='btnUpdate btn btn-secondary'></td><td><input name='btnRemove'"
						+ " type='button'value='Remove'class='btnRemove btn btn-danger' data-aid='" + AID + "'>"
						+ "</td></tr>";
			}
			con.close();
			// Complete the html table
			output += "</table>";

		} catch (Exception e) {
			output = "Error while reading the appointments.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String updateAppointments(String Aid, String dname, String roomNo,
			String date, String time, String hname) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for updating.";
			}

			// create a prepared statement

			String query = "UPDATE appointment SET DName=?,RoomNo=?,Date=?,Time=?,HName=? WHERE AID=?";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
		
			preparedStmt.setString(1,dname);
			preparedStmt.setString(2,roomNo);
			preparedStmt.setString(3,date);
			preparedStmt.setString(4,time);
			preparedStmt.setString(5,hname);
			preparedStmt.setInt(6,Integer.parseInt(Aid));

			// execute the statement

			preparedStmt.execute();
			con.close();
			String newAppointments = readAppointments();
			output = "{\"status\":\"success\", \"data\": \"" + newAppointments + "\"}";
		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\":\"Error while updating the appointment.\"}";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String deleteAppointments(String AID) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for deleting.";

			}

			// create a prepared statement

			String query = "delete from appointment where AID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values

			preparedStmt.setInt(1, Integer.parseInt(AID));

			// execute the statement

			preparedStmt.execute();
			con.close();
			String newAppointments = readAppointments();
			output = "{\"status\":\"success\", \"data\": \"" + newAppointments + "\"}";
		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\":\"Error while deleting the appointment.\"}";
			System.err.println(e.getMessage());
		}
		return output;
	}

}
