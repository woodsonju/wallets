import { Injectable } from '@angular/core';
import {BunService} from "./bun.service";
import {SteackService} from "./steack.service";

@Injectable()
export class BurgerService {

  constructor(public bunService: BunService,
              public steackService: SteackService) {

  }

  getPrice(){
    return 10;
  }

}


