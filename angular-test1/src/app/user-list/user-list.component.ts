import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { User } from '../user';
import { UserServiceService } from '../user-service.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {
  user: Observable<User[]>;

  constructor(private userService: UserServiceService, private router: Router) { }

  ngOnInit(): void {
    console.log('Tutorial list');
    this.reloadData();
  }

  reloadData(){
    this.user = this.userService.getAll();
    console.log(this.user);
  }

  deleteTutorial(id: string) {
    this.userService.delete(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  tutorialDetails(id: string){
    this.router.navigate(['details', id]);
  }

  updateTutorial(id: string){
    this.router.navigate(['update', id]);
  }
}
