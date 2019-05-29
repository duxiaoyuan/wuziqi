package com.wzq.flow.pojo;

import com.wzq.flow.pojo.collection.Pieces;
import lombok.Data;

import javax.persistence.*;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Date;

@Data
@Table(name="chess")
@Entity
public class Chess{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    private Date startTime;
    private Date endTime;

    private Integer b_user_id;
    private Integer w_user_id;
    private ArrayList<Pieces> step;

}
