import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class StudentsService {

  studentsUrl: '';

  constructor(private http:HttpClient) { }

  

  getStudents() {









      // return [ {
      //   id: 1,
      //   first_name: "mihailo",
      //   last_name: "maric",
      //   email: "aaaa",
      //   cardNumber: "11",
      //   enrollments: [1],
      //   documents: [1],
      //   accounts: [1]
      //  },
      //  {
      //   id: 2,
      //   first_name: "mihailo",
      //   last_name: "maric",
      //   email: "aaaa",
      //   cardNumber: "11",
      //   enrollments: ["1"],
      //   documents: [1],
      //   accounts: [1]
      //  },
      //  {
      //   id: 3,
      //   first_name: "mihailo",
      //   last_name: "maric",
      //   email: "aaaa",
      //   cardNumber: "11",
      //   enrollments: [1],
      //   documents: [1],
      //   accounts: [1]
  
      //  },
      //  ]
  }
}
