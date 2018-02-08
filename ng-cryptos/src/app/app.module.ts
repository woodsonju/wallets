import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { AttributesComponent } from './demos/attributes/attributes.component';
import { WalletViewComponent } from './wallet-view/wallet-view.component';
import { TemplateComponent } from './demos/template/template.component';
import {BurgerService} from "./demos/burger.service";
import {SteackService} from "./demos/steack.service";
import {BunService} from "./demos/bun.service";
import {HttpClientModule} from "@angular/common/http";
import {PricingService} from "./pricing.service";
import { FormsComponent } from './demos/forms/forms.component';
import {FormsModule} from "@angular/forms";


@NgModule({
  imports: [
    BrowserModule, HttpClientModule, FormsModule
  ],
  declarations: [
    AppComponent,
    AttributesComponent,
    WalletViewComponent,
    TemplateComponent,
    FormsComponent
  ],
  providers: [
    PricingService,
    BurgerService, SteackService, BunService],
  bootstrap: [AppComponent]
})
export class AppModule { }
