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
    
    
}
