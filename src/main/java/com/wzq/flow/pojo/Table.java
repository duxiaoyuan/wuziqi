package com.wzq.flow.pojo;

import lombok.Data;

import javax.persistence.*;

@Data
@javax.persistence.Table(name="table")
@Entity
public class Table {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    private Integer left_user_id;
    private Integer right_user_id;
    private boolean l_start;
    private boolean r_start;

}
