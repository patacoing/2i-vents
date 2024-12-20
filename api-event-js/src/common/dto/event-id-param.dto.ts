import { IsMongoId, IsNotEmpty } from 'class-validator';

export class EventIdParamDto {
  @IsMongoId()
  @IsNotEmpty()
  eventId: string;

  public toString(): string {
    return JSON.stringify(this);
  }
}
