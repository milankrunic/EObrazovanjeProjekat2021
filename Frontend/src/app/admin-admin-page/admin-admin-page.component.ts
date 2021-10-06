import { Component, OnInit } from '@angular/core';
import { admin } from '../model/admin';
import { AdminService } from '../services/admin/admin.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-admin-page',
  templateUrl: './admin-admin-page.component.html',
  styleUrls: ['./admin-admin-page.component.css']
})
export class AdminAdminPageComponent implements OnInit {

  admins:admin[];

  constructor(private adminService:AdminService, private router:Router) { }

  ngOnInit(): void {

    this.adminService.getAdmins().subscribe((data: admin[]) => {
      console.log(data);
      this.admins = data;
    });
    
  }

  deleteAdmin(idAdmin: number): void {
    this.adminService.delete(idAdmin).subscribe(
      () => this.adminService.getAdmins()
    );
    location.reload();
  }

  gotoAdd(): void {
    this.router.navigate(['/addAdmin']);
  }

}
