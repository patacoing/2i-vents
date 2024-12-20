import { Module } from '@nestjs/common';
import { AppController } from './app.controller';
import { AppService } from './app.service';
import { EventsModule } from './events/events.module';
import { ParticipantsModule } from './participants/participants.module';
import { OrganizersModule } from './organizers/organizers.module';

@Module({
  imports: [EventsModule, ParticipantsModule, OrganizersModule],
  controllers: [AppController],
  providers: [AppService],
})
export class AppModule {}
