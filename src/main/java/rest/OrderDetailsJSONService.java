/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import beans.OrderDetails;
import custom_beans.MainOrder;
import custom_beans.MainResponse;
import dao.Common;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import rest.filter.Secured;
import service.OrderDetailsService;

/**
 *
 * @author Terance Wijesuriya
 */
@Path("/orderDetails")
public class OrderDetailsJSONService {

    @POST
    @Secured
    @Path("/saveOrderDetails")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public MainResponse saveOrderDetails(MainOrder mainOrder) {
        MainResponse mainResponse = new MainResponse();
        OrderDetailsService service = new OrderDetailsService();
        String result = service.saveOrder(mainOrder);        
        if (result.equals(Common.SAVE_SUCCESS)) {
            mainResponse.setResponse(Common.SAVE_SUCCESS);
            mainResponse.setCode(200);
        } else {
            mainResponse.setResponse(Common.SAVE_ROLLBACK);
            mainResponse.setCode(500);            
        }
        return mainResponse;
    }

    @GET
    @Secured
    @Path("/getOrderDetailsByOrder/{idOrder}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public List<OrderDetails> getOrderDetailsByOrder(@PathParam("idOrder") int idOrder) {
        OrderDetailsService service = new OrderDetailsService();
        List<OrderDetails> list = service.getOrderDetailsByOrder(idOrder);
        return list;
    }
}
