package com.siddi.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.siddi.shoppingbackend.dao.ProductDAO;
import com.siddi.shoppingbackend.dto.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Product get(int productId) {
		
		try {
			return sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(productId));
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Product> list() {
		
		try {
			return sessionFactory.getCurrentSession().createQuery("FROM Product", Product.class).getResultList();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
		
	}

	@Override
	public boolean add(Product product) {
		
		try {
			sessionFactory.getCurrentSession().persist(product);
			return true;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean update(Product product) {
		
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
			
		}
		
	}

	@Override
	public boolean delete(Product product) {
		
		try {
			product.setIs_active(false);
			sessionFactory.getCurrentSession().update(product);
			return true;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
		
	}

	@Override
	public List<Product> listActiveProducts() {
		
		String activeProducts = "FROM Product WHERE is_active = :active";
		return sessionFactory.getCurrentSession().createQuery(activeProducts, Product.class).setParameter("active", true).getResultList();
	
	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		
		String activeProductsByCat = "FROM Product WHERE is_active = :active AND categoryId = :categoryId";
		return sessionFactory.getCurrentSession().createQuery(activeProductsByCat, Product.class).setParameter("active", true).setParameter("categoryId", categoryId).getResultList();
		
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		
		String latestActiveProducts = "FROM Product WHERE is_active = :active ORDER BY id";
		return sessionFactory.getCurrentSession().createQuery(latestActiveProducts, Product.class).setParameter("active", true).setFirstResult(0).setMaxResults(count).getResultList();
		
	}

}
