import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Customer } from '../customer';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-customer-search',
  templateUrl: './customer-search.component.html',
  styleUrls: ['./customer-search.component.css']
})
export class CustomerSearchComponent implements OnInit {

  searchOptions: string[] = ['id','First Name', 'Last Name','Email'];
  searchControl=new FormControl();
  paramControl=new FormControl();
  displayedColumns: string[] = ['id', 'first_name', 'last_name','email','longitude',
  'latitude','ip','created_at','updated_at','update','delete']; 
  
  customers : Customer[];
  filterdCustomers : Customer[];
  param:string;

  constructor(private cusomerService:CustomerService) { }

  ngOnInit() {
    this.cusomerService.getAllCustomers().subscribe(data =>
      this.customers=data);      
  }
  getMatchingCustomers(){
    this.param=this.paramControl.value;
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
