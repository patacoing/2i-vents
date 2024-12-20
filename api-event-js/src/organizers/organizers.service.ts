import { Injectable } from '@nestjs/common';
import { CreateOrganizerDto } from './dto/create-organizer.dto';
import { UpdateOrganizerDto } from './dto/update-organizer.dto';

@Injectable()
export class OrganizersService {
  create(createOrganizerDto: CreateOrganizerDto) {
    return 'This action adds a new organizer';
  }

  remove(id: number) {
    return `This action removes a #${id} organizer`;
  }
}
