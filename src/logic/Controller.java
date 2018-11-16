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

    private DataAccessorInterface data = new DataAccessorFile();
    public List<Member> memberList = null;
    
    private DataAccessorDB sqldata = new DataAccessorDB();
    public List<Result> resultList = null;
    public List<Category> categoryList = null;

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
    
    public void updateResultList() throws Exception {
        this.resultList = sqldata.getResults();
    }
    
    
    public void getResultsInCategory(int categoryID) throws Exception {
        this.resultList = sqldata.getResultsInCategory(categoryID);
    }
    
    public void getResultsForMember(String memberID) throws Exception {
        this.resultList = sqldata.getResultsForMember(memberID);
    }
    
    public void updateCategoryList() throws Exception {
        this.categoryList = sqldata.getCategories();
    }
    
    public void deleteMember(int id) throws Exception{
        data.deleteMember(id);
    }
    
    public void updateMemberList() throws Exception{
        memberList = data.getMembers();
    }
    
    public void updateMemberList(String email) throws Exception{
        memberList = data.searchMailForMembers(email);
    }
    
    public void editMember(Member member) throws Exception{
        data.editMember(member);
    }
    
     public void createMember(Member member) throws Exception{
        data.createMember(member);
    }
     
     

}
