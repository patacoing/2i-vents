import { Controller, Get, Post, Body, Param, Delete, Put, HttpCode } from '@nestjs/common';
import { EventsService } from './events.service';
import { CreateEventDto } from './dto/create-event.dto';
import { UpdateEventDto } from './dto/update-event.dto';
import { MessagePattern, Payload } from '@nestjs/microservices';
import { EventIdParamDto } from 'src/common/dto/event-id-param.dto';
import { KafkaService } from 'src/kafka/kafka.service';

@Controller('events')
export class EventsController {
  constructor(
    private readonly eventsService: EventsService,
    private readonly kafkaService: KafkaService,
  ) {}

  @Post()
  async create(@Body() createEventDto: CreateEventDto) {
    const event = await this.eventsService.create(createEventDto);
    await this.kafkaService.sendMessage('events.post', createEventDto);
    return event;
  }

  @Get()
  findAll() {
    return this.eventsService.findAll();
  }

  @Get(':id')
  findOne(@Param() params: EventIdParamDto) {
    return this.eventsService.findOne(params.eventId);
  }

  @Put(':id')
  async update(@Param() params: EventIdParamDto, @Body() updateEventDto: UpdateEventDto) {
    const updatedEvent = await this.eventsService.update(params.eventId, updateEventDto);
    await this.kafkaService.sendMessage('events.update', {
      params,
      body: updateEventDto,
    });
    return updatedEvent;
  }

  @Delete(':id')
  @HttpCode(204)
  async remove(@Param() params: EventIdParamDto) {
    await this.eventsService.remove(params.eventId);
    await this.kafkaService.sendMessage('events.delete', params);
  }

  @MessagePattern('events.post')
  messageCreate(@Payload() createEventDto: CreateEventDto) {
    return this.eventsService.create(createEventDto);
  }

  @MessagePattern('events.update')
  messageUpdate(@Payload() payload: { params: EventIdParamDto; body: UpdateEventDto }) {
    const { params, body } = payload;
    return this.eventsService.update(params.eventId, body);
  }

  @MessagePattern('events.delete')
  async messageRemove(@Payload() params: EventIdParamDto) {
    await this.eventsService.remove(params.eventId);
  }

}
