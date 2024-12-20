import { Component } from '@angular/core';
import {Tab, TabList, TabPanel, TabPanels, Tabs, TabsModule} from 'primeng/tabs';

@Component({
  selector: 'app-user',
  imports: [
    TabsModule,
    TabPanel,
    TabPanels,
    TabList,
    Tabs,
    Tab
  ],
  templateUrl: './user.component.html',
  styleUrl: './user.component.scss'
})
export class UserComponent {

}
