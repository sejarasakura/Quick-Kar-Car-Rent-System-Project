/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _servlet.admin_console;

import _domain.CarType;
import _domain.Driver;
import _enum.ErrorDetails;
import _enum.QuicKarType;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ITSUKA KOTORI
 */
public class admin_addCarType extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String car_plate_number = request.getParameter("car_plate_number").replace("#", "");
        String car_type_s = request.getParameter("car_type").split("-")[0];
        CarType car_type = (CarType) new _da.CarTypeDA().getRecord(car_type_s);
        QuicKarType quickar_typee = QuicKarType.getValue(request.getParameter("quickar_type"));
        Driver driver = (Driver)request.getSession().getAttribute("driver");
        _domain.Car car = new _domain.Car(car_plate_number, car_type, driver.getFull_Name(), quickar_typee, driver);
        _da.CarDA da_car = new _da.CarDA();
        boolean car_added = da_car.addRecord(car);
        if(car_added){
            response.sendRedirect("http://localhost:8080/GroupProject/_page/admin_console/driver/create/done.jsp?id=" +
                    car.getCar_plate_number().replace("#", " ") + "&added=" + car_added + "&driver_id=" + driver.getDriver_id());   
        }else{
            response.sendRedirect("http://localhost:8080/GroupProject/_page/error/error_page_design.jsp?"
                    + ErrorDetails.E009.getUrl() + "&url=Add_Cartype");   
        }
    }

}
