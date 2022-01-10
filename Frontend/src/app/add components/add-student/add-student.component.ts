import { Component, OnInit } from '@angular/core';
import { user } from 'src/app/model/user';
import { UsersService } from 'src/app/services/users/users.service';
import {Router, Routes} from '@angular/router';
import { student } from 'src/app/model/student';
import { StudentsService } from 'src/app/services/students/students.service';


@Component({
  selector: 'app-add-student',
  templateUrl: './add-student.component.html',
  styleUrls: ['./add-student.component.css']
})
export class AddStudentComponent implements OnInit {

  student: student;
  
  submitted = false;
  

  constructor(private studentService:StudentsService, private router: Router ) { }



  ngOnInit() {
      this.student = {
        cardNumber: '',
        userDTO:{
           firstName:'',
           lastName:'',
           email:'',
           userName:'',
           password:'',
     //      roles:[]
        }
      };
  }

  onSubmit(){
    this.studentService.save(this.student).subscribe
    (response => {
      console.log(response);
     },
      error => {
        console.log(error);
      });

      this.student = {
        cardNumber: '',
        userDTO:{
           firstName:'',
           lastName:'',
           email:'',
           userName:'',
           password:'',
     //      roles:[]
        }
      };   
  }

  // ngOnInit(): void {
  //   this.submitted = false;
    
  // }

  // onSubmit(): void {
    
  //   this.studentService.save(this.student)
  //   .subscribe(
  //     response => {
  //       console.log(response);
  //       this.submitted = true;
  //     },
  //     error => {
          
  //         console.log(error);
  //       });
  // }
  //     newUser(): void {
  //       this.submitted = false;
  //       this.student = {
  //         first_name: '',
  //         cardNumber: '',
  //         last_name: '',
  //         email: ''
  //       };
  //     }

  //     backToUsers() {
  //       this.router.navigate(['/adminstudents']);
  //     }

      
}
