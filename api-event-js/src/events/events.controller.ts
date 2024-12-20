import { Controller, Get, Post, Body, Param, Delete, Put, HttpCode } from '@nestjs/common';
import { EventsService } from './events.service';
import { CreateEventDto } from './dto/create-event.dto';
import { UpdateEventDto } from './dto/update-event.dto';
import { MessagePattern, Payload } from '@nestjs/microservices';
import { EventIdParamDto } from 'src/common/dto/event-id-param.dto';

@Controller('events')
export class EventsController {
  constructor(private readonly eventsService: EventsService) {}

  @Post()
  create(@Body() createEventDto: CreateEventDto) {
    return this.eventsService.create(createEventDto);
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
  update(@Param() params: EventIdParamDto, @Body() updateEventDto: UpdateEventDto) {
    return this.eventsService.update(params.eventId, updateEventDto);
  }

  @Delete(':id')
  @HttpCode(204)
  async remove(@Param() params: EventIdParamDto) {
    await this.eventsService.remove(params.eventId);
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
