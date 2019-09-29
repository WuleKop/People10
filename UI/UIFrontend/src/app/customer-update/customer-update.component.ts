import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../customer.service';
import { ActivatedRoute } from '@angular/router';
import { Customer } from '../customer';

@Component({
  selector: 'app-customer-update',
  templateUrl: './customer-update.component.html',
  styleUrls: ['./customer-update.component.css']
})
export class CustomerUpdateComponent implements OnInit {

  id:number;
  customer:Customer = new Customer();
  submitted = false;

  constructor(private route: ActivatedRoute,private customerService:CustomerService) { }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.id = params.id; })
    this.customerService.getCustomerById(this.id).subscribe(data=>
      this.customer=data);
    } 
    updateCustomer() {      
      this.customerService.updateCustomer(this.customer).subscribe();
      this.submitted = true;
    }

}
