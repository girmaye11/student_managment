import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import{HttpClientModule} from '@angular/common/http'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { StudentListComponent } from './student-list/student-list.component';
import { CreateStudentComponent } from './create-student/create-student.component';
import { StudentDetailsComponent } from './student-details/student-details.component';
import { UpdateStudentComponent } from './update-student/update-student.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    StudentListComponent,
    CreateStudentComponent,
    StudentDetailsComponent,
    UpdateStudentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
    
  ],
  
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
