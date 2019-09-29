import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Customer } from './customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  private uri = 'http://localhost:8080/api/customers/';

  constructor(private http:HttpClient) { }

  getAllCustomers():Observable<Customer[]> {
    return this.http.get<Customer[]>(this.uri);
  }
  getCustomerById(id:number):Observable<Customer> {
    return this.http.get<Customer>(this.uri+id);

  }
  addCustomer(customer:Customer):Observable<any> {
    return this.http.post<any>(this.uri,customer);
  }
  updateCustomer(customer:Customer):Observable<any> {
    return this.http.put<any>(this.uri,customer);
  }
  deleteCustomer(id:number):Observable<any> {
    return this.http.delete<any>(this.uri+id);

  }

}
