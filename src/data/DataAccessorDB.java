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
import logic.Payment;
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

    @Override
    public List<Result> getResults() throws Exception {
        List<Result> results = new ArrayList<>();

        //ResultSet rs = con.GetSQLResult("select * from results");
        ResultSet rs = con.GetSQLResult("SELECT idresults, members.name, disciplines.name, time, comp, place FROM delfinen.results\n"
                + "JOIN disciplines ON results.iddisciplines = disciplines.idcategories\n"
                + "JOIN members ON results.idmembers = members.idmembers");

        while (rs.next()) {
            results.add(buildResult(rs));
        }

        return results;

    }

    @Override
    public void createResult(int memberID, int disciplineID, String time, String comp, String place) throws Exception {
        int membID = memberID;
        int discID = disciplineID;
        String theTime = time;
        String theComp = comp;
        String thePlace = place;

        Connection connection = con.getConnection();
        PreparedStatement pstmt = connection.prepareStatement("INSERT INTO `delfinen`.`results` (`idmembers`, `iddisciplines`, `time`, `comp`, `place`) VALUES (?, ?, ?, ?, ?)");

        pstmt.setInt(1, memberID);
        pstmt.setInt(2, disciplineID);
        pstmt.setString(3, time);
        pstmt.setString(4, comp);
        pstmt.setString(5, place);

        con.newQuery(pstmt);
    }

    @Override
    public void deleteResult(int id) throws Exception {
        String query = "DELETE FROM results where idresults = ?";
        Connection connection = con.getConnection();
        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setInt(1, id);

        pstmt.execute();
    }

    @Override
    public List<Result> getResultsInDisciplines(int categoryID) throws Exception {
        List<Result> results = new ArrayList<>();

        ResultSet rs = con.GetSQLResult("SELECT idresults, members.name, disciplines.name, MIN(time), comp, place FROM delfinen.results "
                + "JOIN disciplines ON results.iddisciplines = disciplines.idcategories "
                + "JOIN members ON results.idmembers = members.idmembers "
                + "GROUP BY results.idmembers, iddisciplines "
                + "HAVING iddisciplines = " + categoryID + " ORDER BY MIN(time) ASC LIMIT 5");
        //ResultSet rs = con.GetSQLResult("select * from results where iddisciplines = " + categoryID + " LIMIT 3");

        while (rs.next()) {

            results.add(buildResult(rs));
        }

        return results;
    }

    @Override
    public List<Result> getResultsForMember(String memberID) throws Exception {
        List<Result> results = new ArrayList<>();

        ResultSet rs = con.GetSQLResult("select idresults, members.name, disciplines.name, time, comp, place from results "
                + "join members on results.idmembers = members.idmembers "
                + "join disciplines on results.iddisciplines = disciplines.idcategories "
                + "where members.email = '" + memberID+"'");

        while (rs.next()) {
            results.add(buildResult(rs));
        }

        return results;
    }

    @Override
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
                    rs.getBoolean(6),
                    getMembersDisciplines(rs.getInt(1))));
        }
        return members;

    }

    private boolean[] getMembersDisciplines(int id) throws Exception {
        boolean[] disc = new boolean[4];
        ResultSet rs = con.GetSQLResult("SELECT * FROM members_disciplines WHERE memberID=" + id);

        while (rs.next()) {

            if (rs.getString("discipline1").equals("true")) {
                disc[0] = true;
            } else {
                disc[0] = false;
            }

            if (rs.getString("discipline2").equals("true")) {
                disc[1] = true;
            } else {
                disc[1] = false;
            }

            if (rs.getString("discipline3").equals("true")) {
                disc[2] = true;
            } else {
                disc[2] = false;
            }

            if (rs.getString("discipline4").equals("true")) {
                disc[3] = true;
            } else {
                disc[3] = false;
            }
//            disc[0] = Boolean.getBoolean(rs.getString("discipline1"));
//            disc[1] = Boolean.getBoolean(rs.getString("discipline2"));
//            disc[2] = Boolean.getBoolean(rs.getString("discipline3"));
//            disc[3] = Boolean.getBoolean(rs.getString("discipline4"));
        }

        return disc;
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

//    public List<Member> getMemberByID(int id) throws Exception {
//        Member meber = null;
//        ResultSet rs = con.GetSQLResult("select * from members where 
//    }
    @Override
    public Member getMember(int id) throws Exception {
        Member member = null;
        ResultSet rs = con.GetSQLResult("select * from members where idmembers=" + id);
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

            int currentID = 0;
            ResultSet rs = con.GetSQLResult("SELECT @@IDENTITY");
            while (rs.next()) {
                currentID = rs.getInt(1);
            }

            pstmt = connection.prepareStatement(
                    "INSERT INTO members_disciplines "
                    + "(memberID, discipline1, discipline2, discipline3, discipline4) "
                    + "VALUES (?,?,?,?,?)");
            pstmt.setInt(1, currentID);
            pstmt.setString(2, "" + disciplines[0]);
            pstmt.setString(3, "" + disciplines[1]);
            pstmt.setString(4, "" + disciplines[2]);
            pstmt.setString(5, "" + disciplines[3]);
            con.newQuery(pstmt);

        } catch (Exception e) {
            throw new Exception();
        }
    }

    @Override
    public void editMember(Member member, boolean[] disciplines) throws Exception {
        try {
            Connection connection = con.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(
                    "UPDATE members "
                    + "SET name = ?, email = ?, birthday = ?, active = ?, elite = ? "
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
            pstmt.setString(1, String.valueOf(disciplines[0]));
            pstmt.setString(2, String.valueOf(disciplines[1]));
            pstmt.setString(3, String.valueOf(disciplines[2]));
            pstmt.setString(4, String.valueOf(disciplines[3]));

//            pstmt.setString(1, "" + disciplines[0]);
//            pstmt.setString(2, "" + disciplines[1]);
//            pstmt.setString(3, "" + disciplines[2]);
//            pstmt.setString(4, "" + disciplines[3]);
            con.newQuery(pstmt);

        } catch (Exception e) {
            throw new Exception();
        }
    }

    @Override
    public void deleteMember(int id) throws Exception {

        try {
            String query = "DELETE FROM members where idmembers = ?";
            Connection connection = con.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, id);

            pstmt.execute();
        } catch (Exception e) {

        }

        try {
            String query = "DELETE FROM members_disciplines where memberID = ?";
            Connection connection = con.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, id);

            pstmt.execute();
        } catch (Exception e) {

        }

        try {
            //con.newQuery("DELETE FROM `delfinen`.`members` WHERE (`idmembers` = '" + id + "')");
            //con.newQuery("DELETE FROM delfinen.members WHERE idmembers=" + id);
            //con.newQuery("DELETE FROM members_disciplines WHERE memberID=" + id);
        } catch (Exception e) {
            throw new Exception();
        }
    }

    @Override
    public List<Payment> getPayments() throws Exception {
        List<Payment> allPayments = new ArrayList<>();

        ResultSet rs = con.GetSQLResult("SELECT idpayments, members.name, year, amount, date FROM delfinen.payments join members on payments.idmembers = members.idmembers");

        while (rs.next()) {
            int id = rs.getInt(1);
            String memberName = rs.getString(2);
            String year = String.valueOf(rs.getInt(3));
            double amount = rs.getDouble(4);
            String date = rs.getString(5);

            Payment payment = new Payment(id, memberName, year, amount, date);
            allPayments.add(payment);
        }

        return allPayments;
    }

    @Override
    public List<Member> getMissingPayments() throws Exception {
        List<Member> missingPayments = new ArrayList<>();

        ResultSet rs = con.GetSQLResult("SELECT members.idmembers, members.name, members.email, members.birthday, members.active, members.elite, "
                + "MAX(payments.year), payments.idmembers"
                + " from members LEFT OUTER JOIN payments on members.idmembers = payments.idmembers GROUP BY members.idmembers HAVING (payments.idmembers IS NULL OR MAX(payments.year) < "+LocalDate.now().getYear()+")");

        while (rs.next()) {
            Member member = new Member(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    LocalDate.parse(rs.getString(4)),
                    rs.getBoolean(5),
                    rs.getBoolean(6));

            missingPayments.add(member);
        }

        return missingPayments;
    }

    @Override
    public void createPayment(Payment payment) throws Exception {
        Connection connection = con.getConnection();
        PreparedStatement pstmt = connection.prepareStatement("INSERT INTO `delfinen`.`payments` (`idmembers`, `year`, `amount`, `date`) VALUES (?, ?, ?, ?)");

        pstmt.setInt(1, payment.getMemberID());
        pstmt.setString(2, payment.getPaymentYear());
        pstmt.setDouble(3, payment.getAmount());
        pstmt.setString(4, payment.getPaymentDate());

        pstmt.execute();
    }

    @Override
    public void deletePayment(int id) throws Exception {
        String query = "DELETE FROM payments where idpayments = ?";
        Connection connection = con.getConnection();
        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setInt(1, id);

        pstmt.execute();
    }

}
