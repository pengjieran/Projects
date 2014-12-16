package controllers;

import java.util.List;

import models.Product;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.products.list;

public class Products extends Controller {
	
	private static final Form<Product> productForm = Form.form(Product.class);
	
	public static Result index() {
		
		return TODO;
	}
	
	public static Result newProduct() {
		
		return ok(details.render(productForm));
	}
	
	public static Result list() {
		
		List<Product> products = Product.findAll();
		
		return ok(list.render(products));
	}
	
	public static Result add() {
		
		return TODO;
	}
	
	public static Result save() {
		
		return TODO;
	}
	
	public static Result detail(String ean) {
		
		return TODO;
	}
	
	public static Result delete() {
		
		return TODO;
	}

}