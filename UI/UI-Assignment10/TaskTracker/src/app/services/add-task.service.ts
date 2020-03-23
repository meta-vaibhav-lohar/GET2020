import { Injectable, SkipSelf } from '@angular/core';
import { Tasks } from '../tasks';
@Injectable({
  providedIn: 'root'
})
export class AddTaskService {
  tasks=[];
  constructor() { }
  public add(task): void {
    this.tasks.push(task);
  }
  public size(): number {
    return this.tasks.length;
  }
  public show() {
    return this.tasks;
  }
}
