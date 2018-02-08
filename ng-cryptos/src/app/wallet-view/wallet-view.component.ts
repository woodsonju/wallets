import { Component, OnInit } from '@angular/core';
import {Wallet} from "../model/wallet";
import {PricingService} from "../pricing.service";

@Component({
  selector: 'app-wallet-view',
  templateUrl: './wallet-view.component.html',
  styleUrls: ['./wallet-view.component.css']
})
export class WalletViewComponent implements OnInit {
  wallet = new Wallet();

  constructor(public pricingService: PricingService) {
        this.wallet.pricingService = pricingService;
        pricingService.loadPrices()
          .then( data => console.log(data))
          .then(() => this.initWallet())

  }
  ngOnInit() {
  }

  deposit(value : string){
    console.log("Depositing value:", value);
    let money  = parseFloat(value);
    if(money > 0)
    {
      this.wallet.deposit(money);
      console.log(this.wallet.lines);
    }
    else{
      console.log("Not Money");
    }
  }

  buy(value:string, symbol: string)
  {
    let quantity = parseInt(value);
    this.wallet.buy(quantity, symbol);
  }

  initWallet(){
    this.deposit('1000000');
    this.buy('3', 'BTC');
  }

  sell(value:string, symbol: string)
  {
    debugger;
    let quantity = parseInt(value);
    this.wallet.sell(quantity, symbol);
  }

  updatePrices()
  {

  }

}
