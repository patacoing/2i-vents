import { Injectable } from '@nestjs/common';
import { AddOrganizerDto } from './dto/add-organizer.dto';

@Injectable()
export class OrganizersService {
  create(AddOrganizerDto: AddOrganizerDto) {
    return 'This action adds a new organizer';
  }

  remove(id: string) {
    return `This action removes a #${id} organizer`;
  }
}
