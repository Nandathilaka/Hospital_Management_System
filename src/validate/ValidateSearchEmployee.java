/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author user
 */
public class ValidateSearchEmployee {
    public static boolean validate_searchEmp(String EmpID) { //Validate Employee ID in the emplyee Table
        try {
            
       Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitalmanagementsystem?" + "user=root&password=");     
       PreparedStatement pst = conn.prepareStatement("Select * from employeeregistration where EmployeeID=?");
       pst.setString(1, EmpID);
       
       
       ResultSet rs = pst.executeQuery();                        
       if(rs.next())            
           return true;    
       else
           return false;
            
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
