import { Component, OnInit } from '@angular/core';
import { Customer } from '../customer';
import * as customer_json  from '../../assets/customers.json';
import { FormControl } from '@angular/forms';


@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  searchOptions: string[] = ['id','First Name', 'Last Name','Email'];
  searchControl=new FormControl();
  paramControl=new FormControl();
  displayedColumns: string[] = ['id', 'first_name', 'last_name','email','longitude','latitude','ip','created_at','updated_at']; 
  
  customers : Customer[] = customer_json.default;
  filterdCustomers : Customer[];
  param:string;

  constructor() { }

  ngOnInit() {   
      
  }
  getMatchingCustomers(){
    this.param=this.paramControl.value;
    console.log(this.customers.filter(c=>c.first_name=='Joshua'));
    if(this.param=='id') {
      this.filterdCustomers=this.customers.filter(c=>c.id==Number(this.searchControl.value));
    }
    else if(this.param=='First Name') {
      this.filterdCustomers=this.customers.filter(c=>c.first_name==this.searchControl.value);
    }
    else if(this.param=='Last Name') {
      this.filterdCustomers=this.customers.filter(c=>c.last_name==this.searchControl.value);
    }
    else if(this.param=='Email') {
      this.filterdCustomers=this.customers.filter(c=>c.email===this.searchControl.value);
    }   

  }

}
