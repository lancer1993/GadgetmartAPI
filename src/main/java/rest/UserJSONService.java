/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import beans.User;
import custom_beans.MainResponse;
import custom_beans.UserPasswordResetBean;
import dao.Common;
import service.UserService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import rest.filter.Secured;

/**
 *
 * @author Terance Wijesuriya
 */
@Path("/user")
public class UserJSONService {

    @POST
    @Path("/saveUser")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public MainResponse saveUser(User user) {
        UserService service = new UserService();
        String result = service.saveUser(user);
        MainResponse mainResponse = new MainResponse();
        if (result.equals(Common.SAVE_SUCCESS)) {
            mainResponse.setResponse(Common.SAVE_SUCCESS);
            mainResponse.setCode(200);
            return mainResponse;
        } else {
            mainResponse.setResponse(Common.SAVE_ROLLBACK);
            mainResponse.setCode(500);
            return mainResponse;
        }
    }

    @GET
    @Secured
    @Path("/getAllUsers")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public List<User> getAllUsers() {
        UserService userService = new UserService();
        List<User> list = userService.getAllUsers();
        return list;
    }

    @GET
    @Secured
    @Path("/getUserById/{id}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public User getUserById(@PathParam("id") int id) {
        UserService userService = new UserService();
        User user = userService.getUserById(id);
        return user;
    }

    @GET
    @Secured
    @Path("/getUserByEmail/{email}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public User getUserByEmail(@PathParam("email") String email) {
        UserService userService = new UserService();
        User user = userService.getUserByEmail(email);
        return user;
    }

    @POST
    @Secured
    @Path("/updateUser")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUser(User user) {
        UserService userService = new UserService();
        String result = userService.updateUser(user);
        if (result.equals(Common.SAVE_SUCCESS)) {
            return Response.status(Response.Status.OK).entity(result).build();
        } else {
            return Response.status(Response.Status.EXPECTATION_FAILED).entity(result).build();
        }
    }

    @POST
    @Secured
    @Path("/updateUserPassword")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUserPassword(User user) {
        UserService userService = new UserService();
        String result = userService.updateUserPassword(user);
        if (result.equals(Common.SAVE_SUCCESS)) {
            return Response.status(Response.Status.OK).entity(result).build();
        } else {
            return Response.status(Response.Status.EXPECTATION_FAILED).entity(result).build();
        }
    }
    
    @POST
    @Path("/resetPassword")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public MainResponse resetPassword(UserPasswordResetBean userPasswordResetBean) {
        MainResponse mainResponse = new MainResponse();
        UserService userService = new UserService();
        String result = userService.resetPassword(userPasswordResetBean);
        if (result.equals(Common.SAVE_SUCCESS)) {
            mainResponse.setResponse(Common.SAVE_SUCCESS);
            mainResponse.setCode(200);
            return mainResponse;
        } else {
            mainResponse.setResponse(Common.SAVE_ROLLBACK);
            mainResponse.setCode(500);
            return mainResponse;
        }
    }
}
