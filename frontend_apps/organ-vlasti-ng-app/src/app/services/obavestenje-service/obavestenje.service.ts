import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ObavestenjeService {
  private headers = new HttpHeaders({'Content-Type': 'application/xml'});

  constructor(private http: HttpClient) { }
  getObavestenjeList(): Observable<any> {
    return this.http.get('http://localhost:8090/obavestenje',
      {headers: this.headers, responseType: 'text'});
  }
  getObavestenjeListByUser(): Observable<any> {
    return this.http.get('http://localhost:8090/obavestenje/by-user',
      {headers: this.headers, responseType: 'text'});
  }
  getPretragaTekst(input): Observable<any> {
    return this.http.get('http://localhost:8090/obavestenje/search-text?input=' + input,
    {headers: this.headers, responseType: 'text'});
  }
  getPretragaMetadata(datumAfter, datumBefore, organVlasti, userEmail, zahtev): Observable<any> {
    return this.http.get('http://localhost:8090/obavestenje/search-metadata?datumAfter=' + datumAfter + '&datumBefore=' + datumBefore + '&organ_vlasti=' + organVlasti + '&userEmail=' + userEmail + '&zahtev=' + zahtev,
      {headers: this.headers, responseType: 'text'});
  }
}
