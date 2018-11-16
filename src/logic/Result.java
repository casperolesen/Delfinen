package logic;

import java.time.LocalDate;

/**
 *
 * @author caspe
 */
public class Result {
    private int id;
    private int id_member;
    private int id_category;
    
    private LocalDate data;
    
    private double time;
    
    private Boolean comp;
    private String place;

    public Result(int id, int id_member, int id_category, double time, Boolean comp, String place) {
        this.id = id;
        this.id_member = id_member;
        this.id_category = id_category;
        this.time = time;
        this.comp = comp;
        this.place = place;
    }

    public int getId() {
        return id;
    }

    public int getId_member() {
        return id_member;
    }

    public int getId_category() {
        return id_category;
    }

    public double getTime() {
        return time;
    }

    public Boolean getComp() {
        return comp;
    }

    public String getPlace() {
        return place;
    }
    
    
    
    
}
