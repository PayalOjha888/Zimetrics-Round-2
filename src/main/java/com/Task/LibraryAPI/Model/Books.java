package com.Task.LibraryAPI.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "books")
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // Use Integer

    private String title;
    private String author;

    @Column(name = "released_year")
    @JsonProperty("year")
    private Integer year; // Use Integer to avoid the primitive "null" crash
}
