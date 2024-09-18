import { Injectable } from '@angular/core';
import { ICD10 } from '../models/ICD10';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StateServicesService {

  private dataSubject = new BehaviorSubject<ICD10[]>([]);
  data$ = this.dataSubject.asObservable();  // Observable for subscribers

  setData(data: ICD10[]): void {
    this.dataSubject.next(data);  // Emit new data
  }



  private numberSource = new BehaviorSubject<number>(0); // Default value
  currentNumber = this.numberSource.asObservable();

  changeNumber(number: number) {
    this.numberSource.next(number);
  }
  constructor() { }
}
