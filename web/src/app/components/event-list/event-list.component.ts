import { Component, OnInit, Input } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DataViewModule } from 'primeng/dataview';
import { AvatarModule } from 'primeng/avatar';
import { ButtonModule } from 'primeng/button';

@Component({
  standalone: true,
  selector: 'app-event-list',
  templateUrl: './event-list.component.html',
  imports: [
    CommonModule,
    DataViewModule,
    AvatarModule,
    ButtonModule
  ],
  styleUrls: ['./event-list.component.scss']
})
export class EventListComponent implements OnInit {

  
  // events: any[] = [
  //   {
  //     userName: 'Alice',
  //     name: 'Concert Jazz',
  //     description: 'Un concert de jazz unique en son genre.',
  //     address: 'Théâtre du Châtelet, Paris',
  //     date: new Date(),
  //     time: '20:00',
  //     theme: 'Jazz & Blues',
  //     image: 'https://st.depositphotos.com/1003345/3192/i/450/depositphotos_31922699-stock-photo-saxophonist.jpg',
  //   },
  // ];

  @Input() events: any[] = [];
  
  ngOnInit(): void {}

  joinEvent(event: any) {
    console.log('Vous avez rejoint :', event.name);
  }
}
