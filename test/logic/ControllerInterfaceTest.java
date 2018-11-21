package logic;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author caspe
 */
public class ControllerInterfaceTest {

    Controller logic = null;

    public ControllerInterfaceTest() {
        logic = new Controller();
    }

    /**
     * Test of getTotalNumberOfMembers method, of class ControllerInterface.
     */
    @Test
    public void testGetTotalNumberOfMembers() throws Exception {
        System.out.println("getTotalNumberOfMembers");
        logic.updateMemberList();
        int number = logic.getTotalNumberOfMembers();
        assertNotNull(number);
        //assertEquals(expResult, result);
    }

    /**
     * Test of getTotalNumberOfActiveMembers method, of class
     * ControllerInterface.
     */
    @Test
    public void testGetTotalNumberOfActiveMembers() throws Exception {
        System.out.println("getTotalNumberOfActiveMembers");
        logic.updateMemberList();
        int number = logic.getTotalNumberOfActiveMembers();
        assertNotNull(number);
    }

    /**
     * Test of getTotalNumberOfNotActiveMembers method, of class
     * ControllerInterface.
     */
    @Test
    public void testGetTotalNumberOfNotActiveMembers() throws Exception {
        System.out.println("getTotalNumberOfNotActiveMembers");
        logic.updateMemberList();
        int number = logic.getTotalNumberOfNotActiveMembers();
        assertNotNull(number);
    }

    /**
     * Test of checkEmail method, of class ControllerInterface.
     */
    @Test
    public void testCheckEmail() throws Exception {
        System.out.println("checkEmail");
        String email = "";
        boolean expResult = false;
        boolean result = logic.checkEmail(email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateResultList method, of class ControllerInterface.
     */
    @Test
    public void testUpdateResultList() throws Exception {
        System.out.println("updateResultList");
        logic.updateResultList();
        assertNotNull(logic.resultList.get(0));
    }

    /**
     * Test of getResultsInCategory method, of class ControllerInterface.
     */
    @Test
    public void testGetResultsInCategory() throws Exception {
        System.out.println("getResultsInCategory");
        int categoryID = 1;
        logic.getResultsInCategory(categoryID);
        assertNotNull(logic.resultList.get(0));
    }

    /**
     * Test of getResultsForMember method, of class ControllerInterface.
     */
    @Test
    public void testGetResultsForMember() throws Exception {
        System.out.println("getResultsForMember");
        String memberID = "1";
        logic.getResultsForMember(memberID);
        assertNotNull(logic.resultList.get(0));
    }

    /**
     * Test of deleteResult method, of class ControllerInterface.
     */
    @Test
    public void testDeleteResult() throws Exception {
        System.out.println("deleteResult");
        int id = 0;
        logic.deleteResult(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateCategoryList method, of class ControllerInterface.
     */
    @Test
    public void testUpdateCategoryList() throws Exception {
        System.out.println("updateCategoryList");
        logic.updateCategoryList();
        assertNotNull(logic.categoryList.get(0));
    }

    /**
     * Test of deleteMember method, of class ControllerInterface.
     */
    @Test
    public void testDeleteMember() throws Exception {
        System.out.println("deleteMember");
        int id = 0;
        logic.deleteMember(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateMemberList method, of class ControllerInterface.
     */
    @Test
    public void testUpdateMemberList_0args() throws Exception {
        System.out.println("updateMemberList");
        logic.updateMemberList();
        assertNotNull(logic.memberList.get(0));
    }

    /**
     * Test of updateMemberList method, of class ControllerInterface.
     */
    @Test
    public void testUpdateMemberList_String() throws Exception {
        System.out.println("updateMemberList");
        String email = "a@a.dk";
        logic.updateMemberList(email);
        assertNotNull(logic.memberList.get(0));
    }

    /**
     * Test of editMember method, of class ControllerInterface.
     */
    @Test
    public void testEditMember() throws Exception {
        System.out.println("editMember");
        Member member = null;
        boolean[] discs = null;
        logic.editMember(member, discs);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createMember method, of class ControllerInterface.
     */
    @Test
    public void testCreateMember() throws Exception {
        System.out.println("createMember");
        Member member = null;
        boolean[] discs = null;
        logic.createMember(member, discs);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAmountToPay method, of class ControllerInterface.
     */
    @Test
    public void testGetAmountToPay() {
        System.out.println("getAmountToPay");
        Member member = null;
        double expResult = 0.0;
        double result = logic.getAmountToPay(member);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createResult method, of class ControllerInterface.
     */
    @Test
    public void testCreateResult() throws Exception {
        System.out.println("createResult");
        int memberID = 0;
        int disciplineID = 0;
        String time = "";
        String comp = "";
        String place = "";
        logic.createResult(memberID, disciplineID, time, comp, place);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updatePaymentList method, of class ControllerInterface.
     */
    @Test
    public void testUpdatePaymentList() throws Exception {
        System.out.println("updatePaymentList");
        logic.updatePaymentList();
        assertNotNull(logic.paymentList.get(0));
    }

    /**
     * Test of getMember method, of class ControllerInterface.
     */
    @Test
    public void testGetMember() throws Exception {
        System.out.println("getMember");
        int id = 0;
        Member expResult = null;
        Member result = logic.getMember(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createPayment method, of class ControllerInterface.
     */
    @Test
    public void testCreatePayment() throws Exception {
        System.out.println("createPayment");
        Payment payment = null;
        logic.createPayment(payment);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateMissingPaymentList method, of class ControllerInterface.
     */
    @Test
    public void testUpdateMissingPaymentList() throws Exception {
        System.out.println("updateMissingPaymentList");
        logic.updateMissingPaymentList();
        assertNotNull(logic.missingPaymentList.get(0));
    }

    /**
     * Test of deletePayment method, of class ControllerInterface.
     */
    @Test
    public void testDeletePayment() throws Exception {
        System.out.println("deletePayment");
        int id = 0;
        logic.deletePayment(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
