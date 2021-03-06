package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.VideoGame;
import com.revature.dao.VGDAOImpl;


public class VgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	 System.out.println("in doGet");
	 ObjectMapper mapper= new ObjectMapper();
	 VGDAOImpl vgdi= new VGDAOImpl();
	 int id=mapper.readValue(request.getParameter("vgid"), Integer.class);
	 PrintWriter pw = response.getWriter();
	 String vgJSON;
	 try {
		vgJSON = mapper.writeValueAsString(vgdi.getVGById(id));
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		pw.print(vgJSON);
	} catch (JsonProcessingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	//get json from ajax and inseert into db
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in doPost");
		VideoGame vg=null;
		ObjectMapper mapper= new ObjectMapper();
		//convert JSON to java object
		vg=mapper.readValue(request.getInputStream(), VideoGame.class);
		System.out.println();
		VGDAOImpl vgdi= new VGDAOImpl();
		try {
			vgdi.insertVG(vg);
			PrintWriter pw=response.getWriter();
			pw.write("<h3>Added video game</h3>");
			pw.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
