package uet.k59t.service;

/**
 * Created by Long on 11/20/2016.
 */

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import uet.k59t.controller.HelloController;

import java.util.Arrays;

@Service
public class HelloService {

    public String sayHello(String s){



        //Get
//        RestTemplate rest = new RestTemplate();
//		URIBuilder builder = new URIBuilder("http://kenh14.vn/"); //$NON-NLS-1$
//
//		builder.addParameter("response_type" //$NON-NLS-1$
//				, "code"); //$NON-NLS-1$
//		builder.addParameter("grant_type", //$NON-NLS-1$
//				"authorization_code"); //$NON-NLS-1$
//
//		URI url = new URI(builder.toString());
//
//		ResponseEntity<String> response = rest.getForEntity(url, String.class);
        return "Hello, git you typed:  " +s;
    }
}