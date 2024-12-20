import {Routes} from '@angular/router';
import {UsersComponent} from "./pages/users/users.component";
import {LoginComponent} from "./pages/users/login/login.component";
import {RegisterComponent} from "./pages/users/register/register.component";

export const routes: Routes = [
  {
    path: "user",
    component: UsersComponent,
    children: [
      {
        path: "login",
        component: LoginComponent
      },
      {
        path: "register",
        component: RegisterComponent
      }
    ]
  },
  { path: '',   redirectTo: '/user/login', pathMatch: 'full' }
];
