import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import {Observable} from 'rxjs';
import {Product} from './models/Product';
//import { identifierModuleUrl } from "@angular/compiler";

let baseUrl = "http://localhost:9090/products";

@Injectable({
    providedIn:'root'
})

export class ProductService{
    constructor(private http:HttpClient){}
    //id: number=8;

    

    getproduct()
    {       
          return this.http.get<Product[]>(baseUrl+"/get");
    }
    findproduct(){
        let options = { "headers": 
        new HttpHeaders({"Content-Type": "application/json" }) };
        return this.http.get<Product>(baseUrl+"/"+22,options);

    }
  
    addWishList(productId:any){
       let object={
            "userId":"2",
            "productId":productId
            }
     console.log(`${baseUrl}`+`/new`);
     
            return this.http.post(baseUrl +"/newwishlist",object ).subscribe(data=>{console.log(data)});
          
    }
    displayWishlist():Observable<any>{
        let object={
            "userId":"2"
         }
        return this.http.post<Product>(baseUrl +"/getWishlist",object);
    }
    deleteFromWishlist(productId:any){
        console.log("delete"+productId);
        
        let object={
            "userId":"2",
            "productId":productId
            }
            return this.http.post(baseUrl +"/remove",object).subscribe(data=>{console.log(data)});
    }

    addCart(productId:any){        
        let object1={
            "userId":"1",
            "productId":productId
            }     
            return this.http.post(baseUrl +"/NewCart",object1 ).subscribe(data=>{console.log(data)})
            }

    displayCart():Observable<any>{
        let object={
            "userId":"2"
         }
        return this.http.post<Product>(baseUrl +"/getCart",object);
    }
    deleteFromCart(productId:any){
        console.log("deleteCart"+productId);
        
        let object={
            "userId":"1",
            "productId":productId
            }
            return this.http.post(baseUrl +"/removeCart",object).subscribe(data=>{console.log(data)});
    }
placeorder(order:any){
console.log(order);

}
 

    
}