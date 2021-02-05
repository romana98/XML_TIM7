import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AddSluzbenikService {

  private headers = new HttpHeaders({'Content-Type': 'application/xml'});

  constructor(private http: HttpClient
  ) { }

  addSluzbenik(auth: any): Observable<any> {
    return this.http.post('http://localhost:8090/users',
      auth, {headers: this.headers, responseType: 'text'});
  }
}