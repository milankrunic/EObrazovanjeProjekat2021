import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { account } from 'src/app/model/account';
import { studentPayments } from 'src/app/model/studentPayments';
import { AccountsService } from 'src/app/services/accounts/accounts.service';

@Component({
  selector: 'app-add-account',
  templateUrl: './add-account.component.html',
  styleUrls: ['./add-account.component.css']
})
export class AddAccountComponent implements OnInit {

  account:account;
  
  submitted:false;

  constructor(private accountService:AccountsService,private router:Router) { }

  ngOnInit() {
    this.account = {
      amount:0,
      student: '',
      studentPayments: ''
    };
  }

  onSubmit(){
    this.accountService.save(this.account).subscribe
    (response => {
      console.log(response);
     },
      error => {
        console.log(error);
      });
    
    this.account = {
      amount:0,
      student: '',
      studentPayments:'',
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
