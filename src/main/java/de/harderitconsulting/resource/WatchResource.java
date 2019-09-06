package de.harderitconsulting.resource;

import de.harderitconsulting.resource.entity.Watch;

import java.util.ArrayList;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


@Path("/watches")
public class WatchResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Watch> getAll() {
        List<Watch> watches = new ArrayList<Watch>();
        watches.add(new Watch(1, "Rolex", "Submariner"));
        watches.add(new Watch(2, "Omega", "Seamaster"));
        watches.add(new Watch(3, "Bulova", "Lunar Pilot"));
        return watches;
    }

    @GET
    @Path("watch/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") int id) {
        //TODO add find logic and return found object
        return Response.ok().entity(new Watch(7, "Hublot", "Big Bang Unico Blue Magic")).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Watch watch) {
        // TODO add
        return Response.status(Status.CREATED).build();
    }


    @PUT
    @Path("/watch/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") long id, Watch watch) {
        // TODO update
        return Response.noContent().build();
    }

    @DELETE
    @Path("/watch/{id}")
    public Response delete(@PathParam("id") long id) {
        //TODO delete
        return Response.status(Status.NO_CONTENT).entity("Watch deleted successfully !!").build();
    }
}