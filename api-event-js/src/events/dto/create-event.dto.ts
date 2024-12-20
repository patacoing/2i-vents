import { IsString, IsArray, IsNotEmpty } from 'class-validator';
import { AddressDto } from './address.dto';

export class CreateEventDto {
  @IsString()
  @IsNotEmpty()
  name: string;

  @IsString()
  @IsNotEmpty()
  description: string;

  @IsNotEmpty()
  address: AddressDto;

  @IsArray()
  organizers?: string[];

  @IsString()
  @IsNotEmpty()
  date: string; // format date (YYYY-MM-DD)

  @IsString()
  @IsNotEmpty()
  time: string; // format time (HH:MM)

  @IsArray()
  @IsNotEmpty()
  themes: string[];
}
