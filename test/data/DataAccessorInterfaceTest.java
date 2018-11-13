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
        //List<Member> expResult = null;
        List<Member> result = instance.getMembers();
        assertNotNull(result); // tester at listen med Member ikke er tom
    }

    /**
     * Test of searchMailForMembers method, of class DataAccessorInterface.
     */
    @Test
    public void testSearchMailForMembers() throws Exception {
        System.out.println("searchMailForMembers");
        String email = "";
        DataAccessorInterface instance = new DataAccessorFile();
        List<Member> expResult = null;
        List<Member> result = instance.searchMailForMembers(email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMember method, of class DataAccessorInterface.
     */
    @Test
    public void testGetMember() throws Exception {
        System.out.println("getMember");
        int id = 3;
        DataAccessorInterface instance = new DataAccessorFile();
        Member expResult = new Member(3, "Casper Kruse Olesen", "c@c.dk", LocalDate.parse("1990-03-27"), true, true);
        Member result = instance.getMember(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of createMember method, of class DataAccessorInterface.
     */
    @Test
    public void testCreateMember() throws Exception {
        System.out.println("createMember");
        Member member = null;
        DataAccessorInterface instance = new DataAccessorInterfaceImpl();
        instance.createMember(member);
        // TODO review the generated test code and remove the default call to fail.
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
