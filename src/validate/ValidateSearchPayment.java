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
public class ValidateSearchPayment {
    public static boolean validate_searchPayment(String PayID) {   //Validate Payment Id in the Payment Table
        try {
            
       Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitalmanagementsystem?" + "user=root&password=");     
       PreparedStatement pst = conn.prepareStatement("Select * from paiment where PaimentID=?");
       pst.setString(1, PayID); 
       
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
