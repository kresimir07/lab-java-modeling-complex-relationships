package model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "expositions")
public class Exposition extends Event {

    public Exposition(LocalDate date, int duration, String location, String title) {
        super(date, duration, location, title);
    }
}
