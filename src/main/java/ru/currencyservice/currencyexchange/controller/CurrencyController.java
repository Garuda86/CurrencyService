package ru.currencyservice.currencyexchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import ru.currencyservice.currencyexchange.service.CurrencyService;

@Controller
public class CurrencyController {
    @Autowired
    private CurrencyService currencyService;

    @Value("${openexchangerates.currency}")
    private String currency = "";

    @ResponseBody
    @GetMapping("/currency")
    public ModelAndView main() {

        String gifUrl = currencyService.getRateResult(currency);

        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("gif", gifUrl);

        return modelAndView;
    }


}
