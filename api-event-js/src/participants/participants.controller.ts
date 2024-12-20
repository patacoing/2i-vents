import { Controller, Post, Delete, Body, Param, HttpCode } from '@nestjs/common';
import { ParticipantsService } from './participants.service';
import { AddParticipantDto } from './dto/add-participant.dto';
import { EventIdParamDto } from 'src/common/dto/event-id-param.dto';
import { EventUserIdParamDto } from 'src/common/dto/event-user-id-param.dto';

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
}