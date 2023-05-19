package br.com.api.controller;

import br.com.api.entity.Product;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

@ApplicationScoped
public class ProductController {

    public Product update(Long id, Product produto) {
       Produto productEntity = Product.findById(id);

        if (productEntity == null) {
            throw new WebApplicationException("produco com esse id " + id + " não existe.", Response.Status.NOT_FOUND);
        }

        productEntity.setName(product.getName());
      

        return productEntity;
    }

    
    public boolean isprodutcNameIsNotEmpty(Product produto) {
        return product.getName().isEmpty();
    }
}
