package logic;

import data.DataAccessorDB;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TesterMain {
    
   
    
    public static void main(String[] args) {
         Controller logic = new Controller();
         DataAccessorDB sql = new DataAccessorDB();
        try {
            Member member = sql.getMember(3);
            System.out.println(member);
        } catch (Exception ex) {
            Logger.getLogger(TesterMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
