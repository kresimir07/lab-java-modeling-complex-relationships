package model;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.ZonedDateTime;

@Data
@Table(name = "members")
@NoArgsConstructor
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer memberId;
    private String memberName;

    @Enumerated(EnumType.STRING)

    private Status status;

    private ZonedDateTime dateOfBirth;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "chapterId", referencedColumnName = "ID")
    private Chapter chapter;

    public Member(String memberName, ZonedDateTime dateOfBirth, Status status) {
        this.memberName = memberName;
        this.dateOfBirth = dateOfBirth;
        this.status = status;

    }
}

