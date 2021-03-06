import { Injectable } from '@angular/core';
import { Router, CanActivate } from '@angular/router';
import {SignInService} from '../services/sign-in-service/sign-in.service';

@Injectable({
  providedIn: 'root'
})
export class SignInGuard implements CanActivate {

  constructor(
    public auth: SignInService,
    public router: Router
  ) { }

  canActivate(): boolean {
    const role = this.auth.getRole();
    if (role === 'ROLE_POVERENIK') {
      this.router.navigate(['/pocetna-stranica-poverenik']);
      return false;
    } else if (role === 'ROLE_USER') {
      this.router.navigate(['/pocetna-stranica-gradjanin']);
      return false;
    }
    return true;
  }
}
