import { PartialType } from '@nestjs/mapped-types';
import { AddParticipantDto } from './add-participant.dto';

export class UpdateParticipantDto extends PartialType(AddParticipantDto) {}
