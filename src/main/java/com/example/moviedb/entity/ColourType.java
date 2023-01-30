package com.example.moviedb.entity;

import com.example.moviedb.entity.enums.ColourCodeType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "colour_type")
public class ColourType {

    @Id
    @Column(name = "colour_code",length = 1)
    @Enumerated(EnumType.STRING)
    private ColourCodeType colourCode;

    @Column(name="colour_name",length = 30)
    private String colourName;

    @OneToMany(mappedBy = "colourCode")
    private Set<Movie> movieSet;
}
