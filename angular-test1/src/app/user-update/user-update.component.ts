import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../user';
import { UserServiceService } from '../user-service.service';

@Component({
  selector: 'app-user-update',
  templateUrl: './user-update.component.html',
  styleUrls: ['./user-update.component.css']
})
export class UserUpdateComponent implements OnInit {

  id: string;
  user: User;

  constructor(private route: ActivatedRoute, private router: Router,
              private userService: UserServiceService) { }

  ngOnInit() {
    this.user = new User();

    this.id = this.route.snapshot.params['id'];

    this.userService.get(this.id)
      .subscribe(data => {
        console.log(data);
        this.user = data;
      }, error => console.log(error));
  }

  updateTutorial(){
    // this.tutorial = new Tutorial();
    // this.id = this.route.snapshot.params['id'];
    this.userService.update(this.id, this.user).subscribe(
      data => {
        console.log(data);
        this.user = new User();
        this.list();
      }, error => console.log(error)
    );
  }

  onSubmit(){
    this.updateTutorial();
  }

  list(){
    this.router.navigate(['tutorials']);
  }

}
