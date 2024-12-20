import { Module } from '@nestjs/common';
import { ParticipantsService } from './participants.service';
import { ParticipantsController } from './participants.controller';
import { TypeOrmModule } from '@nestjs/typeorm';
import { EventEntity } from 'src/events/entities/event.entity';
import { Address } from 'src/events/entities/address.embedded';
import { EventsModule } from 'src/events/events.module';
import { KafkaModule } from 'src/kafka/kafka.module';

@Module({
  imports : [
    TypeOrmModule.forFeature([EventEntity, Address]),
    KafkaModule,
    EventsModule,
  ],
  controllers: [ParticipantsController],
  providers: [ParticipantsService],
})
export class ParticipantsModule {}
