import { IsNumber, IsNotEmpty } from 'class-validator';

export class AddParticipantDto {
  @IsNumber()
  @IsNotEmpty()
  userId: number;
}
