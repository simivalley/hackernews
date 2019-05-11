package org.homework.hackernews;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = RANDOM_PORT)
public class HackerNewsSmokeTest {

    @Autowired
    private Environment environment;



    @Test
    public void smokeTest() {
        RestTemplate restTemplate = new RestTemplate();

        String homePage = restTemplate.getForObject(url("/"), String.class);

        assertThat(homePage, containsString("Top Hacker News"));

//
//        String setupPage = restTemplate.getForObject(url("/http://www.example.com"), String.class);
//
//        assertThat(setupPage, containsString("Wedding"));
//        assertThat(setupPage, containsString("Starsky & Hutch"));
//        assertThat(setupPage, containsString("Shanghai Knights"));
//        assertThat(setupPage, containsString("I-Spy"));
//        assertThat(setupPage, containsString("The Royal Tenenbaums"));
//
//        String movieFunPage = restTemplate.getForObject(url("/moviefun"), String.class);
//
//        assertThat(movieFunPage, containsString("Wedding Crashers"));
//        assertThat(movieFunPage, containsString("David Dobkin"));
    }

    private String url(String path) {
        String port = environment.getProperty("local.server.port");
        String baseUrl = "http://localhost:"+port+"/hackernews/";
        String envUrl = System.getenv("MOVIE_FUN_URL");

        if (envUrl != null && !envUrl.isEmpty()) {
            baseUrl = envUrl;
        }

        return baseUrl + path;
    }
}
