package com.instanttdd.mockito.database;

import com.instanttdd.mockito.article.Article;
import java.util.List;

public interface ArticleDataAccess {
  /**
   * @return all the articles from today
   */
  List<Article> getTodaysArticles();
}
