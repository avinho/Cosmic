import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: 'dashboard',
    loadChildren: () =>
      import('./pages/dashboard/dashboard.module').then(
        (m) => m.DashboardModule
      ),
  },
  {
    path: 'segurados',
    loadChildren: () =>
      import('./pages/segurados/segurados.module').then(
        (m) => m.SeguradosModule
      ),
  },
  {
    path: 'seguradoras',
    loadChildren: () =>
      import('./pages/seguradoras/seguradoras.module').then(
        (m) => m.SeguradorasModule
      ),
  },
  {
    path: 'apolices',
    loadChildren: () =>
      import('./pages/apolices/apolices.module').then((m) => m.ApolicesModule),
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
