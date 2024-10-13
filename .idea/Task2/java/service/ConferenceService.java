package service;

import model.Conference;
import org.springframework.stereotype.Service;
import repository.ConferenceRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ConferenceService {

    private final ConferenceRepository conferenceRepository;

    public ConferenceService(ConferenceRepository conferenceRepository) {
        this.conferenceRepository = conferenceRepository;
    }

    public List<Conference> getAllConferences() {
        return conferenceRepository.findAll();
    }

    public Optional<Conference> getConferenceById(Integer id) {
        return conferenceRepository.findById(id);
    }

    public Conference saveOrUpdateConference(Conference conference) {
        return conferenceRepository.save(conference);
    }

    public void deleteConferenceById(Integer id) {
        conferenceRepository.deleteById(id);
    }
}
