package ru.currencyservice.currencyexchange.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.currencyservice.currencyexchange.model.Quote;

@FeignClient(name = "open-exchange-rates", url = "${openexchangerates.api_url}")
public interface OpenExchangeRatesClient {

    @GetMapping("/latest.json?app_id={appId}&base={currencyBase}")
    public Quote getTodayRates(@PathVariable("appId") String appId,
                               @PathVariable("currencyBase") String currencyBase);

    @GetMapping("historical/{date}.json?app_id={appId}&base={currencyBase}")
    public Quote getHistoricalRates(@PathVariable("date") String date,
                                    @PathVariable("appId") String appId,
                                    @PathVariable("currencyBase") String currencyBase);

}
