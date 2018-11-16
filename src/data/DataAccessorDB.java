package data;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.Discipline;
import logic.Member;
import logic.Result;

/**
 *
 * @author caspe
 */
public class DataAccessorDB implements DataAccessorInterface {
    
    DBConnector con = null;
    
    public DataAccessorDB() {
        
        try {
            con = new DBConnector();
        } catch (Exception ex) {
            Logger.getLogger(DataAccessorDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private Result buildResult(ResultSet rs) throws Exception {
        
        int id = rs.getInt(1);
        int id_member = rs.getInt(2);
        int id_category = rs.getInt(3);
        
        Double time = Double.parseDouble(rs.getString(4));
        
        Boolean comp = false;
        if ("true".equals(rs.getString(5))) {
            comp = true;
        }
        
        String place = rs.getString(6);
        
        return new Result(id, id_member, id_category, time, comp, place);
        
    }
    
    public List<Result> getResults() throws Exception {
        List<Result> results = new ArrayList<>();
        
        ResultSet rs = con.GetSQLResult("select * from results");
                
        while (rs.next()) {
            results.add(buildResult(rs));
        }
        
        return results;
        
    }
    
    public List<Result> getResultsInDisciplines(int categoryID) throws Exception {
        List<Result> results = new ArrayList<>();
        
        ResultSet rs = con.GetSQLResult("select * from results where iddisciplines = " + categoryID);
        
        while (rs.next()) {
            
            results.add(buildResult(rs));
        }
        
        return results;
    }
    
    public List<Result> getResultsForMember(String memberID ) throws Exception {
        List<Result> results = new ArrayList<>();
        
        ResultSet rs = con.GetSQLResult("select * from results where idmembers = " + memberID);
        
        while (rs.next()) {
            results.add(buildResult(rs));
        }
        
        return results;
    }
    
    public List<Discipline> getDisciplines() throws Exception {
        List<Discipline> disciplines = new ArrayList<>();
        
        ResultSet rs = con.GetSQLResult("select * from disciplines;");
        
        while (rs.next()) {
            Discipline discipline = new Discipline(rs.getInt("idcategories"), rs.getString("name"));
            disciplines.add(discipline);
        }
        
        return disciplines;
    }
    
    @Override
    public List<Member> getMembers() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<Member> searchMailForMembers(String email) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Member getMember(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void createMember(Member member) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void editMember(Member member) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void deleteMember(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
