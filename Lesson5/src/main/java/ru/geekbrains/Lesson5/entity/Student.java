package ru.geekbrains.Lesson5.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@Table(name = "students", schema = "lesson5")
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "mark")
    private Double mark;

    public Student(String name, double mark) {
        this.name = name;
        this.mark = mark;
    }
}
