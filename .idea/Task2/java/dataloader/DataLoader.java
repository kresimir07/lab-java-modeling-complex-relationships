package dataloader;

import model.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import service.ConferenceService;
import service.ExpositionService;

import java.time.LocalDate;
import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

    private final ConferenceService conferenceService;
    private final ExpositionService expositionService;

    public DataLoader(ConferenceService conferenceService, ExpositionService expositionService) {
        this.conferenceService = conferenceService;
        this.expositionService = expositionService;
    }

    @Override
    public void run(String... args) throws Exception {


        Guest guest1 = new Guest("John Doe", Status.ATTENDING);
        Guest guest2 = new Guest("Jane Smith", Status.NO_RESPONSE);


        Speaker speaker1 = new Speaker("Dr. Alice", 45);
        Speaker speaker2 = new Speaker("Prof. Bob", 30);


        Conference conference = new Conference(
                LocalDate.of(2024, 11, 10),
                8,
                "New York",
                "Tech Innovations Conference",
                Arrays.asList(speaker1, speaker2)
        );
        conference.setGuests(Arrays.asList(guest1, guest2));
        conferenceService.saveOrUpdateConference(conference);


        Exposition exposition = new Exposition(
                LocalDate.of(2024, 12, 5),
                5,
                "Los Angeles",
                "Art Expo 2024"
        );
        exposition.setGuests(Arrays.asList(guest1));
        expositionService.saveOrUpdateExposition(exposition);
    }
}
