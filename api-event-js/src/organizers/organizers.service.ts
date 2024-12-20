import { Injectable, NotFoundException, ConflictException } from '@nestjs/common';
import { InjectRepository } from '@nestjs/typeorm';
import { AddOrganizerDto } from './dto/add-organizer.dto';
import { Repository } from 'typeorm';
import { EventEntity } from '../events/entities/event.entity';
import { EventsService } from '../events/events.service';

@Injectable()
export class OrganizersService {
  constructor(
    private readonly eventsService: EventsService,
    @InjectRepository(EventEntity)
    private readonly eventRepository: Repository<EventEntity>,
  ) {}

  /**
   * Ajoute un organizer à un événement
   * Retourne l'événement mis à jour.
   * Swagger:
   * 201 - Organizer ajouté avec succès
   * 404 - Event non trouvé
   */
  async create(eventId: string, addOrganizerDto: AddOrganizerDto): Promise<EventEntity> {
    const event = await this.eventsService.findOne(eventId);

    const userIdStr = String(addOrganizerDto.userId);
    if (event.organizers.includes(userIdStr)) {
      throw new ConflictException(`Organizer with userId "${userIdStr}" already in event "${eventId}"`);
    }

    event.organizers.push(userIdStr);
    const updatedEvent = await this.eventRepository.save(event);
    return updatedEvent;
  }

  /**
   * Supprime un organizer d’un événement
   * Swagger:
   * 204 - Organizer supprimé avec succès
   * 404 - Event ou organizer non trouvé
   */
  async remove(eventId: string, userId: string): Promise<void> {
    const event = await this.eventsService.findOne(eventId);

    const index = event.organizers.indexOf(userId);
    if (index === -1) {
      throw new NotFoundException(`Organizer with userId "${userId}" not found in event "${eventId}"`);
    }

    event.organizers.splice(index, 1);
    await this.eventRepository.save(event);
  }
}
