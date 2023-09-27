import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  private apiUrl = 'http://localhost:8080/api/v1'; // Substitua pela URL da sua API

  constructor(private http: HttpClient) { }

  getData(): Observable<any> {
    return this.http.get(`${this.apiUrl}/segurados`);
  }
}
