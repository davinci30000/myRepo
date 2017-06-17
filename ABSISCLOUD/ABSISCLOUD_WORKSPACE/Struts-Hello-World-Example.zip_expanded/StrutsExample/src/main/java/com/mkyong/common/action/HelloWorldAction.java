package com.mkyong.common.action;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.mkyong.common.form.HelloWorldForm;

public class HelloWorldAction extends Action{
	
	public ActionForward execute(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		HelloWorldForm helloWorldForm = (HelloWorldForm) form;
		String message=(null!=helloWorldForm.getMessage())?helloWorldForm.getMessage():"no";
		if(helloWorldForm.getFile() instanceof File ){
			if(null!=helloWorldForm.getFile()){
			message= "si tiooo";
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/PAC2_UF2_DJM", "root", "root");
			PreparedStatement st =con.prepareStatement("INSERT INTO miblob(fichero) values(?)");
			st.setBlob(1, new FileInputStream(helloWorldForm.getFile()));
			st.execute();}
			request.setAttribute("hola", "hola");
		}
		if(null!=request.getParameter("text")){
			message=request.getParameter("text");
		}
		helloWorldForm.setMessage(message);
		request.setAttribute("hola", "hola");
		return mapping.findForward("success");
	}
	
}