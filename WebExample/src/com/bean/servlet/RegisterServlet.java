package com.bean.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		File file = new File("/upload");
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(file);
		factory.setSizeThreshold(1024 * 1024);
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			
			List<FileItem> fileitems = upload.parseRequest(request);
			
			for (FileItem fileItem : fileitems) {
			
				String fieldName = fileItem.getFieldName();
				
				if (fileItem.isFormField())
				{
					
					String userName = request.getParameter("userName");
					String password = request.getParameter("password");
					
					System.out.println("==" + userName + "====" + password);
					
				} else {
					
					
					/** 
                     * 以下三步，主要获取 上传文件的名字 
                     */  
                    //获取路径名  
                    String value = fileItem.getName() ;  
                    //索引到最后一个反斜杠  
                    int start = value.lastIndexOf("\\");  
                    //截取 上传文件的 字符串名字，加1是 去掉反斜杠，  
                    String filename = value.substring(start+1);  
                      
                    request.setAttribute(fieldName, filename);  
                      
                    //真正写到磁盘上  
                    //它抛出的异常 用exception 捕捉  
                      
                    //item.write( new File(path,filename) );//第三方提供的  
                      
                    //手动写的  
                    OutputStream out = new FileOutputStream(new File(file,filename));  
                      
                    InputStream in = fileItem.getInputStream() ;  
                      
                    int length = 0 ;  
                    byte [] buf = new byte[1024] ;  
                      
                    System.out.println("获取上传文件的总共的容量："+fileItem.getSize());  
  
                    // in.read(buf) 每次读到的数据存放在   buf 数组中  
                    while( (length = in.read(buf) ) != -1)  
                    {  
                        //在   buf 数组中 取出数据 写到 （输出流）磁盘上  
                        out.write(buf, 0, length);  
                          
                    }  
                      
                    in.close();  
                    out.close();  
                }  
            }
			
		} catch (FileUploadException e) {
			
			e.printStackTrace();
		}
	}
}