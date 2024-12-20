package ig2i.apieventjava.repositories;

import ig2i.apieventjava.dto.Participant;
import ig2i.apieventjava.entities.EventEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface EventRepository extends ReactiveCrudRepository<EventEntity, UUID> {
//    Mono<Void> addParticipant(String eventId, Participant participant);
}
