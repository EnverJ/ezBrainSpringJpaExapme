package io.ezbrains.springbootjpaexaple;

import jakarta.persistence.*;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "EMPLOYEE_DATA") // (table name is optional, by default it is class name)
@NamedQuery(query = "Select e from Employee where e.age > :age order by e.name", name = "emp name and age asc")   // this query is frequently used.  C.45
@NamedQuery(query = "Select e from Employee order by e.name", name = "emp name asc")
public class Employee {

    @Id   // primary key
    @GeneratedValue(strategy = GenerationType.AUTO)    // GenerationType.SEQUENCE)
    private int id;
    //1) there are performance implications if  a string is used as a key
    //2) also wrapper types, char, byte , short, long  can be used as key
    //3) dont use long format for the id since the precision value needs to be descrete.
    //4) there are 4 different strategies which can be used for generation of the ID.
    @Column(name = "employee_name", unique = false)  // unique mean if the value is duplicated
    private String name;
    private int age;
    @Column(unique = true, length = 10, nullable = false, updatable = false)
    private String ssn;
    @Temporal(TemporalType.TIME)
    private Date dob;
    @Enumerated(EnumType.STRING)
    private EmployeeType type;
    @Transient// is not going to be saved
    private String debugString;

    @OneToOne(fetch = FetchType.LAZY)
    private AccessCard card;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.REMOVE)
    private List<PayStub> payStub = new ArrayList<>();

    @ManyToMany (fetch = FetchType.EAGER)
    @JoinTable(name = "EMAIL_GROUP_SUBSCRIPTIONS", joinColumns = @JoinColumn (name = "Employee_ID"),
    inverseJoinColumns = @JoinColumn (name = "SUBSCRIPTION_EMAIL_ID") )

    private List<EmailGroup> emailGroups = new ArrayList<>();
    public AccessCard getCard() {
        return card;
    }

    public void setCard(AccessCard card) {
        this.card = card;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", ssn='" + ssn + '\'' +
                ", dob=" + dob +
                ", type=" + type +
                ", debugString='" + debugString + '\'' +
                ", card=" + card +
                '}';
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Column(insertable = false)
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
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

    public EmployeeType getType() {
        return type;
    }


    public void setType(EmployeeType type) {
        this.type = type;
    }

    public List<PayStub> getPayStub() {
        return payStub;
    }

    public void setPayStub(List<PayStub> payStub) {
        this.payStub = payStub;
    }

    public List<EmailGroup> getEmailGroups() {
        return emailGroups;
    }

    public void setEmailGroups(List<EmailGroup> emailGroups) {
        this.emailGroups = emailGroups;
    }
    public  void addEmailSubscription(EmailGroup group) {
        this.emailGroups.add(group);
    }
}
