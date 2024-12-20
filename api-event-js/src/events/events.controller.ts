import { Controller, Get, Post, Body, Param, Delete, Put } from '@nestjs/common';
import { EventsService } from './events.service';
import { CreateEventDto } from './dto/create-event.dto';
import { UpdateEventDto } from './dto/update-event.dto';
import { IdParamDto } from 'src/common/dto/id-param.dto';

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
  findOne(@Param() params: IdParamDto) {
    return this.eventsService.findOne(params.id);
  }

  @Put(':id')
  update(@Param() params: IdParamDto, @Body() updateEventDto: UpdateEventDto) {
    return this.eventsService.update(params.id, updateEventDto);
  }

  @Delete(':id')
  remove(@Param() params: IdParamDto) {
    return this.eventsService.remove(params.id);
  }

}
