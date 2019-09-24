package com.instanttdd.mockito.sender;

import static com.instanttdd.mockito.article.Type.POLITICS;
import static com.instanttdd.mockito.article.Type.SPORT;
import static java.util.Arrays.asList;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import com.instanttdd.mockito.article.Article;
import com.instanttdd.mockito.client.Channel;
import com.instanttdd.mockito.database.ArticleDataAccess;
import java.util.List;
import org.junit.Test;

public class ArticleDistributorTest {

  @Test
  public void sportGoesToSportPoliticsToOther() {
    Channel sport = mock(Channel.class);
    Channel entertainment = mock(Channel.class);
    Channel others = mock(Channel.class);
    ArticleDataAccess dataAccess = mock(ArticleDataAccess.class);

    ArticleDistributor distributor =
        new ArticleDistributor(sport, entertainment, others, dataAccess);

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
