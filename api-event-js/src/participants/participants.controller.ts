import { Controller, Get, Post, Body, Patch, Param, Delete } from '@nestjs/common';
import { ParticipantsService } from './participants.service';
import { AddParticipantDto } from './dto/add-participant.dto';
import { UpdateParticipantDto } from './dto/update-participant.dto';
import { IdParamDto } from 'src/common/dto/id-param.dto';

@Controller('participants')
export class ParticipantsController {
  constructor(private readonly participantsService: ParticipantsService) {}

  @Post()
  create(@Body() AddParticipantDto: AddParticipantDto) {
    return this.participantsService.create(AddParticipantDto);
  }

  @Delete(':id')
  findOne(@Param() params: IdParamDto) {
    return this.participantsService.remove(params.id);
  }
}
