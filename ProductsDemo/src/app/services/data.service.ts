import { Injectable } from '@angular/core';
import{ HttpClient,HttpErrorResponse, HttpParams} from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class DataService {


  constructor(private httpClient: HttpClient) { }

  getData(url: string): Observable<any> {
    console.log(url);
    return this.httpClient.get<any>(url);
  }

  getPrice(url: string, productId: number, qty: number): Observable<any> {
    const params = new HttpParams()
      .set("productId", productId.toString())
      .set("qty", qty.toString());
    console.log(url);
    return this.httpClient.get<any>(url, { params: params });
  }

}
  