import { Module } from '@nestjs/common';
import { AppController } from './app.controller';
import { AppService } from './app.service';
import { EventsModule } from './events/events.module';
import { ParticipantsModule } from './participants/participants.module';
import { OrganizersModule } from './organizers/organizers.module';
import { TypeOrmModule } from '@nestjs/typeorm';
import { Address } from './events/entities/address.embedded';
import { EventEntity } from './events/entities/event.entity';

@Module({
  imports: [
    TypeOrmModule.forRoot({
      type: 'mongodb',
      url: 'mongodb://admin:admin@localhost:27017',
      database: 'api-event',
      authSource: 'admin',
      synchronize: true,
      logging: true,
      entities: [EventEntity, Address],
    }),
    TypeOrmModule.forFeature([EventEntity, Address]),
    EventsModule,
    ParticipantsModule,
    OrganizersModule,
  ],
  controllers: [AppController],
  providers: [AppService],
})
export class AppModule {}
