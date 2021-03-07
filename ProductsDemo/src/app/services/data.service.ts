import { Injectable } from '@angular/core';
import{ HttpClient,HttpErrorResponse, HttpParams} from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class DataService {


  constructor(private HttpClient: HttpClient) { }

  private handleErrors(errorResponce: HttpErrorResponse) {
    console.log('Error- ' + errorResponce);
  }

  getData(url: string): Observable<any> {
    
    console.log(url);
    return this.HttpClient.get<any>(url);
    //catchError(thi.handleErrors);
  }
  getPrice(url: string,productId: number, qty:number): Observable<any> {
    const params = new HttpParams()
    .set("productId", productId.toString())
    .set("qty", qty.toString());
//     let headers = new Headers();
// headers.append('Content-Type', 'application/json');
// headers.append("productId", productId.toString());
// headers.append("productId", qty.toString())

    // params.append("productId", productId.toString());
    // params.append("qty", qty.toString())
    console.log(url);
     return this.HttpClient.get<any>(url, {params: params});
    // catchError(thi.handleErrors);
    //  return null;
  }


  
  //postData
}
  