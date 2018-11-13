package logic;

import java.time.LocalDate;

public class Member {
    private int id;
    
    private String name;
    private String email;
    private LocalDate birthday;
    
    private boolean active;
    private boolean elite;
    
    public Member(int id, String name, String email, LocalDate date, boolean active, boolean elite){
        this.name = name;
        this.email = email;
        this.birthday = date;
        this.active = active;
        this.elite = elite;
    }
    
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
    
    public String toFile() {
        return name+"||"+email+"||"+birthday+"||"+active+"||"+elite;
    }
}
