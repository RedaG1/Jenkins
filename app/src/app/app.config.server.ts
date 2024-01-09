import { mergeApplicationConfig, ApplicationConfig } from '@angular/core';
import { provideServerRendering } from '@angular/platform-server';
import { appConfig } from './app.config';
import { provideRouter } from '@angular/router';
import { routeConfig } from './routes';

// added routeConfig from routes.ts here !
// i dont know what the fuck the difference between app.config vs app.server.config !

const serverConfig: ApplicationConfig = {
  providers: [
    provideServerRendering(),
    provideRouter(routeConfig)
  ]
};

export const config = mergeApplicationConfig(appConfig, serverConfig);
