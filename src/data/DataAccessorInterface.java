/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.List;
import logic.Discipline;
import logic.Member;
import logic.Result;

/**
 *
 * @author Vics
 */
public interface DataAccessorInterface {
    public List<Member> getMembers() throws Exception;
    
    public List<Member> searchMailForMembers(String email) throws Exception;
    
    public Member getMember(int id) throws Exception;
    
    public void createMember(Member member, boolean[] discs) throws Exception;
    
    public void editMember(Member member, boolean[] discs) throws Exception;
    
    public void deleteMember(int id) throws Exception;
    
    
    //public void createResult() throws Exception;
    
    public List<Result> getResults() throws Exception;
    
    public void deleteResult(int id) throws Exception;
    
    public List<Result> getResultsInDisciplines(int categoryID) throws Exception;
    
    public List<Result> getResultsForMember(String memberID) throws Exception;
    
    public List<Discipline> getDisciplines() throws Exception;
    
    
}
