package com.jpa.project.model;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.AnyMetaDef;

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

    @Column(name = "title", nullable = true)
    private String title;

    @Column(name = "memo1", nullable = false)
    private String memo1;

    @Column(name = "memo2", nullable = false)
    private String memo2;

    @Column(insertable = false, updatable = false,  nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date rdate;

    private String name;

    @PostLoad
    public void concatTitleAndMemo(){
        this.name = "";
        if(StringUtils.isNotEmpty(this.title)){
            this.name = this.title+"   ";
        }
        this.name += this.memo1;

        if(StringUtils.isNotEmpty(this.memo2)){
            this.name += "   "+this.memo2;
        }
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getRdate() {
        return rdate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRdate(Date rdate) {
        this.rdate = rdate;
    }

    public String getMemo1() {
        return memo1;
    }

    public void setMemo1(String memo1) {
        this.memo1 = memo1;
    }

    public String getMemo2() {
        return memo2;
    }

    public void setMemo2(String memo2) {
        this.memo2 = memo2;
    }

    @Override
    public String toString() {
        return "T_SEARCH{" +
                "id=" + id +
                ", memo1='" + memo1 + '\'' +
                ", title='" + title + '\'' +
                ", rdate=" + rdate +
                ", name='" + name + '\'' +
                '}';
    }
}
