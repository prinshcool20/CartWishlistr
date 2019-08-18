package com.cg.bean;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cg.bean.Merchant;

@Entity
//Table
@Table(name="product")
public class Product {
	//Unique Identifier
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer productID;
	
	@Column
	private String productName;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Merchant.merchantId")
	private Merchant merchant;
	
	@ElementCollection
	private List<String> tag;
	
	@Column 
	private String company;
	
	@Column
	private String photo;
	
	@Column 
	private String description;
	
	@Column(length=5)
	private Integer quantity;
	
	@Column
	private String category;
	
	@Column
	private String subcategory;
	
	@Column
	private Integer soldQuantities;
	
	@Column
	private Double price;
	
	
	private Date releaseDate;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(Integer productID, String productName, Merchant merchant, List<String> tag, String company,
			String photo, String description, Integer quantity, String category, String subcategory,
			Integer soldQuantities, Double price, Date releaseDate) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.merchant = merchant;
		this.tag = tag;
		this.company = company;
		this.photo = photo;
		this.description = description;
		this.quantity = quantity;
		this.category = category;
		this.subcategory = subcategory;
		this.soldQuantities = soldQuantities;
		this.price = price;
		this.releaseDate = releaseDate;
	}

	public Integer getProductID() {
		return productID;
	}

	public void setProductID(Integer productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Merchant getMerchant() {
		return merchant;
	}

	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}

	public List<String> getTag() {
		return tag;
	}

	public void setTag(List<String> tag) {
		this.tag = tag;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}

	public Integer getSoldQuantities() {
		return soldQuantities;
	}

	public void setSoldQuantities(Integer soldQuantities) {
		this.soldQuantities = soldQuantities;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}	

	

}
