import { Injectable, NotFoundException } from '@nestjs/common';
import { CreateEventDto } from './dto/create-event.dto';
import { UpdateEventDto } from './dto/update-event.dto';
import { InjectRepository } from '@nestjs/typeorm';
import { Repository } from 'typeorm';
import { EventEntity } from './entities/event.entity';
import { ObjectId } from 'mongodb';

@Injectable()
export class EventsService {
  constructor(
    @InjectRepository(EventEntity)
    private readonly eventRepository: Repository<EventEntity>,
  ) {}

  // POST /events -> 201 + Event
  async create(createEventDto: CreateEventDto): Promise<EventEntity> {
    // Initialise participants et organizers si absents
    const event = this.eventRepository.create({
      ...createEventDto,
      participants: [],
      organizers: createEventDto.organizers ?? [],
    });
    return this.eventRepository.save(event);
  }

  // GET /events -> 200 + Array<Event>
  async findAll(): Promise<EventEntity[]> {
    return this.eventRepository.find();
  }

  // GET /events/{eventId} -> 200 + Event, ou 404 si non trouvé
  async findOne(eventId: string): Promise<EventEntity> {
    const objectId = new ObjectId(eventId);
    const event = await this.eventRepository.findOneBy({ _id: objectId });
    if (!event) {
      throw new NotFoundException(`Event with id "${eventId}" not found`);
    }
    return event;
  }

  // PUT /events/{eventId} -> 200 + Event mis à jour, ou 404 si non trouvé
  async update(eventId: string, updateEventDto: UpdateEventDto): Promise<EventEntity> {
    const event = await this.findOne(eventId);
    Object.assign(event, updateEventDto);
    return this.eventRepository.save(event);
  }

  // DELETE /events/{eventId} -> 204 ou 404 si non trouvé
  async remove(eventId: string): Promise<void> {
    const event = await this.findOne(eventId);
    await this.eventRepository.remove(event);
    // Pas de retour, 204 No Content
  }
}