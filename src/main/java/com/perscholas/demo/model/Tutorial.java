package com.perscholas.demo.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "tutorials")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Tutorial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @NonNull
    @Column(name = "title")
    String title;
    @NonNull
    @Column(name = "description")
    String description;
    @NonNull
    @Column(name = "published")
    boolean published;

    @Override
    public String toString() {
        return "Tutorial[" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", published=" + published +
                ']';
    }
}
