package com.jpa.project.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by IMC021 on 2017. 9. 26..
 */
@Entity(name = "T_USER")
@Table(
        uniqueConstraints = {
                @UniqueConstraint(name = "uid", columnNames = {"UID"})
        }
)
@Getter @Setter
@ToString
public class T_USER {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDX")
    public int idx;

    @Column(name = "UID", nullable = false, unique = true)
    public String uid;

    @Column(name = "UPASSWORD", nullable = false)
    public String upassword;

    @Column(name = "UNAME", nullable = true)
    public String uname;

    @Column(name = "USEYN", nullable = false, updatable = false)
    public int useyn;

    @Column(insertable = true, updatable = false,  nullable = true)
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date rdate;

    @Column
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date mdate;


}
