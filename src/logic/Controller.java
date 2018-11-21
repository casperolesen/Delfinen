package logic;

import com.mysql.cj.result.SqlDateValueFactory;
import data.DataAccessorDB;
import data.DataAccessorFile;
import data.DataAccessorInterface;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author caspe
 */
public class Controller implements ControllerInterface {

    //private DataAccessorInterface data = new DataAccessorFile();
    public List<Member> memberList = null;
    
    private DataAccessorDB sqldata = new DataAccessorDB();
    public List<Result> resultList = null;
    public List<Discipline> categoryList = null;
    public List<Payment> paymentList = null;
    
    public List<Member> missingPaymentList = null;

    public String getNumberFact(int number) throws Exception {
        URL url = new URL("http://numbersapi.com/" + number);
        InputStream is = url.openStream();
        BufferedReader ind = new BufferedReader(new InputStreamReader(is));
        
        String result = ind.readLine();
        
        return result;
    }
    
    public double getAmountToPay(Member member) throws NumberFormatException {
        String _memberAge = (member.getBirthday().toString()).substring(0, 4);
        int memberBday = Integer.parseInt(_memberAge);
        int memberAge = (Calendar.getInstance().get(Calendar.YEAR) - memberBday);
        double price = 0.00;
        
        LocalDate today = LocalDate.now();
        LocalDate birth = member.getBirthday();
        Period period = Period.between(birth, today);
        
        Integer years = period.getYears();
        //System.out.println(years);
       
        if (!member.isActive()) {
            price = 500;
            return price;
        }
        
        if (memberAge < 18) {
            price = 1000;
        }
        
        if (memberAge >= 18 && memberAge < 60) {
            price = 1600;
        }
        
        if (memberAge >= 60) {
            price = 1200;
        }
        
        return price;
        
    }

    @Override
    public int getTotalNumberOfMembers() throws Exception {
        return memberList.size();
    }

    @Override
    public int getTotalNumberOfActiveMembers() throws Exception {

        int numberOfActiveMembers = 0;
        for (Member member : memberList) {
            if (member.isActive()) {
                numberOfActiveMembers++;
            }
        }
        return numberOfActiveMembers;
    }

    @Override
    public int getTotalNumberOfNotActiveMembers() throws Exception {
        
        int numberOfNotActiveMembers = 0;
        for (Member member : memberList) {
            if (!member.isActive()) {
                numberOfNotActiveMembers++;
            }
        }
        return numberOfNotActiveMembers;
    }

    @Override
    public boolean checkEmail(String email) throws Exception {
        return email.contains("@");
    }
    
    @Override
    public void updateResultList() throws Exception {
        this.resultList = sqldata.getResults();
    }
    
    public void createResult(int memberID, int disciplineID, String time, String comp, String place) throws Exception {
        sqldata.createResult(memberID, disciplineID, time, comp, place);
    }
    
    
    @Override
    public void getResultsInCategory(int categoryID) throws Exception {
        this.resultList = sqldata.getResultsInDisciplines(categoryID);
    }
    
    @Override
    public void getResultsForMember(String memberID) throws Exception {
        this.resultList = sqldata.getResultsForMember(memberID);
    }
    
    @Override
    public void deleteResult(int id) throws Exception {
        sqldata.deleteResult(id);
    }
    
    @Override
    public void updateCategoryList() throws Exception {
        this.categoryList = sqldata.getDisciplines();
    }
    
    @Override
    public void deleteMember(int id) throws Exception{
        sqldata.deleteMember(id);
        //data.deleteMember(id);
    }
    
    @Override
    public void updateMemberList() throws Exception{
        //memberList = data.getMembers();
        memberList = sqldata.getMembers();
    }
    
    @Override
    public void updateMemberList(String email) throws Exception{
        memberList = sqldata.searchMailForMembers(email);
        //memberList = data.searchMailForMembers(email);
    }
    
    @Override
    public void editMember(Member member, boolean[] discs) throws Exception{
        //data.editMember(member, discs);
        sqldata.editMember(member, discs);
    }
    
    @Override
     public void createMember(Member member, boolean[] discs) throws Exception{
         sqldata.createMember(member, discs);
        //data.createMember(member, discs);
    }
     
     public void updatePaymentList() throws Exception {
         this.paymentList = sqldata.getPayments();
     }
     
     public Member getMember(int id) throws Exception {
         Member member = sqldata.getMember(id);
         
         return member;
     }
     
     public void createPayment(Payment payment) throws Exception {
         sqldata.createPayment(payment);
     }
     
     public void updateMissingPaymentList() throws Exception {
         this.missingPaymentList = sqldata.getMissingPayments();
     }
     
     public void deletePayment(int id) throws Exception {
         sqldata.deletePayment(id);
     }
     
     

}
