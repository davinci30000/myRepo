package com.mkyong.common.form;

import java.io.File;

import org.apache.struts.action.ActionForm;

public class HelloWorldForm extends ActionForm{
	
	String message;
	File file;

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}