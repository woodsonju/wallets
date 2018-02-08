
import {PricingService} from "../pricing.service";
export class Line{
    constructor(public symbol: string, public quantity: number){
    }
}

export class Wallet{
   lines : Line[] = [];
   pricingService: PricingService;

   deposit(dollars: number){
      let usdLine = this.lines.find(line => line.symbol ==='USD');
      if(usdLine=== undefined)
      {
        this.lines.push(new Line('USD', dollars))
      }
      else
      {
        usdLine.quantity += dollars;
      }

   }


   buy(quantity:number, symbol: string) {
     let usdLine = this.lines
       .find(line => line.symbol === 'USD');

     let symbolPrice = this.pricingService.priceToDollar(quantity, symbol);
     usdLine.quantity = usdLine.quantity - symbolPrice;

     let symbolLine = this.lines.find(line => line.symbol === symbol);


     if (symbolLine === undefined) {
       this.lines.push(new Line(symbol, quantity));
     }
     else {
       symbolLine.quantity += quantity;
     }
   }

   totalDollarValue(): number{
     let total = 0;
     for(let i = 0; i < this.lines.length; i++)
     {
       let line = this.lines[i];
       if(line.symbol === 'USD')
       {
         total += line.quantity;
       }
       else
       {
         total += this.pricingService.priceToDollar(line.quantity, line.symbol);
       }
     }
     return total;
   }

  sell(quantity:number, symbol: string) {

    let usdLine = this.lines.find(line => line.symbol === 'USD');
    let symbolLine = this.lines.find(line => line.symbol === symbol);

    let symbolPrice = this.pricingService.priceToDollar( quantity, symbol);

    if (symbolLine === undefined) {
      this.lines.push(new Line(symbol, quantity));
    }
    else if(symbolLine.quantity > 0){
      symbolLine.quantity -= quantity;
      usdLine.quantity = usdLine.quantity + symbolPrice;
    }
  }

}





/*getLinesOrderByValue()
{

}
*/
