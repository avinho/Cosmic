import { Component } from '@angular/core';

interface item {
  link: string;
  icon: string;
  label: string;
}

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent {
  title = 'Cosmic';
  opened = true;
  items_menu: item[] = [
    {
      link: '/dashboard',
      icon: 'dashboard',
      label: 'Dashboard',
    },
    {
      link: '/apolices',
      icon: 'description',
      label: 'Apólices',
    },
    {
      link: '/segurados',
      icon: 'person',
      label: 'Segurados',
    },
    {
      link: '/seguradoras',
      icon: 'apartment',
      label: 'Seguradoras',
    }
  ];
}
