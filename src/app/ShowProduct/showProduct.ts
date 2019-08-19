    
import { Component,} from "@angular/core";
import {ProductService} from '../productService';
import {Product} from '../models/Product';
import {Router, RouterModule, Routes} from '@angular/router';

@Component({
    selector:'show-product',
    templateUrl:'showproduct.html'
})

export class ShowComponent {
    constructor(private service:ProductService, private router:Router){}
    products:Product[]=[];

    product:Product;
   
    ngOnInit(): void {
       // throw new Error("Method not implemented.");
        this.service.findproduct().subscribe(
            res=>{
               this.product=res

            },
            err=>{
                alert("an error has occurred")
            }
        )
        
        //this.finddata();
       } 

       addToWishlist(){
        this.service.addWishList(this.product.productID);
       }
       addToCart(){
          // this.service.addCart(this.product.productID);
       }

       showWishlist(){
           console.log("wishlist clicked");
           
           this.router.navigate(['wishlist']);
       }
       showCart(){
        console.log("cart clicked");
           
        this.router.navigate(['showcart']);
       }


    
    
}