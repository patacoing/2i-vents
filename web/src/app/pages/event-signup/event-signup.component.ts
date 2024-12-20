import { Component } from '@angular/core';
import { ButtonModule } from 'primeng/button';

@Component({
  selector: 'app-event-signup',
  imports: [ButtonModule],
  templateUrl: './event-signup.component.html',
  styleUrl: './event-signup.component.scss'
})
export class EventSignupComponent {
  signupData = {
    name: '',
    email: '',
    phone: '',
  };

}
