import { Injectable } from '@nestjs/common';
import { AddParticipantDto } from './dto/add-participant.dto';
import { UpdateParticipantDto } from './dto/update-participant.dto';

@Injectable()
export class ParticipantsService {
  create(createParticipantDto: AddParticipantDto) {
    return 'This action adds a new participant';
  }

  remove(id: string) {
    return `This action removes a #${id} participant`;
  }
}
