import { Injectable } from '@nestjs/common';
import { CreateParticipantDto } from './dto/create-participant.dto';
import { UpdateParticipantDto } from './dto/update-participant.dto';

@Injectable()
export class ParticipantsService {
  create(createParticipantDto: CreateParticipantDto) {
    return 'This action adds a new participant';
  }

  remove(id: number) {
    return `This action removes a #${id} participant`;
  }
}
