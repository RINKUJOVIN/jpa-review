package io.pragra.learning.main.jpareview.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
//@Table(name="review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
   // @ManyToOne
   // @JoinColumn(name="user_id")
   // private User user;

    private Date  reviewDate;
    private int star;
    private String reviewText;
}
