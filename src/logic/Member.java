package logic;

import java.time.LocalDate;

public class Member {
    private int id;
    
    private String name;
    private LocalDate birthday;
    private String email;
    
    private boolean active;
    private boolean elite;
    
    
    public int getID() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public LocalDate getBirthday() {
        return birthday;
    }
    
    public String getEmail() {
        return email;
    }
    
    public boolean isActive() {
        return active;
    }
    
    public boolean isElite() {
        return elite;
    }
}
