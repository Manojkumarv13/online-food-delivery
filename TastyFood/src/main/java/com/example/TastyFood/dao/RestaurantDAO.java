package com.example.TastyFood.dao;
import java.io.IOException;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import com.example.TastyFood.entity.Restaurant;
import com.example.TastyFood.form.RestaurantForm;
import com.example.TastyFood.model.RestaurantInfo;
import com.example.TastyFood.pagination.PaginationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class RestaurantDAO {
	@Autowired
    private SessionFactory sessionFactory;

    public Restaurant findRestaurant(String resid) {
        try {
            String sql = "Select e from " + Restaurant.class.getName() + " e Where e.resid =:resid ";

            Session session = this.sessionFactory.getCurrentSession();
            Query<Restaurant> query = session.createQuery(sql, Restaurant.class);
            query.setParameter("resid", resid);
            return (Restaurant) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public RestaurantInfo findRestaurantInfo(String resid) {
        Restaurant restaurant = this.findRestaurant(resid);
        if (restaurant == null) {
            return null;
        }
        return new RestaurantInfo(restaurant.getResid(), restaurant.getName(), restaurant.getAddress());
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void save(RestaurantForm restaurantForm) {

        Session session = this.sessionFactory.getCurrentSession();
        String resid = restaurantForm.getResid();

        Restaurant restaurant = null;

        boolean isNew = false;
        if (resid != null) {
            restaurant = this.findRestaurant(resid);
        }
        if (restaurant == null) {
            isNew = true;
            restaurant = new Restaurant();
        }
        restaurant.setResid(resid);
        restaurant.setName(restaurantForm.getName());
        restaurant.setAddress(restaurantForm.getAddress());

        if (restaurantForm.getFileData() != null) {
            byte[] image = null;
            try {
                image = restaurantForm.getFileData().getBytes();
            } catch (IOException e) {
            }
            if (image != null && image.length > 0) {
                restaurant.setImage(image);
            }
        }
        if (isNew) {
            session.persist(restaurant);
        }
        // If error in DB, Exceptions will be thrown out immediately
        session.flush();
    }

    public PaginationResult<RestaurantInfo> queryRestaurants(int page, int maxResult, int maxNavigationPage,
            String likeName) {
        String sql = "Select new " + RestaurantInfo.class.getName() //
                + "(p.resid, p.name, p.address) " + " from "//
                + Restaurant.class.getName() + " p ";
        if (likeName != null && likeName.length() > 0) {
            sql += " Where lower(p.name) like :likeName ";
        } 
        Session session = this.sessionFactory.getCurrentSession();
        Query<RestaurantInfo> query = session.createQuery(sql, RestaurantInfo.class);

        if (likeName != null && likeName.length() > 0) {
            query.setParameter("likeName", "%" + likeName.toLowerCase() + "%");
        }
        return new PaginationResult<RestaurantInfo>(query, page, maxResult, maxNavigationPage);
    }

    public PaginationResult<RestaurantInfo> queryRestaurants(int page, int maxResult, int maxNavigationPage) {
        return queryRestaurants(page, maxResult, maxNavigationPage, null);
    } 
}
