package com.xworkz.inventory.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name="dairy_info")
@Getter
@Setter
@ToString

public class DairyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="date")
    private LocalDate date;

    @Column(name="dairy_name")
    private String dairyName;

    @Column(name="owner_name")
    private String ownerName;

    @Column(name="location")
    private String location;

    @Column(name="phone_number")
    private String phoneNumber;
}
