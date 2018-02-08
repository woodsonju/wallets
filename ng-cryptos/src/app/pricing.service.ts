import {Injectable} from '@angular/core';
import {Coin} from "./model/coins";
import {HttpClient} from "@angular/common/http";

@Injectable()
export class PricingService {

  //Asynchrone
  coins: Coin[];

  constructor(public http: HttpClient) {

  }

  getColor(symbol){

    if(symbol==='USD'){
      return 'black';
    }


    let coin = this.coins.find(coin => coin.symbol ===symbol);

    if(coin.up === true)
    {
      return 'green';
    }
    else
    {
      return 'red';
    }

  }

  loadPrices() {
    let url = 'https://api.coinmarketcap.com/v1/ticker/?limit=10';

    function mapper(coin) {
      let isUp;
      if (coin.percent_change_24h > 0) {
          isUp = true;
      }
      else
      {
          isUp = false;
      }

      return {
        name: coin.name,
        symbol: coin.symbol,
        price: coin.price_usd,
        up: isUp

      }
    }


    return this.http.get(url)
      .toPromise()
      .then(internetCoins => (internetCoins as any).map(mapper))
      .then(joliCoins => {
        this.coins = joliCoins;
        return joliCoins;

      });
    //Ctrl +Alt+ L
  }

  priceToDollar(quantity, symbol) {
    for (let i = 0; i < this.coins.length; i++) {
      let coin = this.coins[i];
      if (coin.symbol === symbol) {
        console.log('I do have', coin);
        return coin.price * quantity;
      }

    }
    throw symbol + ' not found';
  }


}
