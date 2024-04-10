
import { Component, } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { RequestService } from 'src/app/services/request.service';
import { DomSanitizer, SafeResourceUrl } from '@angular/platform-browser';

@Component({
  selector: 'app-gif-component',
  templateUrl: './gif-component.component.html',
  styleUrls: ['./gif-component.component.css']
})
export class GifComponentComponent {

  apiData:any;
  form: FormGroup;
  empty:Boolean=true;
 
  constructor(private _request:RequestService,private sanitizer: DomSanitizer){
    this.form=new FormGroup({
      gifName: new FormControl("",Validators.required),
      gifLimit: new FormControl(""),
      gifOffset: new FormControl("") 
    })
  }
  ngOnInit(){
    // this.fetchData();
  }
  fetchData(params:string){
    
    this._request.index("gifs?"+params).subscribe(response=>{
      this.empty=false;
      this.apiData=response;
      console.log(this.apiData)
    })
  }
  sanitizeUrl(url: string): SafeResourceUrl {
    return this.sanitizer.bypassSecurityTrustResourceUrl(url);
  }
  onSubmit(){
    let values:{[key:string]:string}={};
    this.pruneEmptyStringValues(this.form);
    if(this.form.valid){
      for(const key in this.form.value){
        if(this.form.value[key]===null){
  
        }else{
          values[key]=this.form.value[key]
        }
        
        const params=new URLSearchParams(values);
       this.fetchData(""+params);
      }
    }else{
      this.empty=true;
    }
  }
  saveFavorito(gifurl:string){
      console.log(gifurl);
      this._request.post("favorites",{gifurl:gifurl}).subscribe(response=>{
        alert("gif añadido")
      })

  }
  private pruneEmptyStringValues(formGroup: FormGroup) {
    Object.keys(formGroup.controls).forEach(key => {
      const control = formGroup.get(key);

      if (control instanceof FormControl) {
        // If the control is a FormControl and its value is an empty string, set it to null
        if (control.value === '') {
          control.patchValue(null);
        }
      } else if (control instanceof FormGroup) {
        // If the control is a FormGroup, recursively call pruneEmptyStringValues
        this.pruneEmptyStringValues(control);
      }
    });
  }
}
