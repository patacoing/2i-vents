import { Injectable } from '@nestjs/common';
import { AddOrganizerDto } from './dto/add-organizer.dto';
import { UpdateOrganizerDto } from './dto/update-organizer.dto';

@Injectable()
export class OrganizersService {
  create(AddOrganizerDto: AddOrganizerDto) {
    return 'This action adds a new organizer';
  }

  remove(id: number) {
    return `This action removes a #${id} organizer`;
  }
}
