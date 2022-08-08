package com.example.TastyFood.model;
import com.example.TastyFood.entity.Restaurant;
public class RestaurantInfo {
	 private String resid;
	    private String name;
	    private String address;

	    public RestaurantInfo() {
	    }

	    public RestaurantInfo(Restaurant restaurant) {
	        this.resid = restaurant.getResid();
	        this.name = restaurant.getName();
	        this.address = restaurant.getAddress();
	    }

	    // Using in JPA/Hibernate query
	    public RestaurantInfo(String resid, String name, String address) {
	        this.resid = resid;
	        this.name = name;
	        this.address = address;
	    }

	    public String getResid() {
	        return resid;
	    }

	    public void setResid(String resid) {
	        this.resid = resid;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getAddress() {
	        return address;
	    }

	    public void setAddress(String address) {
	        this.address = address;
	    }
}
