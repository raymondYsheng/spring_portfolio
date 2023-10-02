package com.nighthawk.spring_portfolio.mvc.Prime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data  // Annotations to simplify writing code (ie constructors, setters)
@NoArgsConstructor
@AllArgsConstructor
@Entity // Annotation to simplify creating an entity, which is a lightweight persistence domain object. Typically, an entity represents a table in a relational database, and each entity instance corresponds to a row in that table.
public class Prime {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique=true)
    private String joke;

    private int like;
    private int dislike;

    // starting jokes
    public static String[] init() {
        final String[] primeArray = {
        "98234403567",
        "56892406713",
        "72119843929",
        "13987456321",
        "64377215117",
        "36725894113",
        "43197286589",
        "51863724983",
        "25678391497",
        "79962184391",
        "92541673849",
        "38751269431",
        "61349728591",
        "47692518347",
        "84973162537",
        "54123689713",
        "19283746589",
        "75321894679",
        "98236147519",
        "34718926543",
        "62473519817",
        "89512476391",
        "46123987513",
        "71834962571",
        "53692714831"
        };
        return primeArray;
    }
}
