package it.verding.edo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:cucumber.xml"})
public class BaseIntegration {
    public static final String SERVER_PORT = "9999";
    public static String SERVER_URL = "http://localhost:" + SERVER_PORT + "/edo";

    @Autowired
    protected RestTemplate restTemplate;

}