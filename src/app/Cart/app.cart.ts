import { Component,OnInit} from "@angular/core";
import {ProductService} from '../productService';
import {Product} from '../models/Product';
import {Observable} from 'rxjs';
import { PathLocationStrategy } from "@angular/common";
@Component({
    selector:'show-cart',
    templateUrl:'app.cart.html'
})

export class ShowCart implements OnInit{

    constructor(private service:ProductService){}
    products:Product[];
    quantity:number=1;
    product:Product;
    
      
    
    ngOnInit(): void {
       this.service.displayCart().subscribe(data=>this.products=data);     
    }

    removeFromCart(index:number){
        let productId = this.products[index].productID
        this.service.deleteFromCart(productId)
        window.location.reload();
    }
    placeOrder(){
        let amount:any=0;
        for(let amt of this.products){
            amount=amount+amt.price;
            }
            console.log(amount);
            
            if(amount>1000){
                let  order:number[]=[]
                for(let data of this.products){
                    order.push(data.productID)
                }
               
                this.service.placeorder(order);

                }else{
                alert("Cart value should be more then 10000");
                console.log("hello");
                
            }

        }
   }
