package logic;

import java.time.LocalDate;

/**
 *
 * @author caspe
 */
public class Payment {
    private int id;
    private int memberID;
    private String paymentYear;
    private double amount;
    private String paymentDate;
    
    String memberName;

    public Payment(int id, int memberID, String paymentYear, double amount, String paymentDate) {
        this.id = id;
        this.memberID = memberID;
        this.paymentYear = paymentYear;
        this.amount = amount;
        this.paymentDate = paymentDate;
    }
    
    public Payment(int id, String memberName, String paymentYear, double amount, String paymentDate) {
        this.id = id;
        this.memberName = memberName;
        this.paymentYear = paymentYear;
        this.amount = amount;
        this.paymentDate = paymentDate;
    }

    public int getId() {
        return id;
    }

    public int getMemberID() {
        return memberID;
    }
    
    public String getMemberName() {
        return memberName;
    }

    public String getPaymentYear() {
        return paymentYear;
    }

    public double getAmount() {
        return amount;
    }

    public String getPaymentDate() {
        return paymentDate;
    }
    
    
}
