import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { User } from '../user';
import { UserServiceService } from '../user-service.service';

@Component({
  selector: 'app-user-add',
  templateUrl: './user-add.component.html',
  styleUrls: ['./user-add.component.css']
})
export class UserAddComponent implements OnInit {
  user: User = new User();
  submitted = false;

  constructor(private userService: UserServiceService,
              private router: Router) { }

  ngOnInit() {
  }

  newTutorial(): void {
    this.submitted = false;
    this.user = new User();
  }

  save() {
    this.userService
      .create(this.user).subscribe(data => {
        console.log(data);
        this.user = new User();
        console.log(this.user);
        this.gotoList();
      },
      error => console.log(error));
  }

  onSubmit() {
    this.submitted = true;
    // this.tutorial.published = true;
    this.save();
  }

  gotoList() {
    this.router.navigate(['/student']);
  }

}
