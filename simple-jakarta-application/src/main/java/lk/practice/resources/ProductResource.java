package lk.practice.resources;

import lk.practice.model.Product;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

@Path("/products")
public class ProductResource {

    // Temporary storage for demonstration purposes
    private static Map<String, Product> products = new HashMap<>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllProducts() {
        // Retrieve and return all products
        return Response.ok(products.values()).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProduct(@PathParam("id") String id) {
        Product product = products.get(id);
        if (product != null) {
            return Response.ok(product).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createProduct(Product product) {
        if (product.getId() == null || product.getId().isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        products.put(product.getId(), product);
        return Response.status(Response.Status.CREATED).entity(product).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateProduct(@PathParam("id") String id, Product product) {
        if (!products.containsKey(id)) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        product.setId(id);
        products.put(id, product);
        return Response.ok(product).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteProduct(@PathParam("id") String id) {
        if (products.remove(id) != null) {
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
