package logic;

import java.util.List;

/**
 *
 * @author caspe
 */
public class Discipline {
    int id;
    String name;
    List<Member> memberlist = null;

    public Discipline(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Member> getMemberlist() {
        return memberlist;
    }

    public void setMemberlist(List<Member> memberlist) {
        this.memberlist = memberlist;
    }
    
    
    
    
}
