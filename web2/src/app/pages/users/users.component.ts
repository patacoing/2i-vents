import { Component } from '@angular/core';
import {Button} from "primeng/button";
import {TabViewModule} from "primeng/tabview";

@Component({
  selector: 'app-users',
  standalone: true,
  imports: [
    Button,
    TabViewModule
  ],
  templateUrl: './users.component.html',
  styleUrl: './users.component.css'
})
export class UsersComponent {

}
