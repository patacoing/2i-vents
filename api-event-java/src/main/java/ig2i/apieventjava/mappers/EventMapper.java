package ig2i.apieventjava.mappers;

import ig2i.apieventjava.dto.Event;
import ig2i.apieventjava.dto.NewEvent;
import ig2i.apieventjava.entities.AddressEntity;
import ig2i.apieventjava.entities.EventEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = AddressMapper.class)
public interface EventMapper {
    Event eventEntityToEvent(EventEntity eventEntity, AddressEntity addressEntity);
//    EventEntity eventToEventEntity(Event event);
//    EventEntity newEventToEventEntity(NewEvent newEvent);
}