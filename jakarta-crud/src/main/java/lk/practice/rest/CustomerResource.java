package lk.practice.rest;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path("/customer")
public class CustomerResource {
    private static List<Customer> customers = new ArrayList<>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> getAllCustomers() {
//        return customers;

        // Print the customer list to the IntelliJ terminal
        System.out.println("Fetching all customers:");
        customers.forEach(System.out::println);
        return customers;

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addCustomer(Customer customer) {
        customers.add(customer);
//        return Response.status(Response.Status.CREATED).entity(customer).build();

        // Log the new customer to the IntelliJ terminal
        System.out.println("Added new customer: " + customer);
        return Response.status(Response.Status.CREATED).entity(customer).build();

    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateCustomer(@PathParam("id") int id, Customer updatedCustomer) {
        Customer existingCustomer = customers.get(id);
        if (existingCustomer == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        customers.set(id, updatedCustomer);
//        return Response.status(Response.Status.OK).build();

        // Log the updated customer to the IntelliJ terminal
        System.out.println("Updated customer with ID " + id + ": " + updatedCustomer);
        return Response.ok(updatedCustomer).build();

    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteCustomer(@PathParam("id") int id) {
        if(id < 0 || id >= customers.size()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        customers.remove(id);
//        return Response.ok("Customer removed successfully..!").build();

        // Log the deleted customer to the IntelliJ terminal
        Customer removedCustomer = customers.remove(id);
        System.out.println("Deleted customer: " + removedCustomer);
        return Response.ok("Customer removed successfully").build();

    }

}
