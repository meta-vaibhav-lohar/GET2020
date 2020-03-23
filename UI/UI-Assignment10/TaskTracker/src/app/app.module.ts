import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { TaskCategoryComponent } from './task-category/task-category.component';
import { TasksComponent } from './tasks/tasks.component';
import { AddTaskComponent } from './add-task/add-task.component';

import { AddTaskService } from './services/add-task.service';
@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    TaskCategoryComponent,
    TasksComponent,
    AddTaskComponent,
  
  ],
  imports: [
    BrowserModule
  ],
  providers: [AddTaskService],
  bootstrap: [AppComponent]
})
export class AppModule { }
