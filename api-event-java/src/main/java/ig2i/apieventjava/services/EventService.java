package ig2i.apieventjava.services;

import ig2i.apieventjava.dto.Event;
import ig2i.apieventjava.dto.NewEvent;
import ig2i.apieventjava.dto.Organizer;
import ig2i.apieventjava.dto.Participant;
import ig2i.apieventjava.entities.AddressEntity;
import ig2i.apieventjava.entities.EventEntity;
import ig2i.apieventjava.mappers.EventMapper;
import ig2i.apieventjava.repositories.AddressRepository;
import ig2i.apieventjava.repositories.EventRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.UUID;

@Service
@AllArgsConstructor
public class EventService {
    private final EventRepository eventRepository;
    private final EventMapper eventMapper;
    private final AddressRepository addressRepository;

    public Mono<Void> addOrganizer(UUID eventId, Organizer organizer) {
        return null;
//        // Add organizer to event
//        String organizerId = organizer.getUserId();
//
//        return eventRepository.findById(eventId)
//                .flatMap(event -> {
//                    if (event.getOrganizers().contains(organizerId)) {
//                        return Mono.error(new IllegalArgumentException("Organizer already added to event"));
//                    }
//                    event.getOrganizers().add(organizerId);
//                    return eventRepository.save(event).then();
//                });
    }

    public Mono<Void> addParticipant(UUID eventId, Participant participant) {
        return null;
        // Add participant to event
//        String participantId = participant.getUserId();
//        if (participantId == null || participantId.isEmpty()) {
//            return Mono.error(new IllegalArgumentException("Participant ID is invalid"));
//        }
//
//        return eventRepository.findById(eventId)
//                .switchIfEmpty(Mono.error(new IllegalArgumentException("Event not found")))
//                .flatMap(event -> {
//                    if (event.getParticipants() != null && event.getParticipants().contains(participantId)) {
//                        return Mono.error(new IllegalArgumentException("Participant already added to event"));
//                    }
//                    if (event.getParticipants() == null) {
//                        event.setParticipants(new ArrayList<>());
//                    }
//                    event.getParticipants().add(participantId);
//                    return eventRepository.save(event).then();
//                });
    }

    public Mono<Event> getEventById(UUID eventId) {
        Mono<EventEntity> eventMono = eventRepository.findById(eventId);
        eventMono.flatMap(event -> {
            Mono<AddressEntity> address = addressRepository.findById(event.getAddress());
            Event event = new Event()
        }
        return null;
    }

    public Mono<Event> createEvent(NewEvent event) {
        return null;
//        return eventRepository.save(eventMapper.newEventToEventEntity(event)).map(eventMapper::eventEntityToEvent);
    }

    public Flux<Event> getAllEvents() {
        return null;
//        return eventRepository.findAll().map(eventMapper::eventEntityToEvent);
    }
}
