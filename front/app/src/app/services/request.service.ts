import { Injectable } from '@angular/core';
import {HttpClient} from'@angular/common/http';
import {Observable} from 'rxjs';



@Injectable({
  providedIn: 'root'
})
export class RequestService {
//   public url:string="https://reqres.in/api"

  public url:string="http://localhost:8080/api"
  constructor(private _http:HttpClient) {

   }
   public index(route:string,params?:{[key:string]:string}):Observable<any>{
    if(params){
      const queryParams=new URLSearchParams(params)
      return this._http.get(`${this.url}/${route}?${queryParams}`);
    }else{
      return this._http.get(`${this.url}/${route}`);
    }
   }
   

  
   
   public post(route:string,data:{[key:string]:any}):Observable<any>{
    return this._http.post(`${this.url}/${route}`,data);
   }
   
   public delete (route:string,id:any){
    return this._http.delete(`${this.url}/${route}/${id}`);
   }
   

}
