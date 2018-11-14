package data;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.Member;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author caspe
 */
public class DataAccessorInterfaceTest {

    DataAccessorInterface instance = null;
    DataAccessorFile dataFile = new DataAccessorFile();

    public DataAccessorInterfaceTest() {
        instance = new DataAccessorFile(); // henter data via File
    }

    /**
     * Test of getMembers method, of class DataAccessorFile
     */
    @Test
    public void testGetMembers() throws Exception {
        System.out.println("getMembers");
        Boolean expResult = false;
        Boolean result = instance.getMembers().isEmpty();
        //assertNotNull(instance.getMembers());
        assertEquals(expResult, result); // tester at listen ikke er tom
    }

    /**
     * Test of searchMailForMembers method, of class DataAccessorFile.
     */
    @Test
    public void testSearchMailForMembers() throws Exception {
        System.out.println("searchMailForMembers");
        String email = "c@c.dk";
        int expResult = 3; // id
        int result = instance.searchMailForMembers(email).get(0).getID(); // id
        assertEquals(expResult, result); // tester pt. kun på det første resultat i listen
    }

    /**
     * Test of getMember method, of class DataAccessorFile.
     */
    @Test
    public void testGetMember() throws Exception {
        System.out.println("getMember");
        int id = 1;
        String expResult = "Aaa AaaFile";
        String result = instance.getMember(id).getName();
        assertEquals(expResult, result); // Tester at navnet på Member med id 3 hedder Casper Kruse Olesen
    }

    /**
     * Test of createMember method, of class DataAccessorFile.
     */
    @Test
    public void testCreateMember() throws Exception {
        System.out.println("createMember");
        try {
            Member newMember = new Member("Oprettet via Test", "cko@cko.dk", LocalDate.parse("1900-01-28"), true, true);
            instance.createMember(newMember); // gemmer nyt test member i filen
        } catch (Exception ex) {
            Logger.getLogger(DataAccessorInterfaceTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String expResult = "Oprettet via Test";
        String result = instance.searchMailForMembers("cko@cko.dk").get(0).getName();       
        assertEquals(expResult, result); // tester på navnet
    }

    /**
     * Test of editMember method, of class DataAccessorFile.
     */
    @Before
    public void beforeTestEditMember() {
        try {
            Member member = instance.getMember(3);
            member.setName("Nyt navn fra Test");
            instance.editMember(member);
        } catch (Exception ex) {
            Logger.getLogger(DataAccessorInterfaceTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testEditMember() throws Exception {
        System.out.println("editMember");
        Member member = instance.getMember(3);
        String expResult = "Nyt navn fra Test";
        String result = member.getName();

        assertEquals(expResult, result); // tester om Member med id 3 har fået ændret sit navn fra @Before
    }

    /**
     * Test of deleteMember method, of class DataAccessorFile.
     */
    
    @Before
    public void beforeTestDeleteMember() {
        try {
            Member member = instance.searchMailForMembers("cko@cko.dk").get(0);
            int member_id = member.getID();
            instance.deleteMember(member_id);
        } catch (Exception ex) {
            Logger.getLogger(DataAccessorInterfaceTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void testDeleteMember() throws Exception {
        System.out.println("deleteMember");
        
        int expResult = 0;
        int result = instance.searchMailForMembers("cko@cko.dk").size(); // antal members med mail cko@cko.dk
        
        assertEquals(expResult, result);
    }
    
//    @Test
//    public void testAppendLine() {
//        String outFilename = "crashData.txt";
//        
//        
//        for (int i = 1; i <= 10000; i++) {
//            try {
//                String output = i + "; " + "Member " + i + "; " + "test@mail.dk; " + "1900-01-20; " + "true; " + "true; ";
//                dataFile.appendLine(outFilename, output);
//            } catch (IOException ex) {
//                Logger.getLogger(DataAccessorInterfaceTest.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//    }

}
