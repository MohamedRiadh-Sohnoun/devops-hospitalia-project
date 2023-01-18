import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Drug } from 'src/app/entity/drug/drug';

@Injectable({
  providedIn: 'root'
})
export class DrugService {

  private baseUrl = 'http://localhost:8080/api/drugs';
  
  constructor(private httpClient: HttpClient) { }

  getDrugsList(): Observable<Drug[]>{
    return this.httpClient.get<Drug[]>(`${this.baseUrl}/all-drugs`);
  }

  createDrug(drug: Drug): Observable<Drug> {
    return this.httpClient.post<Drug>(`${this.baseUrl}/create`, drug);
  }

  getDrugById(id: number): Observable<Drug> {
    return this.httpClient.get<Drug>(`${this.baseUrl}/${id}`);

  }

  updateDrug(id: number, drug: Drug): Observable<Object> {
    return this.httpClient.put(`${this.baseUrl}/${id}`, drug);
  }

  deleteDrug(id: number): Observable<Object> {
    return this.httpClient.delete(`${this.baseUrl}/${id}`);
  }
}
