/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import beans.User;
import com.auth0.jwt.exceptions.JWTCreationException;
import custom_beans.AuthKey;
import custom_beans.AuthorisedBean;
import custom_beans.Credentials;
import custom_beans.RefreshAuthKey;
import dao.Common;
import java.io.UnsupportedEncodingException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import service.UserService;
import util.AuthSecret;
import util.Token;

/**
 *
 * @author Terance Wijesuriya
 */
@Path("/authentication")
public class AuthenticationJSONService {

    @POST
    @Path("/authenticateUser")
    @Produces(MediaType.APPLICATION_JSON)
    public AuthorisedBean authenticateUser(Credentials credentials) {
        try {
            String username = credentials.getUsername();
            String password = credentials.getPassword();
            // Authenticate the user using the credentials provided
            User user = authenticate(username, password);
            if (user.getIduser() != null) {                
                user.setPassword(null);
                user.setSalt(null);
                // Issue a token for the user            
                long expMins = 10080; //1 week should be issues
                String token = generateToken(AuthSecret.authorizationSecret, username, expMins);
                AuthorisedBean authorisedBean = new AuthorisedBean();
                authorisedBean.setToken(token);
                authorisedBean.setUser(user);
                return authorisedBean;
            } else {
                // Return the token on the response
                return new AuthorisedBean();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new AuthorisedBean();
        }
    }

    @POST
    @Path("/refreshToken")
    @Produces(MediaType.APPLICATION_JSON)
    public RefreshAuthKey refreshToken(AuthKey authToken) {
        RefreshAuthKey refreshAuthKey = new RefreshAuthKey();
        try {
            Token token = new Token();
            if (token.validateTokenHMAC256(authToken.getAuthKey(), AuthSecret.authorizationSecret)) {
                long expMins = 20160; //2 weeks should be issued
                String generateToken = generateToken(AuthSecret.authorizationSecret, token.readClaim(authToken.getAuthKey(), "username"), expMins);

                // Return the token on the response                
                refreshAuthKey.setRefeshedToken(generateToken);
                return refreshAuthKey;
            } else {
                refreshAuthKey.setRefeshedToken(null);
                return refreshAuthKey;
            }

        } catch (Exception e) {
            e.printStackTrace();
            refreshAuthKey.setRefeshedToken(null);
            return refreshAuthKey;
        }
    }

    private User authenticate(String username, String password) throws Exception {
        UserService userService = new UserService();
        User user = userService.getUserByEmail(username);
        String salt = user.getSalt();

        String hashedPassword = Common.get_SHA_256_SecurePassword(password, salt);

        if (!user.getPassword().equals(hashedPassword)) {
            return new User();
        } else {
            return user;
        }
    }

    public String generateToken(String secret, String username, long expMins) throws JWTCreationException, UnsupportedEncodingException {
        Token token = new Token();
        return token.issueTokenHMAC256(secret, username, expMins);
    }
}
