import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { UserService } from 'src/app/shared/services/user/user.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  constructor(
    private userService: UserService,
    private router: Router
  ) { }

  public canActivate() {
    if (!this.userService.verificiarSesion()) {
      return true;
    } else {
      this.router.navigate(['home']);
      return false;
    }
  }
  
}
