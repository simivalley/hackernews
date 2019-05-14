package org.homework.hackernews.module;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;


import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


public class HackerNewsControllerTest {

    private NewsItemsBean newsItemsBean;
    private HackerNewsController hackerNewsController;
    private TopNewsUpdater topNewsUpdater;
    private NewsServicesLinks newsServicesLinks;
   

    @Before
    public void setUp() throws Exception {
        newsItemsBean = new NewsItemsBean();
        newsServicesLinks = new NewsServicesLinks("{\"top-news-link\": \"https://hacker-news.firebaseio.com/v0/topstories.json\", \"news-link\": \"https://hacker-news.firebaseio.com/v0/item/\"}");
        topNewsUpdater = new TopNewsUpdater(newsItemsBean, newsServicesLinks);
        hackerNewsController = new HackerNewsController(newsItemsBean,topNewsUpdater);



    }

    @Test
    public void testIndex() throws Exception{


        Map<String, Object> model = new LinkedHashMap<>();
        String expectedStr ="hackerNewsIndex";

//        doReturn(expectedStr)
//                .when(newsItemsBean).getNewsItems().values().toArray();
        //model.put ( expectedStr, newsItemsBean.getNewsItems().values().toArray());

        String response =  hackerNewsController.index(model);

        assertThat(response).isEqualTo(expectedStr);




    }


}
