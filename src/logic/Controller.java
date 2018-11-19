package logic;

import data.DataAccessorDB;
import data.DataAccessorFile;
import data.DataAccessorInterface;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
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

    public String getNumberFact(int number) throws Exception {
        URL url = new URL("http://numbersapi.com/" + number);
        InputStream is = url.openStream();
        BufferedReader ind = new BufferedReader(new InputStreamReader(is));
        
        String result = ind.readLine();
        
        return result;
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
    public boolean checkEmail(String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void updateResultList() throws Exception {
        this.resultList = sqldata.getResults();
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
     
     

}
