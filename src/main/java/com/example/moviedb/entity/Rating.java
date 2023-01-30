package com.example.moviedb.entity;

import com.example.moviedb.entity.enums.RatingCodeType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "rating")
public class Rating {

    @Id
    @Column(name = "rating_code",length = 2,unique = true)
    @Enumerated(EnumType.STRING)
    private RatingCodeType ratingCodeType;

    @Column(name = "short_desc",length = 30)
    private String shortDesc;

    @Column(name = "long_desc", length = 100)
    private String longDesc;

    @OneToMany(mappedBy = "ratingCode")
    private Set<Movie> movieSet;

    public Rating(RatingCodeType ratingCodeType, String shortDesc, String longDesc) {
        this.ratingCodeType = ratingCodeType;
        this.shortDesc = shortDesc;
        this.longDesc = longDesc;
    }
}
