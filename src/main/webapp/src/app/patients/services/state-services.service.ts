import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class StateServicesService {

  private state: any = null;

  setState(state: any): void {
    this.state = state;
  }

  getState(): any {
    return this.state;
  }

  constructor() { }
}
