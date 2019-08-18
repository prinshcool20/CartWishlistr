export class Product{
    productID: number;
    productName: string;
  //  merchant: Merchant;
    //tag: string[];
    company: string;
    photo: string;
    description: string;
    quantity: number;
    category: string;
    subcategory: string;
    soldQuantities: number;
    price: number;
    releaseDate: Date;

    constructor(productID,productName,company,photo,description,quantity,category,subcategory,soldQuantities,price,releaseDate){
        this.productID=productID;
        this.productName=productName;
       // this.tag=tag;
        this.company=company;
       this.photo=photo;
        this.description=description;
        this.quantity=quantity;
        this.category=category;
        this.subcategory=subcategory;
        this.soldQuantities=soldQuantities;
        this.price=price;
        this.releaseDate=releaseDate;
    }

}