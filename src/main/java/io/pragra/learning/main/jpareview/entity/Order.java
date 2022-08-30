package io.pragra.learning.main.jpareview.entity;

import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name="TABLE_ORDER")
@XmlRootElement
@Data

public class Order {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy ="org.hibernate.id.UUIDGenerator"
    )
    private UUID id;
    @OneToOne(cascade = CascadeType.ALL)
    private User user;
    private String productName;
   // @Builder.Default()
    private Instant createDate = Instant.now();
   // @Builder.Default()
    private Instant updateDate = Instant.now();


}
