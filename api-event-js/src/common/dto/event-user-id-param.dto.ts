import { IsMongoId, IsNotEmpty, IsString } from 'class-validator';

export class EventUserIdParamDto {
  @IsMongoId()
  @IsNotEmpty()
  eventId: string;

  @IsString()
  @IsNotEmpty()
  userId: string;
}
