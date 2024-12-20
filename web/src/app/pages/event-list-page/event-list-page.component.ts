import { Component, OnInit  } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EventListComponent } from '../../components/event-list/event-list.component';

@Component({
  selector: 'app-event-list-page',
  imports: [EventListComponent, CommonModule],
  templateUrl: './event-list-page.component.html',
  styleUrls: ['./event-list-page.component.scss']
})
export class EventListPageComponent implements OnInit {
  events = [
    { name: 'Conférence A', description: 'Une conférence sur le développement.', date: '2024-12-21', time: '10:00', theme: 'Développement', image: 'https://t4.ftcdn.net/jpg/02/98/35/71/360_F_298357190_yjGRacL1FZ75l6wyRROrAdq6q3rMPCqD.jpg', address: 'Théâtre du Châtelet, Paris'},
    { name: 'Atelier B', description: 'Atelier sur Angular.', date: '2024-12-22', time: '14:00', theme: 'Angular', image: 'https://bs-uploads.toptal.io/blackfish-uploads/components/blog_post_page/content/cover_image_file/cover_image/1275957/retina_1708x683_cover-top-18-most-common-angularjs-developer-mistakes-41f9ad303a51db70e4a5204e101e7414.png', address: 'Théâtre du Châtelet, Paris'},
    { name: 'Hackathon X', description: 'Événement très populaire.', date: '2024-12-25', time: '08:00', theme: 'Développement', image: 'https://www.lassuranceenmouvement.com/wp-content/uploads/2019/09/hackathon.png', address: 'Théâtre du Châtelet, Paris'},
    { name: 'Meetup Y', description: 'Un meetup incontournable.', date: '2024-12-26', time: '18:00', theme: 'Développement', image: 'https://www.meetup.com/blog/wp-content/uploads/2020/08/holding-hands.jpg', address: 'Théâtre du Châtelet, Paris'},
    { name: 'Séminaire Z', description: 'Recommandé par nos experts.', date: '2025-01-01', time: '09:00', theme: 'Développement', image: 'https://lvtalents.com/wp-content/uploads/2016/05/lvtalents-management-appreciatif-qualite-de-vie-au-travail-solutions-seminaires-01.jpg', address: 'Théâtre du Châtelet, Paris'},
    { name: 'Webinaire W', description: 'Un webinaire instructif.', date: '2025-01-02', time: '16:00', theme: 'Développement', image: 'https://st.depositphotos.com/1003345/3192/i/450/depositphotos_31922699-stock-photo-saxophonist.jpg', address: 'Théâtre du Châtelet, Paris'},
  ];

  constructor() {}

  ngOnInit(): void {
    console.log('Events:', this.events);
  }

}
