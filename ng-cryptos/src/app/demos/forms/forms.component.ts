import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-forms',
  templateUrl: './forms.component.html',
  styleUrls: ['./forms.component.css']
})
export class FormsComponent implements OnInit {
   formModel = {
     name : '',
     limit: 9000,
     level : 'Noob'
   };

   levels = ['Noob', 'Expert', 'Master']

  constructor() { }

  ngOnInit() {
  }

  createNewWallet(){
console.log(this.formModel);
  }

  isDisabled()
  {
    return this.formModel.name === '';
  }
}
