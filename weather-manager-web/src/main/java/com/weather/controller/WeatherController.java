package com.weather.controller;


import com.weather.service.JsonUtil;
import com.weather.service.NetUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/MyWeather/wea")
public class WeatherController {

    @Autowired
    private NetUtil netUtil;
    @Autowired
    private JsonUtil jsonUtil;

    @RequestMapping("/forest")
    public String forest(String city,Model model) throws IOException {
        String url = "https://api.seniverse.com/v3/weather/now.json?key=mtpmwyecaphmrzwc&location="+city+"&language=zh-Hans&unit=c";
        String data = netUtil.getJson(url);
        List<String> lists = jsonUtil.getData(data);
        model.addAttribute("lists",lists);
        return "display";

    }
    @RequestMapping("/fff")
    public String fff() {
        return "a";
    }
}
