package logic;

import java.time.LocalDate;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author caspe
 */
public class MemberTest {
    
    public MemberTest() {
    }

    /**
     * Test of getID method, of class Member.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        Member instance = null;
        int expResult = 0;
        int result = instance.getID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Member.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Member instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBirthday method, of class Member.
     */
    @Test
    public void testGetBirthday() {
        System.out.println("getBirthday");
        Member instance = null;
        LocalDate expResult = null;
        LocalDate result = instance.getBirthday();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmail method, of class Member.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        Member instance = null;
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isActive method, of class Member.
     */
    @Test
    public void testIsActive() {
        System.out.println("isActive");
        Member instance = null;
        boolean expResult = false;
        boolean result = instance.isActive();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isElite method, of class Member.
     */
    @Test
    public void testIsElite() {
        System.out.println("isElite");
        Member instance = null;
        boolean expResult = false;
        boolean result = instance.isElite();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
