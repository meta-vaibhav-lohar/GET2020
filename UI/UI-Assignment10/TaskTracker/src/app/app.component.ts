import { Component } from '@angular/core';
import { AddTaskService } from './services/add-task.service';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [ AddTaskService ]
})
export class AppComponent {
  title = 'TaskTracker';
}
