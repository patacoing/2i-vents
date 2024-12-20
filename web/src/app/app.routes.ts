import {Routes} from '@angular/router';
import {UserComponent} from './pages/user/user.component';
import {LoginComponent} from './pages/user/login/login.component';
import {RegisterComponent} from './pages/user/register/register.component';

export const routes: Routes = [
  {
    path: 'user',
    component: UserComponent,
    children: [
      {
        path: 'login',
        component: LoginComponent,
      },
      {
        path: 'register',
        component: RegisterComponent,
      },
    ],
  },
  { path: '',   redirectTo: '/user/login', pathMatch: 'full' }
];

