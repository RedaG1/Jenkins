import { Component } from '@angular/core';
import { RouterOutlet, RouterModule } from '@angular/router';

@Component({
  selector: 'app-contact',
  standalone: true,
  imports: [
    RouterModule,
    RouterOutlet
  ],
  templateUrl: './contact.component.html',
  styleUrl: './contact.component.css'
})
export class ContactComponent {

}
