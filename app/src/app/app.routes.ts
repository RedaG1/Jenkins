import { Routes } from '@angular/router';
import {EmergencyMapComponent} from './emergency-map/emergency-map.component'


export const routes: Routes = [
    {
        path: 'testoo',
        component: EmergencyMapComponent,
        title: 'Emergence<-testing for title'
    },
];
