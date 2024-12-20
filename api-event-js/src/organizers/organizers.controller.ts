import { Controller, Get, Post, Body, Patch, Param, Delete } from '@nestjs/common';
import { OrganizersService } from './organizers.service';
import { AddOrganizerDto } from './dto/add-organizer.dto';
import { IdParamDto } from 'src/common/dto/id-param.dto';

@Controller('organizers')
export class OrganizersController {
  constructor(private readonly organizersService: OrganizersService) {}

  @Post()
  create(@Body() AddOrganizerDto: AddOrganizerDto) {
    return this.organizersService.create(AddOrganizerDto);
  }

  @Delete(':id')
  findOne(@Param() params: IdParamDto) {
    return this.organizersService.remove(params.id);
  }
}
