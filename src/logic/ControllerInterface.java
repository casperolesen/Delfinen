package logic;

/**
 *
 * @author Vics
 */
public interface ControllerInterface {

    /**
     *
     * @return antallet af både aktive og inaktive member's
     * @throws java.lang.Exception
     */
    public int getTotalNumberOfMembers() throws Exception;

    /**
     *
     * @return antallet af aktive member's
     * @throws java.lang.Exception
     */
    public int getTotalNumberOfActiveMembers() throws Exception;

    /**
     *
     * @return antallet af inaktive member's
     * @throws java.lang.Exception
     */
    public int getTotalNumberOfNotActiveMembers() throws Exception;

    /**
     *
     * @return checker om en String er en email. F.eks. string indeholder @ og
     * .dk
     * @throws java.lang.Exception
     */
    public boolean checkEmail(String email) throws Exception;
    
    /**
     *
     * @throws Exception
     */
    public void updateResultList() throws Exception;
    
    /**
     *
     * @param categoryID
     * @throws Exception
     */
    public void getResultsInCategory(int categoryID) throws Exception;
    
    /**
     *
     * @param memberID
     * @throws Exception
     */
    public void getResultsForMember(String memberID) throws Exception;
    
    /**
     *
     * @param id
     * @throws Exception
     */
    public void deleteResult(int id) throws Exception;
    
    /**
     *
     * @throws Exception
     */
    public void updateCategoryList() throws Exception;
    
    /**
     *
     * @param id
     * @throws Exception
     */
    public void deleteMember(int id) throws Exception;
    
    /**
     *
     * @throws Exception
     */
    public void updateMemberList() throws Exception;
    
    /**
     *
     * @param email
     * @throws Exception
     */
    public void updateMemberList(String email) throws Exception;
    
    /**
     *
     * @param member
     * @param discs
     * @throws Exception
     */
    public void editMember(Member member, boolean[] discs) throws Exception;
    
    /**
     *
     * @param member
     * @param discs
     * @throws Exception
     */
    public void createMember(Member member, boolean[] discs) throws Exception;
    
    /**
     *
     * @param member
     * @return
     * @throws NumberFormatException
     */
    public double getAmountToPay(Member member) throws NumberFormatException;
    
    /**
     *
     * @param memberID
     * @param disciplineID
     * @param time
     * @param comp
     * @param place
     * @throws Exception
     */
    public void createResult(int memberID, int disciplineID, String time, String comp, String place) throws Exception;
    
    /**
     *
     * @throws Exception
     */
    public void updatePaymentList() throws Exception;
    
    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    public Member getMember(int id) throws Exception;
    
    /**
     *
     * @param payment
     * @throws Exception
     */
    public void createPayment(Payment payment) throws Exception;
    
    /**
     *
     * @throws Exception
     */
    public void updateMissingPaymentList() throws Exception;
    
    /**
     *
     * @param id
     * @throws Exception
     */
    public void deletePayment(int id) throws Exception;

}
