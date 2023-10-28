package cn.shh.test.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/mvc")
public class MVCController {
    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/page1")
    public String page1(){
        return "page1";
    }

    @GetMapping("/scope/mav")
    public ModelAndView testModelAndView(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("name", "ModelAndView");
        mav.setViewName("index");
        return mav;
    }

    @GetMapping("/scope/model")
    public String testModel(Model model){
        model.addAttribute("name", "Model");
        return "index";
    }

    @GetMapping("/scope/mm")
    public String testModelMap(ModelMap modelMap){
        modelMap.addAttribute("name", "ModelMap");
        return "index";
    }

    @GetMapping("/scope/map")
    public String testMap(Map<String, Object> map){
        map.put("name", "Map");
        return "index";
    }
}
