package models;

import java.util.ArrayList;
import java.util.List;

public class Product {
	
	public String ean;
	
	public String name;
	
	public String description;
	
	public Product() {}
	
	public Product(String ean, String name, String description) {
		
		this.ean = ean;
		this.name = name;
		this.description = description;
	}
	
	public String toString() {
		
		return String.format("%s - %s", ean, name);
	}
	
	private static List<Product> products;
	
	static {
		
		products = new ArrayList<Product>();
		products.add(new Product("11111111111", "product1", "product description1"));
		products.add(new Product("22222222222", "product2", "product description2"));
		products.add(new Product("33333333333", "product3", "product description3"));
		products.add(new Product("44444444444", "product4", "product description4"));
		products.add(new Product("55555555555", "product5", "product description5"));
	}
	
	public static List<Product> findAll() {
		
		return new ArrayList<Product>(products);
	}
	
	public static Product findByEan(String ean) {
		
		for (Product candidate : products) {
			
			if (candidate.ean.equals(ean)) {
				
				return candidate;
			}
		}
		
		return null;
	}
	
	public static List<Product> findByName(String term) {
		final List<Product> results = new ArrayList<Product>();
		for (Product candidate : products) {
		if (candidate.name.toLowerCase().contains(term.toLowerCase())) {
		results.add(candidate);
		}
		}
		return results;
		}
		public static boolean remove(Product product) {
		return products.remove(product);
		}
		public void save() {
		products.remove(findByEan(this.ean));
		products.add(this);
		}
}