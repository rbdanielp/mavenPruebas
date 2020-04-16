package uy.edu.fing.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uy.edu.fing.beans.AddBean;
import uy.edu.fing.beans.AddEJB;

@WebServlet(urlPatterns= {"/AddServlet"})
public class AddServlet extends HttpServlet {
	
	@EJB 
	AddEJB obj; 

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		
		PrintWriter out= res.getWriter();
		 
		int i = Integer.parseInt(req.getParameter("t1")) ;
		int j = Integer.parseInt(req.getParameter("t2")) ;
		
		//int k = i+j;
		//int k = add(i,j);
		//AddBean obj= new AddBean();
		obj.setI(i);
		obj.setJ(j);
		
		obj.add();
		
		int k= obj.getK();
		
		out.println("La suma (usando EJB) es : " + k);
	}
	
//	public int add(int i, int j) 
//	{
//		System.out.println("Estoy en el metodo Add");
//		return i+j;
//		
//	}

}
