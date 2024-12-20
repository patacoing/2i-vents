import { Controller, Post, Delete, Body, Param, HttpCode } from '@nestjs/common';
import { OrganizersService } from './organizers.service';
import { AddOrganizerDto } from './dto/add-organizer.dto';
import { EventIdParamDto } from 'src/common/dto/event-id-param.dto';
import { EventUserIdParamDto } from 'src/common/dto/event-user-id-param.dto';

@Controller('events/:eventId/organizers')
export class OrganizersController {
  constructor(private readonly organizersService: OrganizersService) {}

  @Post()
  @HttpCode(201)
  async create(
    @Param() params: EventIdParamDto, 
    @Body() addOrganizerDto: AddOrganizerDto
  ) {
    const event = await this.organizersService.create(params.eventId, addOrganizerDto);
    return event;
  }

  @Delete(':userId')
  @HttpCode(204)
  async remove(@Param() params: EventUserIdParamDto): Promise<void> {
    await this.organizersService.remove(params.eventId, params.userId);
    // Pas de contenu, 204 No Content
  }
}