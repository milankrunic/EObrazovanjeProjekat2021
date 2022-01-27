import { Component, OnInit, Input } from '@angular/core';
import { AppComponent } from 'src/app/app.component';
import { AuthenticationService } from 'src/app/services/authentication-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-teacher-sidebar',
  templateUrl: './teacher-sidebar.component.html',
  styleUrls: ['./teacher-sidebar.component.css']
})
export class TeacherSidebarComponent implements OnInit {

  @Input() collapsed:boolean;

  constructor(private app:AppComponent,
              private authenticationService: AuthenticationService,
              // private toastr: ToastrService,
              private router: Router
    ) {
    this.collapsed = app.collapsed;
   }

  ngOnInit(): void {
  }

}