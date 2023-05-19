package br.com.api.resource;

import br.com.api.controller.ProductResource;
import br.com.api.entity.Product;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/product")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {

    @Inject
    private ProductController productController;

    @GET
    public List<Product> findAll() {
        return Product.listAll();
    }

    @POST
    @Transactional
    public Response create(Product product) {
        Product.persist();
        return Response.ok(product).status(201).build();
    }

    @PUT
    @Path("{id}")
    @Transactional
    public Response update(@PathParam("id") Long id, Food food) {

        if (productController.isFoodNameIsNotEmpty(food)) {
            return Response.ok("Food was not found").type(MediaType.APPLICATION_JSON_TYPE).build();
        }

        Product productEntity = productController.update(id, food);

        return Response.ok(foodEntity).build();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        Food foodEntity = Food.findById(id);

        if (foodEntity == null) {
            throw new WebApplicationException("Food with id " + id + " does not exist.", Response.Status.NOT_FOUND);
        }

        foodEntity.delete();
        return Response.status(204).build();
    }
}