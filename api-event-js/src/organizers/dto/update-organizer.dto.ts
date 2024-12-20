import { PartialType } from '@nestjs/mapped-types';
import { AddOrganizerDto } from './add-organizer.dto';

export class UpdateOrganizerDto extends PartialType(AddOrganizerDto) {}
