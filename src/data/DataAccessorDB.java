package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
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

//    private Result buildResult(ResultSet rs) throws Exception {
//        
//        int id = rs.getInt(1);
//        int id_member = rs.getInt(2);
//        int id_category = rs.getInt(3);
//        
//        Double time = Double.parseDouble(rs.getString(4));
//        
//        Boolean comp = false;
//        if ("true".equals(rs.getString(5))) {
//            comp = true;
//        }
//        
//        String place = rs.getString(6);
//        
//        return new Result(id, id_member, id_category, time, comp, place);
//        
//    }
    private Result buildResult(ResultSet rs) throws Exception {

        int id = rs.getInt(1);
        String member_name = rs.getString(2);
        String discipline_name = rs.getString(3);

        Double time = Double.parseDouble(rs.getString(4));

        Boolean comp = false;
        if ("true".equals(rs.getString(5))) {
            comp = true;
        }

        String place = rs.getString(6);

        return new Result(id, member_name, discipline_name, time, comp, place);

    }

    public List<Result> getResults() throws Exception {
        List<Result> results = new ArrayList<>();

        //ResultSet rs = con.GetSQLResult("select * from results");
        ResultSet rs = con.GetSQLResult("SELECT idresults, members.name, disciplines.name, time, comp, place FROM delfinen.results\n"
                + "JOIN disciplines ON results.iddisciplines = disciplines.idcategories\n"
                + "JOIN members ON results.idmembers = members.idmembers;");

        while (rs.next()) {
            results.add(buildResult(rs));
        }

        return results;

    }
    
    public void deleteResult(int id) throws Exception {
        String query = "DELETE FROM results where idresults = ?";   
        Connection connection = con.getConnection();
        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setInt(1, id);
        
        pstmt.execute();
    }

    public List<Result> getResultsInDisciplines(int categoryID) throws Exception {
        List<Result> results = new ArrayList<>();

        ResultSet rs = con.GetSQLResult("select * from results where iddisciplines = " + categoryID);

        while (rs.next()) {

            results.add(buildResult(rs));
        }

        return results;
    }

    public List<Result> getResultsForMember(String memberID) throws Exception {
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
        List<Member> members = new ArrayList<>();
        ResultSet rs = con.GetSQLResult("select * from members");
        while (rs.next()) {
            members.add(new Member(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    LocalDate.parse(rs.getString(4)),
                    rs.getBoolean(5),
                    rs.getBoolean(6)));
        }
        return members;

    }

    @Override
    public List<Member> searchMailForMembers(String email) throws Exception {
        List<Member> members = new ArrayList<>();
        ResultSet rs = con.GetSQLResult("select * from members where email='" + email + "'");
        while (rs.next()) {
            members.add(new Member(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    LocalDate.parse(rs.getString(4)),
                    rs.getBoolean(5),
                    rs.getBoolean(6)));
        }
        return members;
    }

    @Override
    public Member getMember(int id) throws Exception {
        Member member = null;
        ResultSet rs = con.GetSQLResult("select * from members where id=" + id);
        while (rs.next()) {
            member = new Member(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    LocalDate.parse(rs.getString(4)),
                    rs.getBoolean(5),
                    rs.getBoolean(6));
        }
        return member;
    }

    @Override
    public void createMember(Member member, boolean[] disciplines) throws Exception {
        try {
            Connection connection = con.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(
                    "INSERT INTO members "
                    + "(name, email, birthday, active, elite) "
                    + "VALUES (?,?,?,?,?)");
            pstmt.setString(1, member.getName());
            pstmt.setString(2, member.getEmail());
            pstmt.setString(3, member.getBirthday().toString());
            pstmt.setString(4, "" + member.isActive());
            pstmt.setString(5, "" + member.isElite());
            con.newQuery(pstmt);
            
            ResultSet rs = con.GetSQLResult("SELECT @@IDENTITY");
            while(rs.next()) {
                System.out.println(rs.toString());
            }

//            pstmt = connection.prepareStatement(
//                    "INSERT INTO members_disciplines "
//                    + "(memberID, discipline1, discipline2, discipline3, discipline4) "
//                    + "VALUES (?,?,?,?,?)");
//            pstmt.setInt(1, member.getID());
//            pstmt.setString(2, "" + disciplines[0]);
//            pstmt.setString(3, "" + disciplines[1]);
//            pstmt.setString(4, "" + disciplines[2]);
//            pstmt.setString(5, "" + disciplines[3]);
//            con.newQuery(pstmt);

        } catch (Exception e) {
            throw new Exception();
        }
        Connection connection = con.getConnection();
         PreparedStatement pstmt = connection.prepareStatement(
                    "INSERT INTO members_disciplines "
                    + "(memberID, discipline1, discipline2, discipline3, discipline4) "
                    + "VALUES (?,?,?,?,?)");
            pstmt.setInt(1, member.getID());
            pstmt.setString(2, "" + disciplines[0]);
            pstmt.setString(3, "" + disciplines[1]);
            pstmt.setString(4, "" + disciplines[2]);
            pstmt.setString(5, "" + disciplines[3]);
            con.newQuery(pstmt);
    }

    @Override
    public void editMember(Member member, boolean[] disciplines) throws Exception {
        try {
            Connection connection = con.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(
                    "UPDATE members "
                    + "SET name = ?, email = ?, birthday = ?, active = ?, elite = ?) "
                    + "WHERE idmembers=" + member.getID());
            pstmt.setString(1, member.getName());
            pstmt.setString(2, member.getEmail());
            pstmt.setString(3, member.getBirthday().toString());
            pstmt.setString(4, "" + member.isActive());
            pstmt.setString(5, "" + member.isElite());
            con.newQuery(pstmt);

            pstmt = connection.prepareStatement(
                    "UPDATE members_disciplines "
                    + "SET discipline1=?, discipline2=?, discipline3=?, discipline4=? "
                    + "WHERE memberID=" + member.getID());
            pstmt.setString(1, "" + disciplines[0]);
            pstmt.setString(2, "" + disciplines[1]);
            pstmt.setString(3, "" + disciplines[2]);
            pstmt.setString(4, "" + disciplines[3]);
            con.newQuery(pstmt);

        } catch (Exception e) {
            throw new Exception();
        }
    }

    @Override
    public void deleteMember(int id) throws Exception {
        
        String query = "DELETE FROM members where idmembers = ?";   
        Connection connection = con.getConnection();
        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setInt(1, id);
        
        pstmt.execute();
        
//        try {
//            con.newQuery("DELETE FROM `delfinen`.`members` WHERE (`idmembers` = '" + id + "')");
//            //con.newQuery("DELETE FROM delfinen.members WHERE idmembers=" + id);
//            //con.newQuery("DELETE FROM members_disciplines WHERE memberID=" + id);
//        } catch (Exception e) {
//            throw new Exception();
//        }
    }

}
