import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
import { AppComponent } from './app/app.component';

// import { FirstComponent } from './app/first.component';
// console.log("it reaches here ? ") ;
// bootstrapApplication(FirstComponent, appConfig)
//   .catch((err) => console.error("fuck u " + err));



// this bootstraps the app !
bootstrapApplication(AppComponent, appConfig)
  .catch((err) => console.error(err));
