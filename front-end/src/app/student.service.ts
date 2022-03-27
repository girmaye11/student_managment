import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Student } from './student';
@Injectable({
  providedIn: 'root'
})
export class StudentService {
  
private baseURL = "http://localhost:8080/api/v1/students";

  constructor( private httpClient:HttpClient) { }
  getStudentsList() : Observable<Student[]>{
    return this.httpClient.get<Student[]>(`${this.baseURL}`);
  }
  createStudent(Student: Student): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`, Student);
  }

  getStudentById(id: number): Observable<Student>{
    return this.httpClient.get<Student>(`${this.baseURL}/${id}`);
  }

  updateStudent(id: number, employee: Student): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${id}`, employee);
  }

  deleteStudent(id: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${id}`);
  }
}
