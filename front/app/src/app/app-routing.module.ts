import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { GifComponentComponent } from './components/gif-component/gif-component.component';
import { RequestService } from './services/request.service';
import { FavoritosComponent } from './components/favoritos/favoritos/favoritos.component';

const routes: Routes = [
  {path:"",component:GifComponentComponent},
  {path:"favoritos",component:FavoritosComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents:Array<any>=[GifComponentComponent,FavoritosComponent];
export const routingWithProviders:Array<any>=[RequestService];