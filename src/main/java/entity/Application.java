package entity;

import java.sql.Date;

public class Application {
    private Long iin;
    private Date date;
    private Long applicationNumber;
    private Long totalMoney;
    private Integer term;
    private String status;

    public Long getIin() {
        return iin;
    }

    public void setIin(Long iin) {
        this.iin = iin;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getApplicationNumber() {
        return applicationNumber;
    }

    public void setApplicationNumber(Long applicationNumber) {
        this.applicationNumber = applicationNumber;
    }

    public Long getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Long totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Application{" +
                "iin='" + iin + '\'' +
                ", date=" + date +
                ", applicationNumber=" + applicationNumber +
                ", totalMoney=" + totalMoney +
                ", term=" + term +
                ", status='" + status + '\'' +
                '}';
    }
}
