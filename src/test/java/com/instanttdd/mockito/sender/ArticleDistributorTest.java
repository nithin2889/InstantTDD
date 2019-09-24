package com.instanttdd.mockito.sender;

import static com.instanttdd.mockito.article.Type.POLITICS;
import static com.instanttdd.mockito.article.Type.SPORT;
import static java.util.Arrays.asList;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.instanttdd.mockito.article.Article;
import com.instanttdd.mockito.client.EntertainmentChannel;
import com.instanttdd.mockito.client.OtherChannel;
import com.instanttdd.mockito.client.SportsChannel;
import com.instanttdd.mockito.database.ArticleDataAccess;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ArticleDistributorTest {

  @Mock private SportsChannel sport;
  @Mock private EntertainmentChannel entertainment;
  @Mock private OtherChannel others;
  @Mock private ArticleDataAccess dataAccess;

  @InjectMocks private ArticleDistributor distributor;

  @Test
  public void sportGoesToSportPoliticsToOther() {
    // given this list of articles is returned from the database.
    List<Article> articleList =
        asList(new Article("Sports is fun", SPORT), new Article("Politics is sad", POLITICS));

    when(dataAccess.getTodaysArticles()).thenReturn(articleList);

    // when we distribute
    distributor.distributeTodays();

    // then one goes to sport and the other goes to other
    verify(sport).accept(any());
    verify(entertainment, never()).accept(any());
    verify(others).accept(any());
  }
}
