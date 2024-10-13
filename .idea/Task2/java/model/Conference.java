package model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "conferences")
public class Conference extends Event {


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "conference_id")
    private List<Speaker> speakers;

    public Conference(LocalDate date, int duration, String location, String title, List<Speaker> speakers) {
        super(date, duration, location, title);
        this.speakers = speakers;
    }
}
