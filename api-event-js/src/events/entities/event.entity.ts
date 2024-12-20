import { Entity, ObjectIdColumn, ObjectId, Column } from 'typeorm';
import { Address } from './address.embedded';

@Entity('events')
export class EventEntity {
  @ObjectIdColumn()
  _id: ObjectId;

  @Column()
  name: string;

  @Column()
  description: string;

  @Column(type => Address)
  address: Address;

  @Column()
  participants: string[];

  @Column()
  organizers: string[];

  @Column()
  date: string; // Au format 'YYYY-MM-DD' d'après le swagger

  @Column()
  time: string; // Au format 'HH:MM:SS' ou similaire

  @Column()
  themes: string[];
}