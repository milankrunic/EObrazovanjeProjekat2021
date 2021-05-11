import { Component, OnInit } from '@angular/core';
import { UsersService } from 'src/app/services/users/users.service';
import { ActivatedRoute, Router, Params } from '@angular/router';
import { user } from 'src/app/model/user';
import {switchMap} from 'rxjs/operators';
import { Location } from '@angular/common';

@Component({
  selector: 'app-student-details',
  templateUrl: './student-details.component.html',
  styleUrls: ['./student-details.component.css']
})
export class StudentDetailsComponent implements OnInit {
  users:user;

  mode:string;

  constructor(private userService: UsersService, private route: ActivatedRoute, private location: Location) {
    this.users = new user({ // if we add a new student, create an empty student
      username: '',
      password: ''
    });

  this.mode = 'ADD'
}

ngOnInit() {
  if (this.route.snapshot.params['id']) {
    this.mode = 'EDIT'; 
    // fetch student if we edit the existing student
    this.route.params.pipe(switchMap((params: Params) => 
        this.userService.getUser(+params['id']))) // convert to number
      .subscribe(res => {
        this.users = res.body;
      }
      );
  } 
}

save(): void {
  this.mode == 'ADD' ? this.add() : this.edit();    
  console.log(this.users.id);
}

private add(): void {
  this.userService.addStudent(this.users)
    .subscribe(res => {
      this.userService.announceChange();
      // this.goBack();
    });
}

private edit(): void {
  this.userService.edit(this.users, this.users.id)
    .subscribe(student => {
      this.userService.announceChange();
      // this.goBack();
    });
}

// goBack(): void {
//   this.location.back();
// }

}
