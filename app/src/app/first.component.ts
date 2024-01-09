import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'first-comp',
  standalone: true,
   imports: [
       CommonModule,
       RouterOutlet],
  templateUrl: './first.component.html'
})


export class FirstComponent {
  title = 'First app Componenet ';
  zab = 'same but differnet  ';
}
