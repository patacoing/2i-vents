import { IsNumber, IsNotEmpty } from 'class-validator';

export class AddOrganizerDto {
  @IsNumber()
  @IsNotEmpty()
  userId: number;

  public toString(): string {
    return JSON.stringify(this);
  }
}
