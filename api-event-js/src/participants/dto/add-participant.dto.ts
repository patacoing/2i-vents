import { IsNumber, IsNotEmpty, IsMongoId, IsString } from 'class-validator';

export class AddParticipantDto {
  @IsString()
  @IsNotEmpty()
  userId: string;

  public toString(): string {
    return JSON.stringify(this);
  }
}
