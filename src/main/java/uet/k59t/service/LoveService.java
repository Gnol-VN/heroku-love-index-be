package uet.k59t.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import uet.k59t.controller.dto.LoveDTO;
import uet.k59t.controller.dto.ResultDTO;

import java.util.Arrays;

/**
 * Created by Long on 2/17/2017.
 */
@Service
public class LoveService {
    public ResultDTO postLoveIndex(LoveDTO loveDTO){
        //Post with body
        RestTemplate rest = new RestTemplate();
        rest.setMessageConverters(Arrays.asList(new StringHttpMessageConverter(), new FormHttpMessageConverter()));
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.set("rapide_annee[0]", loveDTO.getYear0());
        params.set("rapide_annee[1]", loveDTO.getYear1());
        Integer day0 = Integer.parseInt(loveDTO.getDay0()) -1;
        Integer day1 = Integer.parseInt(loveDTO.getDay1()) -1;
        Integer month0 = Integer.parseInt(loveDTO.getMonth0()) -1;
        Integer month1 = Integer.parseInt(loveDTO.getMonth1()) -1;

        params.set("rapide_jour[0]", day0.toString());
        params.set("rapide_jour[1]", day1.toString());
        params.set("rapide_mois[0]", month0.toString());
        params.set("rapide_mois[1]", month1.toString());
        params.set("rapide_prenom[0]", loveDTO.getName0());
        params.set("rapide_prenom[1]", loveDTO.getName1());
        params.set("partenaire", "9999");
        params.set("lang", "en");
        ResponseEntity<String> st = rest.postForEntity("https://www.astrotheme.fr/partenaires/indice_rapide.php", params, String.class);
        String html = st.getBody();

        Document document = Jsoup.parse(html);
        Elements divs = document.select("div");
        String score = divs.get(2).ownText();
        String comment = document.select("div div p").get(0).ownText();
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setComment(comment);
        resultDTO.setScore(score);
        return resultDTO;
    }

    public String findLover(LoveDTO loveDTO) {
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        String user0Name = loveDTO.getName0();
        String user0Day = loveDTO.getDay0();
        String user0Month = loveDTO.getMonth0();
        String user0Year = loveDTO.getYear0();

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 31; j++) {
                try{
                    params.clear();
                    params.set("rapide_annee[0]", loveDTO.getYear0());
                    Integer day0 = Integer.parseInt(loveDTO.getDay0()) -1;
                    params.set("rapide_jour[0]", day0.toString());
                    Integer month0 = Integer.parseInt(loveDTO.getMonth0()) -1;
                    params.set("rapide_mois[0]", month0.toString());
                    params.set("rapide_prenom[0]", loveDTO.getName0());

                    params.set("rapide_prenom[1]", loveDTO.getName1());
                    params.set("rapide_jour[1]", String.valueOf(j));
                    params.set("rapide_mois[1]", String.valueOf(i));
                    params.set("rapide_annee[1]", "96");

                    params.set("partenaire", "9999");
                    params.set("lang", "en");
                    ResponseEntity<String> st = restTemplate.postForEntity("http://www.astrotheme.fr/partenaires/indice_rapide.php", params, String.class);
                    String html = st.getBody();

                    Document document = Jsoup.parse(html);
                    Elements divs = document.select("div");
                    String score = divs.get(2).ownText();
                    String comment = document.select("div div p").get(0).ownText();
                    if(Integer.parseInt(score) > 90) {
                        int day = j+1;
                        int month = i+1;
                        System.out.println("month: "+ month +" day: "+day + " score: "+score);
                    }
                }
                catch (Exception e){
                    int day = j+1;
                    int month = i+1;
                    System.out.println(e.getMessage()+"with day: "+ j+ " month: "+i);
                }

            }

        }
        System.out.println("Done crawling :)");
        return null;
    }
}
