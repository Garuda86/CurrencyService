package ru.currencyservice.currencyexchange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.currencyservice.currencyexchange.feignclient.GiphyClient;

@Component
public class GiphyService {
    @Value("${giphy.api_key}")
    private String apiKey = "";

    @Value("${giphy.json_key}")
    private String jsonKey = "";

    @Autowired
    private GiphyClient gifClient;

    public Object searchGiphy(String imageTheme) {
        return gifClient.getGiphy(apiKey, imageTheme).getData().get(jsonKey);
    }
}
