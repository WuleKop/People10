import { Customer } from './../customer';
import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {
  customers:Customer[];
  displayedColumns: string[] = ['id', 'first_name', 'last_name','email','longitude',
  'latitude','ip','created_at','updated_at','update','delete']; 

  constructor(private customerService:CustomerService) { }

  ngOnInit() {
    this.customerService.getAllCustomers().subscribe(data =>
      {this.customers=data});
  }

}
