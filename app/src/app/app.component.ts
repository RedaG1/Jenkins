import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink, RouterLinkActive, RouterModule, RouterOutlet } from '@angular/router';
import {FirstComponent} from './first.component';


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    CommonModule,
    RouterLink,
    RouterOutlet,
    RouterLinkActive,
    FirstComponent,
    RouterModule
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})

export class AppComponent {
  title = '[X] not working ';
}
