/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import beans.Retailers;
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
import service.RetailerService;

/**
 *
 * @author Terance Wijesuriya
 */
@Path("/retailer")
public class RetailerJSONService {

    @POST
    @Path("/saveRetailer")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public MainResponse saveRetailer(Retailers retailers) {
        MainResponse mainResponse = new MainResponse();
        RetailerService service = new RetailerService();
        String result = service.saveRetailer(retailers);
        if (result.equals(Common.SAVE_SUCCESS)) {
            mainResponse.setResponse(Common.SAVE_SUCCESS);
            mainResponse.setCode(200);
        } else {
            mainResponse.setResponse(Common.SAVE_ROLLBACK);
            mainResponse.setCode(500);         
        }
        return mainResponse;
    }

    @POST
    @Path("/updateRetailer")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public MainResponse updateRetailer(Retailers retailers) {
        MainResponse mainResponse = new MainResponse();
        RetailerService service = new RetailerService();
        String result = service.updateRetailer(retailers);
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
    @Path("/getAllRetailers")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public List<Retailers> getAllRetailers() {
        RetailerService service = new RetailerService();
        List<Retailers> list = service.getAllRetailers();
        return list;
    }

    @GET
    @Secured
    @Path("/findRetailerById/{idRetailer}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Retailers findRetailerById(@PathParam("idRetailer") int idRetailer) {
        RetailerService service = new RetailerService();
        Retailers retailers = service.findRetailerById(idRetailer);
        return retailers;
    }
    
    @GET
    @Secured
    @Path("/getRetailers")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public List<Retailers> getRetailers() {
        RetailerService service = new RetailerService();
        List<Retailers> list = service.getRetailers();
        return list;
    }
}
