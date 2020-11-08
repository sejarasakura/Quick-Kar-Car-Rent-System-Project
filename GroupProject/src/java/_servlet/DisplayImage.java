/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author xps
 */
public class DisplayImage extends HttpServlet {

  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
      _da.ImageDA da = new _da.ImageDA();
      try {
          byte[] data = null;
          String id = null;
          try {
              id = (String)(request.getParameter("id"));
          } catch (Exception e) {
 
          }
          if(id != null)
              data = da.getImageByte(id);
          if (data == null) {
              // No record found, redirect to default image.
              response.sendRedirect("http://localhost:8080/GroupProject/_resource/user/unknow.jpg");
              return;
          }
          response.setHeader("Content-Type", "image/jpg");
          response.setHeader("Content-Length", String.valueOf(data.length));
          response.setHeader("Content-Disposition", "inline; filename=\"" + "profile picture.png" + "\"");
          // Write image data to Response.
          response.getOutputStream().write(data);
          
      } catch (Exception e) {
          throw new ServletException(e);
      }
      return;
  }
 
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
      doGet(request, response);
  }
 
}
