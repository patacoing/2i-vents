package ig2i.apieventjava.controllers;

import ig2i.apieventjava.dto.*;
import ig2i.apieventjava.services.EventService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
public class EventController implements EventsApi {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }


    @Override
    public Mono<ResponseEntity<Void>> addOrganizer(UUID eventId, Mono<Organizer> organizerMono, ServerWebExchange exchange){
        return organizerMono.flatMap(organizer -> eventService.addOrganizer(eventId, organizer))
                .then(Mono.just(ResponseEntity.status(201).build()));
    }

    @Override
    public Mono<ResponseEntity<Void>> addParticipant(UUID eventId, Mono<Participant> participant, ServerWebExchange exchange) {
        return participant.flatMap(part -> eventService.addParticipant(eventId, part))
                .then(Mono.just(ResponseEntity.status(201).build()));
    }

    @Override
    public Mono<ResponseEntity<Event>> createEvent(Mono<NewEvent> newEvent, ServerWebExchange exchange) {
        return newEvent.flatMap(eventService::createEvent)
                .map(savedEvent -> ResponseEntity.status(HttpStatus.CREATED).body(savedEvent))
                .defaultIfEmpty(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }

    @Override
    public Mono<ResponseEntity<Event>> getEventById(UUID eventId, ServerWebExchange exchange) {
        return eventService
            .getEventById(eventId)
            .map(ResponseEntity::ok)
            .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @Override
    public Mono<ResponseEntity<Flux<Event>>> getAllEvents(ServerWebExchange exchange){
        return Mono.just(ResponseEntity.ok(eventService.getAllEvents()));

    }

    @Override
    public Mono<ResponseEntity<Void>> deleteEvent(UUID eventId, ServerWebExchange exchange) {
//        return eventService.deleteEvent(eventId)
//                .then(Mono.just(ResponseEntity.noContent().build()))
//                .onErrorResume(e -> Mono.just(ResponseEntity.notFound().build()));
        return null;
    }

    @Override
    public Mono<ResponseEntity<Event>> updateEvent(UUID eventId, Mono<UpdateEvent> updateEvent, ServerWebExchange exchange) {
//        return updateEvent.flatMap(dto -> eventService.updateEvent(eventId, dto))
//                .map(ResponseEntity::ok)
//                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
            return null;
    }

    @Override
    public Mono<ResponseEntity<Void>> deleteParticipant(UUID eventId, String userId, ServerWebExchange exchange) {
//        return eventService.deleteParticipant(eventId, userId)
//                .then(Mono.just(ResponseEntity.noContent().build()))
//                .onErrorResume(e -> Mono.just(ResponseEntity.notFound().build()));
        return null;
    }

    @Override
    public Mono<ResponseEntity<Void>> deleteOrganizer(UUID eventId, String userId, ServerWebExchange exchange) {
//        return eventService.deleteOrganizer(eventId, userId)
//                .then(Mono.just(ResponseEntity.noContent().build()))
//                .onErrorResume(e -> Mono.just(ResponseEntity.notFound().build()));
        return null;
    }

}
