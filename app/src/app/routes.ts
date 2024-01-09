import { Routes } from '@angular/router';
import {EmergencyMapComponent} from './emergency-map/emergency-map.component'
import { ContactComponent } from './contact/contact.component';
import { HomeComponent } from './home/home.component';
import { LeaderboardComponent } from './leaderboard/leaderboard.component';
import { OverviewCatastrophyComponent } from './overview-catastrophy/overview-catastrophy.component';


export const routeConfig: Routes = [
    {
        path: '',
        component: HomeComponent,
    },
    {
        path: 'emergency_mapp',
        component: EmergencyMapComponent,
        title: 'Emergence<-testing for title'
    },
    {
        path: 'leaderboard',
        component: LeaderboardComponent,
        title: 'Volunteer Leaderboard'
    },
    {
        path: 'contact_us',
        component: ContactComponent,
        title: '[X] 2'
    },
    {
        path: 'overview_over_catastrophy',
        component: OverviewCatastrophyComponent,
        title: '[X] 3'
    },
];
