import { Routes } from '@angular/router';
import { Home } from './home/home';
import { Dashboard } from './dashboard/dashboard';
import { Admin } from './admin/admin';
import { Notfound } from './notfound/notfound';

export const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'home' },
  { path: 'home', component: Home },
  { path: 'dashboard', component: Dashboard },
  { path: 'admin', component: Admin },
  { path: '**', component: Notfound }
];
