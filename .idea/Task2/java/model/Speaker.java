package model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "speakers")
public class Speaker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private int presentationDuration;

    public Speaker(String name, int presentationDuration) {
        this.name = name;
        this.presentationDuration = presentationDuration;
    }
}
