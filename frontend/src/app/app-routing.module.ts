import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    loadChildren: () => import('./module/dashboard/dashboard.module').then(
      module => module.DashboardModule
    )
  },
  {
    path: 'user',
    loadChildren: () => import('./module/user/user.module').then(
      module => module.UserModule
    )
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
