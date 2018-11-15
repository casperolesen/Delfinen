package logic;

import data.DataAccessorFile;
import data.DataAccessorInterface;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author caspe
 */
public class Controller implements ControllerInterface {

    private DataAccessorInterface data = new DataAccessorFile();
    public List<Member> memberList = null;

    public String getNumberFact(int number) throws Exception {
        URL url = new URL("http://numbersapi.com/" + number);
        InputStream is = url.openStream();
        BufferedReader ind = new BufferedReader(new InputStreamReader(is));
        
        String result = ind.readLine();
        
        return result;
    }

    @Override
    public int getTotalNumberOfMembers() throws Exception {
        return data.getMembers().size();
    }

    @Override
    public int getTotalNumberOfActiveMembers() throws Exception {

        int numberOfActiveMembers = 0;
        for (Member member : data.getMembers()) {
            if (member.isActive()) {
                numberOfActiveMembers++;
            }
        }
        return numberOfActiveMembers;
    }

    @Override
    public int getTotalNumberOfNotActiveMembers() throws Exception {
        
        int numberOfNotActiveMembers = 0;
        for (Member member : data.getMembers()) {
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

}
