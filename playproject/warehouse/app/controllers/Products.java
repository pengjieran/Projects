package controllers;

import java.util.List;

import models.Product;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.products.details;
import views.html.products.list;

public class Products extends Controller {
	
	private static final Form<Product> productForm = Form.form(Product.class);
	
	public static Result newProduct() {
		
		return ok(details.render(productForm));
	}
	
	public static Result list() {
		
		List<Product> products = Product.findAll();
		
		return ok(list.render(products));
	}
	
	public static Result save() {
		
		Form<Product> boundForm = productForm.bindFromRequest();
		Product product = boundForm.get();
		
		product.save();
		
		return redirect(routes.Products.list());
	}
	
	public static Result detail(String ean) {
		
		final Product product = Product.findByEan(ean);
		if (null == product) {
			
			return notFound(String.format("product %s does not exit.", ean));
		}
		
		Form<Product> fileForm = productForm.fill(product);
		return ok(details.render(fileForm));
		
	}
	
	public static Result delete(String ean) {
		
		final Product product = Product.findByEan(ean);
		
		if (null == product)
		{
			
			return notFound(String.format("product %s does not exit", ean));
		}
		
		Product.remove(product);
		return redirect(routes.Products.list());
		
	}
}