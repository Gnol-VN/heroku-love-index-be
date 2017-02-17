package uet.k59t.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import uet.k59t.controller.dto.LoveDTO;
import uet.k59t.controller.dto.ResultDTO;
import uet.k59t.service.LoveService;

/**
 * Created by Long on 2/17/2017.
 */
@RestController
public class LoveController {
    @Autowired
    private LoveService loveService;
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResultDTO postLoveIndex(@RequestBody LoveDTO loveDTO){
        return loveService.postLoveIndex(loveDTO);
    }
    @RequestMapping(value = "/findlover", method = RequestMethod.POST)
    public String findLover(@RequestBody LoveDTO loveDTO){
        return loveService.findLover(loveDTO);
    }
}
