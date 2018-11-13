package data;

import java.time.LocalDate;
import java.util.List;
import logic.Member;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author caspe
 */
public class DataAccessorInterfaceTest {
    
    public DataAccessorInterfaceTest() {
    }

    /**
     * Test of getMembers method, of class DataAccessorInterface.
     */
    @Test
    public void testGetMembers() throws Exception {
        System.out.println("getMembers");
        DataAccessorInterface instance = new DataAccessorFile();
        //Boolean expResult = true;
        //Boolean result = instance.getMembers().isEmpty();
        assertNotNull(instance.getMembers());
        //assertEquals(expResult, result); // tester at listen ikke er tom
    }

    /**
     * Test of searchMailForMembers method, of class DataAccessorInterface.
     */
    @Test
    public void testSearchMailForMembers() throws Exception {
        System.out.println("searchMailForMembers");
        String email = "c@c.dk";
        DataAccessorInterface instance = new DataAccessorFile();
        int expResult = 3; // id
        int result = instance.searchMailForMembers(email).get(0).getID(); // id
        
//        Boolean expResult = false;
//        Boolean result = instance.searchMailForMembers(email).isEmpty();
        assertEquals(expResult, result); // tester pt. kun på det første resultat i listen
    }

    /**
     * Test of getMember method, of class DataAccessorInterface.
     */
    @Test
    public void testGetMember() throws Exception {
        System.out.println("getMember");
        int id = 3;
        DataAccessorInterface instance = new DataAccessorFile();
        String expResult = "Casper Kruse Olesen";
        String result = instance.getMember(id).getName();
        assertEquals(expResult, result); // Tester at navnet på Member med id 3 hedder Casper Kruse Olesen
    }

    /**
     * Test of createMember method, of class DataAccessorInterface.
     */
    @Test
    public void testCreateMember() throws Exception {
//        System.out.println("createMember");
//        Member newMember = new Member("Oprettet via Test", "test@test.dk", LocalDate.parse("1900-01-28"), true, true);
//        DataAccessorInterface instance = new DataAccessorFile();
//        instance.createMember(newMember); // gemmer nyt test member i filen
//        
//        DataAccessorInterface instanceTwo = new DataAccessorFile();
//        
//        String expResult = "Oprettet via Test";
//        String result = instanceTwo.searchMailForMembers("test@test.dk").get(0).getName();
//        
//        assertEquals(expResult, result); // tester på navnet
        fail("The test case is a prototype.");
    }

    /**
     * Test of editMember method, of class DataAccessorInterface.
     */
    @Test
    public void testEditMember() throws Exception {
        System.out.println("editMember");
        Member member = null;
        DataAccessorInterface instance = new DataAccessorInterfaceImpl();
        instance.editMember(member);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteMember method, of class DataAccessorInterface.
     */
    @Test
    public void testDeleteMember() throws Exception {
        System.out.println("deleteMember");
        Member member = null;
        DataAccessorInterface instance = new DataAccessorInterfaceImpl();
        instance.deleteMember(member);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class DataAccessorInterfaceImpl implements DataAccessorInterface {

        public List<Member> getMembers() throws Exception {
            return null;
        }

        public List<Member> searchMailForMembers(String email) throws Exception {
            return null;
        }

        public Member getMember(int id) throws Exception {
            return null;
        }

        public void createMember(Member member) throws Exception {
        }

        public void editMember(Member member) throws Exception {
        }

        public void deleteMember(Member member) throws Exception {
        }
    }
    
}
