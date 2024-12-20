import { Controller, Get, Post, Body, Patch, Param, Delete } from '@nestjs/common';
import { OrganizersService } from './organizers.service';
import { AddOrganizerDto } from './dto/add-organizer.dto';
import { UpdateOrganizerDto } from './dto/update-organizer.dto';

@Controller('organizers')
export class OrganizersController {
  constructor(private readonly organizersService: OrganizersService) {}

  @Post()
  create(@Body() AddOrganizerDto: AddOrganizerDto) {
    return this.organizersService.create(AddOrganizerDto);
  }

  @Delete(':id')
  remove(@Param('id') id: string) {
    return this.organizersService.remove(+id);
  }
}
