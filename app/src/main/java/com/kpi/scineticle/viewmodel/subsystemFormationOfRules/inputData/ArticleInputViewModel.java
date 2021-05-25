package com.kpi.scineticle.viewmodel.subsystemFormationOfRules.inputData;

import android.app.Application;

import com.kpi.scineticle.model.subsystemOfDataBase.article.Article;
import com.kpi.scineticle.model.subsystemOfDataBase.article.ArticleRepository;
import com.kpi.scineticle.model.subsystemOfDataBase.user.User;

public class ArticleInputViewModel {
   private ArticleRepository mArticleRepository;

   public ArticleInputViewModel(Application application) {
       mArticleRepository = new ArticleRepository(application);
   }

    public void insert(Article article) {
       mArticleRepository.insert(article);
    }
}
