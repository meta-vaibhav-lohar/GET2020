import { Component, OnInit, Input } from '@angular/core';
import { AddTaskService } from '../services/add-task.service';
@Component({
  selector: 'app-tasks',
  templateUrl: './tasks.component.html',
  styleUrls: ['./tasks.component.css']
})
export class TasksComponent implements OnInit {
  @Input() status: string;
  constructor( private addTaskService: AddTaskService) {}

  tasks = this.addTaskService.show();
  ngOnInit(): void {console.log(this.status); }
  edit(t): void {
    const taskDetails = {
      id: t.id,
      title: (document.getElementById('editTitle') as HTMLInputElement).value,
      description: (document.getElementById('editDescription') as HTMLTextAreaElement).value,
      status: (document.getElementById('editStatus') as HTMLSelectElement ).value
    };
    this.tasks[this.tasks.indexOf(this.tasks[t.id])] = taskDetails;
    window.alert('Task Edited');
  }
}
