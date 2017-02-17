package uet.k59t.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import uet.k59t.controller.dto.UserDTO;
import uet.k59t.model.User;
import uet.k59t.service.UserService;

import java.net.URI;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Long on 11/21/2016.
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    //create User
    @RequestMapping(value = "user", method = RequestMethod.POST)
    public UserDTO createUser(@RequestBody UserDTO userDTO){
        String casUrlPrefix = "http://login-test.his.com/tcgroup-sso-web";
        String username = "15372712873";
        String password = "123456";

        // GET TGT
        RestTemplate rest = new RestTemplate();
        rest.setMessageConverters(Arrays.asList(new StringHttpMessageConverter(), new FormHttpMessageConverter()));
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.set("username", username);
        params.set("password", password);
        URI tgtUrl = rest.postForLocation(casUrlPrefix + "/v1/tickets", params, Collections.emptyMap());
        System.out.println("[" + tgtUrl + "]");

        return userService.createUser(userDTO);

    }

    //find User by id
    @RequestMapping(value = "getuser", method = RequestMethod.GET)
    public UserDTO findUser(@PathVariable("user_id") Long id){
        return userService.getUserById(id);
    }
}
