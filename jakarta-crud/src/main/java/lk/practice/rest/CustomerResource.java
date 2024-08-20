package lk.practice.rest;

import jakarta.ws.rs.Path;

import java.util.ArrayList;
import java.util.List;

@Path("/customer")
public class CustomerResource {

    private static List<Customer> customers = new ArrayList<>();

}
