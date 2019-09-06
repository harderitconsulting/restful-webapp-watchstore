package de.harderitconsulting.resource;

import de.harderitconsulting.resource.entity.Watch;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static junit.framework.TestCase.assertNotNull;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


public class WatchResourceTest extends JerseyTest {

    @Override
    public Application configure() {
        enable(TestProperties.LOG_TRAFFIC);
        return new ResourceConfig(WatchResource.class);
    }

    @Test
    public void testGetAll() {
        Response response = target("/watches").request().get();
        assertEquals("should return status 200", 200, response.getStatus());
        assertNotNull("Should return user list", response.getEntity().toString());
        System.out.println(response.getStatus());
        String actualJson = response.readEntity(String.class);
        assertThat(actualJson, equalTo("[{\"id\":1,\"manufacturer\":\"Rolex\",\"model\":\"Submariner\"},{\"id\":2,\"manufacturer\":\"Omega\",\"model\":\"Seamaster\"},{\"id\":3,\"manufacturer\":\"Bulova\",\"model\":\"Lunar Pilot\"}]"));
    }

    @Test
    public void testGetById() {
        Response response = target("/watches/watch/1").request().get();
        assertEquals("Should return status 200", 200, response.getStatus());
        assertNotNull("Should return user object as json", response.getEntity());
        String actualJson = response.readEntity(String.class);
        assertThat(actualJson, equalTo("{\"id\":7,\"manufacturer\":\"Hublot\",\"model\":\"Big Bang Unico Blue Magic\"}"));
    }

    @Test
    public void testCreate() {
        Watch watch = new Watch(105, "Omega", "Railmaster XXL");
        Response response = target("/watches").request().post(Entity.entity(watch, MediaType.APPLICATION_JSON));
        assertEquals("Should return status 201", 201, response.getStatus());
    }

    @Test
    public void testUpdate() {
        Watch watch = new Watch(105, "Omega", "Seamaster Bond Watch");
        Response response = target("/watches/watch/1").request().put(Entity.entity(watch, MediaType.APPLICATION_JSON));
        assertEquals("Should return status 204", 204, response.getStatus());
    }

    @Test
    public void testDelete() {
        Response response = target("/watches/watch/1").request().delete();
        assertEquals("Should return status 204", 204, response.getStatus());
    }
}