package hu.voga.space.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by lofut on 2017. 06. 29..
 */
@Entity
@Getter
@Setter
@Table(name = "building")
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bld_id")
    private Long bldId;

    @Column(name = "bld_type")
    private String bldType;

    @ManyToOne
    @JoinColumn(name = "pl_id")
    private Planet planet;
}
