package service;

import model.Event;
import org.springframework.stereotype.Service;
import repository.EventRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Optional<Event> getEventById(Integer id) {
        return eventRepository.findById(id);
    }

    public Event saveOrUpdateEvent(Event event) {
        return eventRepository.save(event);
    }

    public void deleteEventById(Integer id) {
        eventRepository.deleteById(id);
    }
}
