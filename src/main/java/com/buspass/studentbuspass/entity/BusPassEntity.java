package com.buspass.studentbuspass.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BusPassEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String passNumber;

    private String busRoute;

    private String boardingPoint;

    private String destination;

    private String validFrom;

    private String validUntil;

    private String status;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private StudentEntity student;
}