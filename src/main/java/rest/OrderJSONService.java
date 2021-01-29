/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import beans.Orders;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import rest.filter.Secured;
import service.OrderService;

/**
 *
 * @author Terance Wijesuriya
 */
@Path("/order")
public class OrderJSONService {

    @POST
    @Path("/saveOrder")
    @Consumes(MediaType.APPLICATION_JSON)
    public int saveOrder(Orders orders) {
        OrderService service = new OrderService();
        int result = service.saveOrder(orders);
        return result;
    }

    @GET
    @Secured
    @Path("/getAllOrdersOfUser/{idUser}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public List<Orders> getAllOrdersOfUser(@PathParam("idUser") int idUser) {
        OrderService service = new OrderService();
        List<Orders> list = service.getAllOrdersOfUser(idUser);
        return list;
    }

    @GET
    @Secured
    @Path("/getAllOrdersOfRetailers/{idRetailer}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public List<Orders> getAllOrdersOfRetailers(@PathParam("idRetailer") int idRetailer) {
        OrderService service = new OrderService();
        List<Orders> list = service.getAllOrdersOfRetailers(idRetailer);
        return list;
    }

    @GET
    @Secured
    @Path("/getAllOrdersByRetailersForDay/{idRetailer}/{startDay}/{endDay}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public List<Orders> getAllOrdersByRetailersForDay(@PathParam("idRetailer") int idRetailer, @PathParam("startDay") String startDay, @PathParam("endDay") String endDay) {
        OrderService service = new OrderService();
        List<Orders> list = service.getAllOrdersByRetailersForDay(idRetailer, startDay, endDay);
        return list;
    }
    
    @GET
    @Secured
    @Path("/getOrdersOfRetailersByDateDesc/{idRetailer}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public List<Orders> getOrdersOfRetailersByDateDesc(@PathParam("idRetailer") int idRetailer) {
        OrderService service = new OrderService();
        List<Orders> list = service.getOrdersOfRetailersByDateDesc(idRetailer);
        return list;
    }

}
