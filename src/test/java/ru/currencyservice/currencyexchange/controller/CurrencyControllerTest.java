package ru.currencyservice.currencyexchange.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import ru.currencyservice.currencyexchange.feignclient.OpenExchangeRatesClient;
import ru.currencyservice.currencyexchange.model.Quote;
import ru.currencyservice.currencyexchange.service.CurrencyService;
import ru.currencyservice.currencyexchange.service.GiphyService;
import ru.currencyservice.currencyexchange.util.DataUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CurrencyController.class)
class CurrencyControllerTest {


    @MockBean
    private CurrencyService currencyServiceMock;

    @MockBean
    GiphyService giphyServiceMock;

    @Autowired
    private MockMvc mockMvc;
    private static final String CURRENCY = "RUB";
    private static final String SERVICE_RESULT = "https://media.giphy.com/media/d2W7eZX5z62ziqdi/giphy.gif";
    private static final String REQUEST = "/currency";
    private static final String VIEW_NAME = "index";
    private static final String MODEL_ATTRIBUTE = "gif";


    protected ResultActions perform() throws Exception {

        Mockito.when(currencyServiceMock.getRateResult(CURRENCY)).thenReturn(SERVICE_RESULT);

        return mockMvc.perform(MockMvcRequestBuilders.get(REQUEST));

    }

    @Test
    void main() throws Exception {

        ResultActions result = perform()
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.view().name(VIEW_NAME));

        String modelAndViewValue = (String) Objects.requireNonNull(result.andReturn().getModelAndView()).
                getModel().get(MODEL_ATTRIBUTE);
        Assertions.assertEquals(SERVICE_RESULT, modelAndViewValue);
    }

}