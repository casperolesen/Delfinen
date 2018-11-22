package logic;

import java.time.LocalDate;
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
        String email = "testtest.dk";
        boolean expResult = false;
        boolean result = logic.checkEmail(email);
        assertEquals(expResult, result);
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
        int id = 0; // sletter et resultat, som ikke findes - og får ingen Exception - VIRKER FORKERT
        logic.deleteResult(id);
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
        Member member = logic.getMember(1);
        boolean[] discs = {true, true, true, true};
        logic.editMember(member, discs);
    }

    /**
     * Test of createMember method, of class ControllerInterface.
     */
    @Test
    public void testCreateMember() throws Exception {
        System.out.println("createMember");
        //public Member(int id, String name, String email, LocalDate date, boolean active, boolean elite)
        Member member = new Member(0, "Tester T. Testersen", "test@mail.dk", LocalDate.parse("1900-01-01"), true, true);
        boolean[] discs = {true, true, true, true};
        logic.createMember(member, discs);

    }

    /**
     * Test of getAmountToPay method, of class ControllerInterface.
     */
    @Test
    public void testGetAmountToPay() {
        System.out.println("getAmountToPay");
        Member member = new Member(0, "Tester T. Testersen", "test@mail.dk", LocalDate.parse("1900-01-01"), true, true);
        double expResult = 1200.0;
        double result = logic.getAmountToPay(member);
        assertEquals(expResult, result, 0.05);
    }

    /**
     * Test of createResult method, of class ControllerInterface.
     */
    @Test
    public void testCreateResult() throws Exception {
        System.out.println("createResult");
        int memberID = 1;
        int disciplineID = 4;
        String time = "400";
        String comp = "true";
        String place = "Træning Test";
        logic.createResult(memberID, disciplineID, time, comp, place);
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
    }

    /**
     * Test of createPayment method, of class ControllerInterface.
     */
    @Test
    public void testCreatePayment() throws Exception {
        System.out.println("createPayment");
        Payment payment = new Payment(0, 1, "1900", 0.0, "1900-01-01");
        logic.createPayment(payment);
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
    }

}
