import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink, RouterLinkActive, RouterModule, RouterOutlet } from '@angular/router';


@Component({
  selector: 'home-comp',
  standalone: true,
  imports: [
    CommonModule,
    RouterLink,
    RouterOutlet,
    RouterLinkActive,
    RouterModule
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})

export class HomeComponent {
  title = 'Home';
}
