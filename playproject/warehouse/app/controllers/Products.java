package controllers;

import java.util.List;

import models.Product;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.products.list;
import views.html.products.details;

public class Products extends Controller {
	
	private static final Form<Product> productForm = Form.form(Product.class);
	
	public static Result newProduct() {
		
		return ok(details.render(productForm));
	}
	
	public static Result list() {
		
		List<Product> products = Product.findAll();
		
		return ok(list.render(products));
	}
	
	public static Result add() {
		
		return ok();
	}
	
	public static Result save() {
		
		Form<Product> boundForm = productForm.bindFromRequest();
		Product product = boundForm.get();
		
		product.save();
		
		return redirect(routes.Products.list());
	}
	
	public static Result detail(String ean) {
		
		return TODO;
	}
	
	public static Result delete() {
		
		return TODO;
	}

}