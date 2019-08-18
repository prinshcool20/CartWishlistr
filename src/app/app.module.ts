import { NgModule }      from '@angular/core';
import {FormsModule} from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent }  from './app.component';
import { ShowComponent } from './showProduct';
import {HttpClientModule} from '@angular/common/http';
import {Router, RouterModule, Routes} from '@angular/router';
import {ShowWishlist} from './app.wishlist'
import {ShowCart} from './app.cart'
//import { Main } from './main';

const routes:Routes=[{path:'',redirectTo:'show',pathMatch:'full'},
 {path:'show',component:ShowComponent},
{path:'wishlist',component:ShowWishlist},
{path:'showcart',component:ShowCart}];

@NgModule({
    imports: [
        BrowserModule,HttpClientModule,RouterModule.forRoot(routes),FormsModule
        
    ],
    declarations: [
        AppComponent,ShowComponent,ShowWishlist,ShowCart
		],
    providers: [ ],
    bootstrap: [AppComponent]
})

export class AppModule { }