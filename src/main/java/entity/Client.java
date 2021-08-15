package entity;

import java.sql.Date;

public class Client {
    private Long iin;
    private String firstname;
    private String lastname;
    private String fathername;
    private String phone;
    private Date birthday;
    private String sex;
    private Long documentNumber;
    private String departmentGiven;
    private Date givenDate;
    private Date untilDate;
    private Long salary;
    private Long expenditure;

    public Long getIin() {
        return iin;
    }

    public void setIin(Long iin) {
        this.iin = iin;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFathername() {
        return fathername;
    }

    public void setFathername(String fathername) {
        this.fathername = fathername;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Long getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(Long documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getDepartmentGiven() {
        return departmentGiven;
    }

    public void setDepartmentGiven(String departmentGiven) {
        this.departmentGiven = departmentGiven;
    }

    public Date getGivenDate() {
        return givenDate;
    }

    public void setGivenDate(Date givenDate) {
        this.givenDate = givenDate;
    }

    public Date getUntilDate() {
        return untilDate;
    }

    public void setUntilDate(Date untilDate) {
        this.untilDate = untilDate;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public Long getExpenditure() {
        return expenditure;
    }

    public void setExpenditure(Long expenditure) {
        this.expenditure = expenditure;
    }

    @Override
    public String toString() {
        return "Client{" +
                "iin=" + iin +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", fathername='" + fathername + '\'' +
                ", phone='" + phone + '\'' +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                ", documentNumber=" + documentNumber +
                ", departmentGiven='" + departmentGiven + '\'' +
                ", givenDate=" + givenDate +
                ", untilDate=" + untilDate +
                ", salary=" + salary +
                ", expenditure=" + expenditure +
                '}';
    }
}
