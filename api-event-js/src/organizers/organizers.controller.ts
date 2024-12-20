import { Controller, Post, Delete, Body, Param, HttpCode } from '@nestjs/common';
import { OrganizersService } from './organizers.service';
import { AddOrganizerDto } from './dto/add-organizer.dto';
import { EventIdParamDto } from 'src/common/dto/event-id-param.dto';
import { EventUserIdParamDto } from 'src/common/dto/event-user-id-param.dto';
import { MessagePattern, Payload } from '@nestjs/microservices';
import { KafkaService } from 'src/kafka/kafka.service';

@Controller('events/:eventId/organizers')
export class OrganizersController {
  constructor(
    private readonly organizersService: OrganizersService,
    private readonly kafkaService: KafkaService,
  ) {}

  @Post()
  @HttpCode(201)
  async create(
    @Param() params: EventIdParamDto, 
    @Body() addOrganizerDto: AddOrganizerDto
  ) {
    const event = await this.organizersService.create(params.eventId, addOrganizerDto);
    await this.kafkaService.sendMessage('organizers.add', {
      params,
      body: addOrganizerDto,
    });
    return event;
  }

  @Delete(':userId')
  @HttpCode(204)
  async remove(@Param() params: EventUserIdParamDto): Promise<void> {
    await this.organizersService.remove(params.eventId, params.userId);
    await this.kafkaService.sendMessage('organizers.delete', params);
  }

  @MessagePattern('organizers.add')
  async messageCreate(
    @Payload() payload: { params: EventIdParamDto; body: AddOrganizerDto },
  ) {
    const { params, body } = payload;
    const event = await this.organizersService.create(params.eventId, body);
    return event;
  }

  @MessagePattern('organizers.delete')
  async messageRemove(@Payload() params: EventUserIdParamDto): Promise<void> {
    await this.organizersService.remove(params.eventId, params.userId);
  }
}