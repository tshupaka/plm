import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/model/user.model';
import { UserService } from 'src/app/service/user.service';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'plm-user-parameter',
  templateUrl: './user-parameter.component.html',
  styleUrls: ['./user-parameter.component.css']
})
export class UserParameterComponent implements OnInit {

  users: User[];
  currentUser: User;
  errorMessage: string;
  saving = false;

  constructor(private userService: UserService, private router: Router ) { }

  ngOnInit() {
    this.userService.getAllUsers().subscribe(users => { console.log(users); this.users = users; });
  }

  addUser() {
    this.currentUser = new User();
  }

  goBack() {
    this.router.navigate(['dashboard/parameters/home']);
  }

  cancel() {
    this.currentUser = undefined;
  }

  saveUser(form: NgForm) {
    if (form.valid) {
      this.saving = true;
      this.userService.saveUser(this.currentUser).subscribe(
        users => { this.users = users; this.saving = false; this.currentUser = undefined; },
        errorMessage => { this.errorMessage = errorMessage; this.saving = false; }).delay(5000).then(this.errorMessage = undefined);
    }
  }

  updateUser(user: User) {
    this.currentUser = user;
  }

  deleteUser(user: User) {
    if (confirm('Etes-vous sûr de vouloir supprimer l\'utilisateur ' + user.firstname + ' ' + user.lastname)) {
      this.userService.deleteUser(user).subscribe(users => { this.users = users; });
    }
  }
}
