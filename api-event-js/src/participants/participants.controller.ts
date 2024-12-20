import { Controller, Post, Delete, Body, Param, HttpCode } from '@nestjs/common';
import { ParticipantsService } from './participants.service';
import { AddParticipantDto } from './dto/add-participant.dto';
import { EventIdParamDto } from 'src/common/dto/event-id-param.dto';
import { EventUserIdParamDto } from 'src/common/dto/event-user-id-param.dto';
import { MessagePattern, Payload } from '@nestjs/microservices';

@Controller('events/:eventId/participants')
export class ParticipantsController {
  constructor(private readonly participantsService: ParticipantsService) {}

  @Post()
  @HttpCode(201)
  async create(
    @Param() params: EventIdParamDto, 
    @Body() addParticipantDto: AddParticipantDto
  ) {
    const event = await this.participantsService.create(params.eventId, addParticipantDto);
    return event;
  }

  @Delete(':userId')
  @HttpCode(204)
  async remove(@Param() params: EventUserIdParamDto): Promise<void> {
    await this.participantsService.remove(params.eventId, params.userId);
  }

  @MessagePattern('participants.add')
  async messageCreate(
    @Payload() payload: { params: EventIdParamDto; body: AddParticipantDto },
  ) {
    const { params, body } = payload;
    const event = await this.participantsService.create(params.eventId, body);
    return event;
  }

  @MessagePattern('participants.delete')
  async messageRemove(@Payload() params: EventUserIdParamDto): Promise<void> {
    await this.participantsService.remove(params.eventId, params.userId);
  }
}