package ru.currencyservice.currencyexchange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.currencyservice.currencyexchange.feignclient.OpenExchangeRatesClient;
import ru.currencyservice.currencyexchange.model.Quote;
import ru.currencyservice.currencyexchange.util.DataUtil;

@Component
public class CurrencyService {

    @Autowired
    private OpenExchangeRatesClient openExchangeRatesClient;
    @Autowired
    private GiphyService giphyService;

    @Value("${openexchangerates.app_id}")
    private String appId = "";

    @Value("${openexchangerates.currency_base}")
    private String currencyBase = "";

    @Value("${giphy.tag.positive}")
    private String rich;

    @Value("${giphy.tag.negative}")
    private String broke;

    public String getRateResult(String currency) {
        Quote todayRates = openExchangeRatesClient.getTodayRates(appId, currencyBase);
        Quote historicalRates = openExchangeRatesClient.getHistoricalRates(DataUtil.getYesterday(), appId, currencyBase);

        String gifUrl = "";
        if (todayRates.getRates().get(currency) >= historicalRates.getRates().get(currency)) {
            gifUrl = (String) giphyService.searchGiphy(rich);
        } else if (todayRates.getRates().get(currency) < historicalRates.getRates().get(currency)) {
            gifUrl = (String) giphyService.searchGiphy(broke);
        }
        return gifUrl;
    }
}
