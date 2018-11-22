package logic;

/**
 *
 * @author Vics
 */
public interface ControllerInterface {

    /**
     *
     * @return antallet af både aktive og inaktive member's
     * @throws java.lang.Exception if failed
     */
    public int getTotalNumberOfMembers() throws Exception;

    /**
     *
     * @return antallet af aktive member's
     * @throws java.lang.Exception if failed
     */
    public int getTotalNumberOfActiveMembers() throws Exception;

    /**
     *
     * @return antallet af inaktive member's
     * @throws java.lang.Exception if failed
     */
    public int getTotalNumberOfNotActiveMembers() throws Exception;

    /**
     *
     * @param email to validate
     * @return checker om en String er en email. F.eks. string indeholder @ og
     * .dk
     * @throws java.lang.Exception if failed
     */
    public boolean checkEmail(String email) throws Exception;
    
    /**
     *
     * @throws Exception if failed
     */
    public void updateResultList() throws Exception;
    
    /**
     *
     * @param categoryID for the results
     * @throws Exception if failed
     */
    public void getResultsInCategory(int categoryID) throws Exception;
    
    /**
     *
     * @param memberID to get all results for a member
     * @throws Exception if failed
     */
    public void getResultsForMember(String memberID) throws Exception;
    
    /**
     *
     * @param id for the result to delete in the database
     * @throws Exception if failed
     */
    public void deleteResult(int id) throws Exception;
    
    /**
     *
     * @throws Exception if failed
     */
    public void updateCategoryList() throws Exception;
    
    /**
     *
     * @param id on the member to delete in the database
     * @throws Exception if failed
     */
    public void deleteMember(int id) throws Exception;
    
    /**
     *
     * @throws Exception if failed
     */
    public void updateMemberList() throws Exception;
    
    /**
     *
     * @param email for a specific member
     * @throws Exception if failed
     */
    public void updateMemberList(String email) throws Exception;
    
    /**
     *
     * @param member date to update in the database
     * @param discs a members reg. discipline to update in the database
     * @throws Exception if failed
     */
    public void editMember(Member member, boolean[] discs) throws Exception;
    
    /**
     *
     * @param member to save in the database
     * @param discs a members discipline to save in the database
     * @throws Exception if failed
     */
    public void createMember(Member member, boolean[] discs) throws Exception;
    
    /**
     *
     * @param member to calculate the price for
     * @return the amount to pay for the member
     * @throws NumberFormatException if failed
     */
    public double getAmountToPay(Member member) throws NumberFormatException;
    
    /**
     *
     * @param memberID the memberID for the result
     * @param disciplineID the discipline id for the result
     * @param time the time for the result
     * @param comp true or false, if the result is set at a competition or not
     * @param place the name of the place. Training a a competition name.
     * @throws Exception if failed
     */
    public void createResult(int memberID, int disciplineID, String time, String comp, String place) throws Exception;
    
    /**
     *
     * @throws Exception if failed
     */
    public void updatePaymentList() throws Exception;
    
    /**
     *
     * @param id for the member
     * @return a specific member
     * @throws Exception if failed
     */
    public Member getMember(int id) throws Exception;
    
    /**
     *
     * @param payment to save in database
     * @throws Exception if failed
     */
    public void createPayment(Payment payment) throws Exception;
    
    /**
     *
     * @throws Exception if failed
     */
    public void updateMissingPaymentList() throws Exception;
    
    /**
     *
     * @param id on the payment to delete
     * @throws Exception if failed
     */
    public void deletePayment(int id) throws Exception;

}
