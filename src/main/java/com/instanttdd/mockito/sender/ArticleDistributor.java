package com.instanttdd.mockito.sender;

import com.instanttdd.mockito.article.Article;
import com.instanttdd.mockito.client.Channel;
import com.instanttdd.mockito.database.ArticleDataAccess;

/** Work through today's articles sending them out to the right places */
public class ArticleDistributor {

  private Channel sport;
  private Channel entertainment;
  private Channel others;
  private ArticleDataAccess dataAccess;

  public ArticleDistributor(
      Channel sport, Channel entertainment, Channel others, ArticleDataAccess dataAccess) {
    this.sport = sport;
    this.entertainment = entertainment;
    this.others = others;
    this.dataAccess = dataAccess;
  }

  public void distributeTodays() {
    for (Article article : dataAccess.getTodaysArticles()) {
      switch (article.getType()) {
        case SPORT:
          sport.accept(article);
          break;
        case ENTERTAINMENT:
          entertainment.accept(article);
          break;
        default:
          others.accept(article);
          break;
      }
    }
  }
}
