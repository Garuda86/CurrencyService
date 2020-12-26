package ru.currencyservice.currencyexchange.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.currencyservice.currencyexchange.model.Giphy;

@FeignClient(name="giphy-service", url = "${giphy.api_url}")
public interface GiphyClient {
    @GetMapping("?api_key={apiKey}&tag={tag}")
    public Giphy getGiphy(@PathVariable("apiKey") String apiKey, @PathVariable("tag") String tag);
}

