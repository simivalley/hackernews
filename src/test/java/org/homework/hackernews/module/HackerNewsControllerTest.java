package org.homework.hackernews.module;

import org.junit.Before;

import static org.mockito.Mockito.mock;

public class HackerNewsControllerTest {

    private NewsItemsBean newsItemsBean;
    private HackerNewsController hackerNewsController;
    private TopNewsUpdater topNewsUpdater;

    @Before
    public void setUp() throws Exception {
        newsItemsBean = mock(NewsItemsBean.class);
        topNewsUpdater = mock(TopNewsUpdater.class);
        hackerNewsController = new HackerNewsController(newsItemsBean,topNewsUpdater);
    }



}
