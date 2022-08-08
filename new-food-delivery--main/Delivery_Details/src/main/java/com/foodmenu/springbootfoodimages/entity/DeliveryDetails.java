package com.foodmenu.springbootfoodimages.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "delivery_details")
public class DeliveryDetails {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customername", nullable = false)
	private String customername;

	@Column(name = "purchasefooditem", nullable = false)
	private String purchasefooditem;

	@Column(name = "address", nullable = false)
	private String address;

	@Column(name = "deliveryperson", nullable = false)
	private String deliveryperson;

	@Column(name = "price", nullable = false, precision = 10, scale = 2)
	private double price;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "deliverydate", nullable = false)
	private Date deliverydate;
	
	public DeliveryDetails() {}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getPurchasefooditem() {
		return purchasefooditem;
	}

	public void setPurchasefooditem(String purchasefooditem) {
		this.purchasefooditem = purchasefooditem;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDeliveryperson() {
		return deliveryperson;
	}

	public void setDeliveryperson(String deliveryperson) {
		this.deliveryperson = deliveryperson;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getDeliverydate() {
		return deliverydate;
	}

	public void setDeliverydate(Date deliverydate) {
		this.deliverydate = deliverydate;
	}

	@Override
	public String toString() {
		return "Product [customername=" + customername + ", purchasefooditem=" + purchasefooditem + ", address="
				+ address + ", price=" + price + ",deliveryperson =" + deliveryperson + ", deliverydate=" + deliverydate
				+ "]";
	}

}
