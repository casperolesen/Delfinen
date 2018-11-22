package data;

import java.util.List;
import logic.Discipline;
import logic.Member;
import logic.Payment;
import logic.Result;

/**
 *
 * @author Vics
 */
public interface DataAccessorInterface {

    /**
     *
     * @return a list of all members from the database
     * @throws Exception
     */
    public List<Member> getMembers() throws Exception;

    /**
     *
     * @param email to search for a member
     * @return a list of members with a specific email
     * @throws Exception
     */
    public List<Member> searchMailForMembers(String email) throws Exception;

    /**
     *
     * @param id to search for a member
     * @return a member with a specific ID
     * @throws Exception
     */
    public Member getMember(int id) throws Exception;

    /**
     *
     * @param member to save in the database
     * @param discs the disciplines a member is registered in
     * @throws Exception
     */
    public void createMember(Member member, boolean[] discs) throws Exception;

    /**
     *
     * @param member to edit from the database
     * @param discs the disciplines a member is registered in
     * @throws Exception
     */
    public void editMember(Member member, boolean[] discs) throws Exception;

    /**
     *
     * @param id for the member to delete
     * @throws Exception
     */
    public void deleteMember(int id) throws Exception;

    /**
     *
     * @param memberID for a member
     * @param disciplineID for a discipline
     * @param time for a result
     * @param comp a boolean in string format. True if the result was set in a competition
     * @param place where the competition was held. Write training if it was set at training
     * @throws Exception
     */
    public void createResult(int memberID, int disciplineID, String time, String comp, String place) throws Exception;

    /**
     *
     * @return a list of all results in the database
     * @throws Exception
     */
    public List<Result> getResults() throws Exception;

    /**
     *
     * @param id for the result to delete
     * @throws Exception
     */
    public void deleteResult(int id) throws Exception;

    /**
     *
     * @param categoryID to search for results in a specific category/discipline
     * @return the top 5 results in a specific discipline
     * @throws Exception
     */
    public List<Result> getResultsInDisciplines(int categoryID) throws Exception;

    /**
     *
     * @param memberID to show all results for a specific member
     * @return all results for a member
     * @throws Exception
     */
    public List<Result> getResultsForMember(String memberID) throws Exception;

    /**
     *
     * @return a list with all disciplines from the database
     * @throws Exception
     */
    public List<Discipline> getDisciplines() throws Exception;

    /**
     *
     * @return a list with all payments in the database
     * @throws Exception
     */
    public List<Payment> getPayments() throws Exception;

    /**
     *
     * @return a list of members not reg. in the current years payment list
     * @throws Exception
     */
    public List<Member> getMissingPayments() throws Exception;

    /**
     *
     * @param payment to save in the database
     * @throws Exception
     */
    public void createPayment(Payment payment) throws Exception;

    /**
     *
     * @param id on the payment to delete
     * @throws Exception
     */
    public void deletePayment(int id) throws Exception;

}
