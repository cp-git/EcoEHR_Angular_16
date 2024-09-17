import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { ICD10 } from '../models/ICD10';

@Injectable({
  providedIn: 'root'
})
export class StateServicesService {

  private dataSubject = new BehaviorSubject<ICD10[]>([]);
  data$ = this.dataSubject.asObservable();  // Observable for subscribers

  setData(data: ICD10[]): void {
    this.dataSubject.next(data);  // Emit new data
  }
}
