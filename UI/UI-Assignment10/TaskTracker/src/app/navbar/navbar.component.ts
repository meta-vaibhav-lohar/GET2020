import { Component, OnInit } from '@angular/core';
import { AddTaskService } from '../services/add-task.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  constructor( private addTaskService: AddTaskService) { }

  ngOnInit(): void {
  }

  add(): void {
    const taskDetails = {
      id: this.addTaskService.size(),
      title: (document.getElementById('title') as HTMLInputElement).value,
      description: (document.getElementById('description') as HTMLTextAreaElement).value,
      status: (document.getElementById('status') as HTMLSelectElement ).value
    };
    this.addTaskService.add(taskDetails);
    window.alert('Task Added');
  }
}
