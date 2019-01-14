package es.jander.launchpad.spring4jersey.api;

import es.jander.launchpad.spring4jersey.data.Outcome;
import es.jander.launchpad.spring4jersey.etc.AppSettings;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("basic")
public class BasicController {

  private @Autowired AppSettings settings;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response get() {
    Outcome data = Outcome.builder()
      .message("GET / response")
      .successful(true)
      .build();
    return Response.ok(data).build();
  }

  @GET
  @Path("name")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getName() {
    Outcome data = Outcome.builder()
      .message("GET /name response")
      .successful(true)
      .content(settings.getAppName())
      .build();
    return Response.ok(data).build();
  }

  @GET
  @Path("source")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getSource() {
    Outcome data = Outcome.builder()
      .message("GET /source response")
      .successful(true)
      .content(settings.getSource())
      .build();
    return Response.ok(data).build();
  }
}
