package br.CadEvent.com;

import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

@Path("/edicao")
public class EdicaoServiceRest {
private JpaEntityManager JPAEM = new JpaEntityManager();
private EntityManager objEM = JPAEM.getEntityManager();
@GET
@Path("/listar")
@Produces("application/json")
public List<Edicao> listar(){
try {
String query = "select c from Edicao c";
List<Edicao> clientes = objEM.createQuery(query, Edicao.class).getResultList();
objEM.close();
return clientes;
} catch (Exception e) {
throw new WebApplicationException(500);
}
}
@GET
@Path("/buscar/{idedicao}")
@Produces("application/json")
public Edicao buscar(@PathParam("idedicao") int idedicao){
try {
	Edicao cliente = objEM.find(Edicao.class, idedicao);
objEM.close();
return cliente;
} catch (Exception e) {
throw new WebApplicationException(500);
}
}
@POST
@Path("/cadastrar")
@Consumes("application/json")
public Response cadastrar(Edicao objClinte){
try {
objEM.getTransaction().begin();
objEM.persist(objClinte);
objEM.getTransaction().commit();
objEM.close();
return Response.status(200).entity("cadastro realizado.").build();
} catch (Exception e) {
throw new WebApplicationException(500);
}
}
@PUT
@Path("/alterar")
@Consumes("application/json")
public Response alterar(Edicao objClinte){
try {
objEM.getTransaction().begin();
objEM.merge(objClinte);
objEM.getTransaction().commit();
objEM.close();
return Response.status(200).entity("cadastro alterado.").build();
} catch (Exception e) {
throw new WebApplicationException(500);
}
}
@DELETE
@Path("/excluir/{idedicao}")
public Response excluir(@PathParam("idedicao") int idedicao){
try {
Edicao objClinte = objEM.find(Edicao.class, idedicao);
objEM.getTransaction().begin();
objEM.remove(objClinte);
objEM.getTransaction().commit();
objEM.close();
return Response.status(200).entity("cadastro excluído.").build();
} catch (Exception e) {
throw new WebApplicationException(500);
}
}
}