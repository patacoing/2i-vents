import { IsNumber, IsNotEmpty } from 'class-validator';

export class AddOrganizerDto {
  @IsNumber()
  @IsNotEmpty()
  userId: number;
}
