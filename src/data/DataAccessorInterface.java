/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.List;
import logic.Member;

/**
 *
 * @author Vics
 */
public interface DataAccessorInterface {
    public List<Member> getMembers() throws Exception;
    
    public List<Member> searchMailForMembers(String email) throws Exception;
    
    public Member getMember(int id) throws Exception;
    
    public void createMember(Member member) throws Exception;
    
    public void editMember(Member member) throws Exception;
    
    public void deleteMember(int id) throws Exception;
}
