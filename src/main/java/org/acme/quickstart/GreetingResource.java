package org.acme.quickstart;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.stream.Collectors;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    private static final String SPACE = " ";

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@Context final HttpHeaders httpHeaders) {
        LocalDate date = LocalDate.now();
        LocalTime now = LocalTime.now();
        return date + SPACE + now + SPACE + httpHeaders.getRequestHeaders().entrySet().stream().
            map(entry -> entry.getKey() + " - " + entry.getValue())
            .collect(Collectors.joining(", "));
    }
}