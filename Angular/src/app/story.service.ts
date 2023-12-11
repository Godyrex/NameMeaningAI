import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class StoryService {
  private baseUrl = 'http://localhost:9090/Story';

  constructor(private http: HttpClient) { }

  saveName(name: string): Observable<any> {
    return this.http.post(`${this.baseUrl}`, { name });
  }
  getStoryDetails(id: string): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }
}
