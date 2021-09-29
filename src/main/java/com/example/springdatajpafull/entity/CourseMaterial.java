package com.example.springdatajpafull.entity;

import lombok.*;
import lombok.ToString.Exclude;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseMaterial {

    @Id
    @SequenceGenerator(
            name = "course_material_sequence",
            sequenceName = "course_material_sequence",
            allocationSize = 1

    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_material_sequence"
    )
    @Exclude
    private Long CourseMaterialId;
    private String url;

    /**Cascade heeft te maken met informatie overdracht.
    Nog precies uitzoeken hoe dit werkt, maar vgm heeft dat ermee te maken dat een CourseMaterial niet kan bestaan zonder Course,
    Dus als je een course delete, delete je de material met de course mee.
    Fetch heeft te maken met hoe je informatie wilt ophalen. Bij bijv. FetchType.LAZY zou in dit geval de course_id niet worden meegeven als je die informatie ophaalt.
    Dit heeft puur te maken met de return vanuit de GetMethode.
     */

    //https://stackoverflow.com/questions/2990799/difference-between-fetchtype-lazy-and-eager-in-java-persistence-api */

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "course_id",
            referencedColumnName = "courseId"
    )
    @Exclude
    private Course course;

}
