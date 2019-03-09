import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AuthenticationService } from '../service/authentication.service';
import { User } from '../model/user.model';
import { Router } from '@angular/router';

@Component({
  selector: 'plm-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  email: string;
  password: string;
  remember: boolean;
  errorMessage: String;

  constructor(private authenticationService: AuthenticationService, private router: Router) { }

  ngOnInit() {
  }

  login(form: NgForm) {
    if (form.valid) {
      this.authenticationService.login(this.email, this.password, this.remember).subscribe((user: User) => {
        this.router.navigate(['dashboard/home']);
      }, (error) => { this.errorMessage = error; });

    }
  }
}
