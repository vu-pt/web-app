import { Component } from '@angular/core';

@Component({
  selector: 'app-side-bar',
  templateUrl: './side-bar.component.html',
  styleUrls: ['./side-bar.component.scss']
})
export class SideBarComponent {
  featureItem = [
    {
      label: 'Dashboard',
      routerLink: '/',
      active: true
    },
    {
      label: 'User Management',
      routerLink: '/user',
      active: false
    }
  ];

  onActive(itemLabel: string) {
    this.featureItem.forEach((item)=>{
        item.active = item.label === itemLabel;
    });
  }
}
