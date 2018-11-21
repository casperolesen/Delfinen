/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
     * @return @throws Exception
     */
    public List<Member> getMembers() throws Exception;

    /**
     *
     * @param email
     * @return
     * @throws Exception
     */
    public List<Member> searchMailForMembers(String email) throws Exception;

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    public Member getMember(int id) throws Exception;

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
     * @param discs
     * @throws Exception
     */
    public void editMember(Member member, boolean[] discs) throws Exception;

    /**
     *
     * @param id
     * @throws Exception
     */
    public void deleteMember(int id) throws Exception;

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
     * @return @throws Exception
     */
    public List<Result> getResults() throws Exception;

    /**
     *
     * @param id
     * @throws Exception
     */
    public void deleteResult(int id) throws Exception;

    /**
     *
     * @param categoryID
     * @return
     * @throws Exception
     */
    public List<Result> getResultsInDisciplines(int categoryID) throws Exception;

    /**
     *
     * @param memberID
     * @return
     * @throws Exception
     */
    public List<Result> getResultsForMember(String memberID) throws Exception;

    /**
     *
     * @return @throws Exception
     */
    public List<Discipline> getDisciplines() throws Exception;

    /**
     *
     * @return @throws Exception
     */
    public List<Payment> getPayments() throws Exception;

    /**
     *
     * @return @throws Exception
     */
    public List<Member> getMissingPayments() throws Exception;

    /**
     *
     * @param payment
     * @throws Exception
     */
    public void createPayment(Payment payment) throws Exception;

    /**
     *
     * @param id
     * @throws Exception
     */
    public void deletePayment(int id) throws Exception;

}
