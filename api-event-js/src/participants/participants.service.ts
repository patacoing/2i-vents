import { Injectable, NotFoundException, ConflictException } from '@nestjs/common';
import { AddParticipantDto } from './dto/add-participant.dto';
import { InjectRepository } from '@nestjs/typeorm';
import { Repository } from 'typeorm';
import { EventEntity } from '../events/entities/event.entity';
import { EventsService } from '../events/events.service';

@Injectable()
export class ParticipantsService {
  constructor(
    private readonly eventsService: EventsService,
    @InjectRepository(EventEntity)
    private readonly eventRepository: Repository<EventEntity>,
  ) {}

  /**
   * Ajoute un participant à un événement
   * Swagger:
   * 201 - Participant ajouté avec succès
   * 404 - Event non trouvé
   */
  async create(eventId: string, createParticipantDto: AddParticipantDto): Promise<EventEntity> {
    const event = await this.eventsService.findOne(eventId);

    const userIdStr = String(createParticipantDto.userId);
    if (event.participants.includes(userIdStr)) {
      throw new ConflictException(`Participant with userId "${userIdStr}" already in event "${eventId}"`);
    }

    event.participants.push(userIdStr);
    const updatedEvent = await this.eventRepository.save(event);
    return updatedEvent;
  }

  /**
   * Supprime un participant d’un événement
   * Swagger:
   * 204 - Participant supprimé avec succès
   * 404 - Event ou participant non trouvé
   */
  async remove(eventId: string, userId: string): Promise<void> {
    const event = await this.eventsService.findOne(eventId);

    const index = event.participants.indexOf(userId);
    if (index === -1) {
      throw new NotFoundException(`Participant with userId "${userId}" not found in event "${eventId}"`);
    }

    event.participants.splice(index, 1);
    await this.eventRepository.save(event);
  }
}
