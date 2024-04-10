import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { RequestService } from 'src/app/services/request.service';
import { DomSanitizer, SafeResourceUrl } from '@angular/platform-browser';

@Component({
  selector: 'app-favoritos',
  templateUrl: './favoritos.component.html',
  styleUrls: ['./favoritos.component.css']
})
export class FavoritosComponent implements OnInit {
  apiData:any;
  
  empty:Boolean=true;
  constructor(private _request:RequestService, private sanitizer:DomSanitizer){

  }

  ngOnInit(): void {
      this.fetchData();
  }
  sanitizeUrl(url: string): SafeResourceUrl {
    return this.sanitizer.bypassSecurityTrustResourceUrl(url);
  }

  fetchData(){    
    this._request.index("favorites").subscribe(response=>{
      this.apiData=response;
      console.log(this.apiData)
    })
  }
  eliminarFavorito(id:any){
    
    this._request.delete("favorites",id).subscribe(response=>{
      alert("gif eliminado")
      this.fetchData()
    })

}
}
