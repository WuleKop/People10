import { Component, OnInit } from '@angular/core';
import { Customer } from '../customer';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-customer-add',
  templateUrl: './customer-add.component.html',
  styleUrls: ['./customer-add.component.css']
})
export class CustomerAddComponent implements OnInit {
  
  customer:Customer = new Customer();
  submitted = false;

  constructor(private customerService:CustomerService) { }

  ngOnInit() {
  }
  addCustomer() {      
    this.customerService.addCustomer(this.customer).subscribe();
    this.submitted = true;
  }


}
