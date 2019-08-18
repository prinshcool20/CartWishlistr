import { Component,OnInit} from "@angular/core";
import {ProductService} from './productService';
import {Product} from './models/Product';
import {Observable} from 'rxjs';

@Component({
    selector:'show-wishlist',
    templateUrl:'app.wishlist.html'
})

export class ShowWishlist implements OnInit{

    constructor(private service:ProductService){}
    products: Observable<Product[]>;

    product:Product;
    
    ngOnInit(): void {
       this.service.displayWishlist().subscribe( res=>{
        this.products=res

     },
     err=>{
         alert("an error has occurred")
     })     
    }
    addToCart(index:number){
       let productId = this.products[index].productID;
         this.service.addCart(productId);
    }
    removeFromWishlist(index:number){
        let productId = this.products[index].productID
        
    this.service.deleteFromWishlist(productId)
    window.location.reload();
    }
   
   
} 