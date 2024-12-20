import { IsMongoId } from 'class-validator';

export class IdEventParamDto {
  @IsMongoId()
  idEvent: string;

  public toString(): string {
    return JSON.stringify(this);
  }
}
