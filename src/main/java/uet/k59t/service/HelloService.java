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
        //Post with body
        RestTemplate rest = new RestTemplate();
        rest.setMessageConverters(Arrays.asList(new StringHttpMessageConverter(), new FormHttpMessageConverter()));
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.set("rapide_annee[0]", "96");
        params.set("rapide_annee[1]", "96");
        params.set("rapide_jour[0]", "14");
        params.set("rapide_jour[1]", "24");
        params.set("rapide_mois[0]", "10");
        params.set("rapide_mois[1]", "2");
        params.set("rapide_prenom[0]", "long");
        params.set("rapide_prenom[1]", "e");
        params.set("partenaire", "9999");
        params.set("lang", "en");
        ResponseEntity<String> st = rest.postForEntity("http://www.astrotheme.fr/partenaires/indice_rapide.php", params, String.class);
        String html = st.getBody();

        Document document = Jsoup.parse(html);
        Elements divs = document.select("div");
        String score = divs.get(2).ownText();
        String comment = document.select("p").get(0).ownText();
        return "Hello, " +s;
    }
}