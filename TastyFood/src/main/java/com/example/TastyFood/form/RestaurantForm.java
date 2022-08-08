package com.example.TastyFood.form;
import com.example.TastyFood.entity.Restaurant;
import org.springframework.web.multipart.MultipartFile;
public class RestaurantForm {
	 private String resid;
	    private String name;
	    private String address;

	    private boolean newRestaurant = false;

	    // Upload file.
	    private MultipartFile fileData;

	    public RestaurantForm() {
	        this.newRestaurant= true;
	    }

	    public RestaurantForm(Restaurant restaurant) {
	        this.resid = restaurant.getResid();
	        this.name = restaurant.getName();
	        this.address = restaurant.getAddress();
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

	    public MultipartFile getFileData() {
	        return fileData;
	    }

	    public void setFileData(MultipartFile fileData) {
	        this.fileData = fileData;
	    }

	    public boolean isNewRestaurant() {
	        return newRestaurant;
	    }

	    public void setNewRestaurant(boolean newRestaurant) {
	        this.newRestaurant = newRestaurant;
	    }
}
