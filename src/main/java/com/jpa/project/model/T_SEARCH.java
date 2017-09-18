package com.jpa.project.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by IMC021 on 2017. 9. 6..
 */
@Entity
public class T_SEARCH {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "memo", nullable = false)
    private String memo;

    @Column(name = "subject", nullable = true)
    private String subject;

    @Column(insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date rdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Date getRdate() {
        return rdate;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setRdate(Date rdate) {
        this.rdate = rdate;
    }

    @Override
    public String toString() {
        return "T_SEARCH{" +
                "id=" + id +
                ", memo='" + memo + '\'' +
                ", rdate=" + rdate +
                '}';
    }
}
