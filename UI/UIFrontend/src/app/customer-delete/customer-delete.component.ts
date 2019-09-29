import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-customer-delete',
  templateUrl: './customer-delete.component.html',
  styleUrls: ['./customer-delete.component.css']
})
export class CustomerDeleteComponent implements OnInit {

  id:number;
  submitted = false;

  constructor(private route: ActivatedRoute,private customerService:CustomerService) { }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.id = params.id; })
  }
  deleteCustomer(){
    this.customerService.deleteCustomer(this.id).subscribe();
    this.submitted=true;
  }

}
