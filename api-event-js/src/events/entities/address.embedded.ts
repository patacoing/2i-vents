import { Column } from 'typeorm';

export class Address {
  @Column()
  name: string;

  @Column()
  city: string;

  @Column()
  zipCode: string;

  @Column()
  streetName: string;

  @Column()
  streetNumber: string;
}