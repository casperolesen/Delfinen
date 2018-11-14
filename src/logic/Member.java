package logic;

import java.time.LocalDate;

public class Member {
    private int id;
    
    private String name;
    private String email;
    private LocalDate birthday;
    
    private boolean active;
    private boolean elite;
    
    private boolean butterfly;
    private boolean crawl;
    private boolean rygcrawl;
    private boolean brystsvømning;
    
    
    public Member(int id, String name, String email, LocalDate date, boolean active, boolean elite, boolean[] categories){
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthday = date;
        this.active = active;
        this.elite = elite;
        
        this.butterfly = categories[0];
        this.crawl = categories[1];
        this.rygcrawl = categories[2];
        this.brystsvømning = categories[3];
    }
    
    public int getID() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
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
    
    public boolean getButterfly() {
        return butterfly;
    }
    
    public boolean getCrawl() {
        return crawl;
    }
    
    public boolean getRygcrawl() {
        return rygcrawl;
    }
    
    public boolean getBryst() {
        return brystsvømning;
    }
    
    public String toFile() {
        return name+";"+email+";"+birthday+";"+active+";"+elite;
    }
}
