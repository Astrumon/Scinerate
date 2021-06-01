package com.kpi.scineticle.model.subsystemOfDataBase.article;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.kpi.scineticle.model.subsystemOfDataBase.ScientWork;
import com.kpi.scineticle.model.subsystemOfDataBase.UserDatabase;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class ArticleRepository {
    private ArticleDao mArticleDao;
    private LiveData<List<Article>> allArticles;

    public ArticleRepository(Application application) {
        UserDatabase database = UserDatabase.getInstance(application);
        mArticleDao = database.articleDao();
        allArticles = mArticleDao.getAllArticles();
    }

    public void insert(Article article) {
        new InsertArticleAsyncTask(mArticleDao).execute(article);
    }

    public void update(Article article) {
        new UpdateArticleAsyncTask(mArticleDao).execute(article);
    }

    public void delete(Article article) {
        new DeleteArticleAsyncTask(mArticleDao).execute(article);
    }

    public void deleteAllArticles() {
        new DeleteAllArticlesAsyncTask(mArticleDao).execute();
    }

    public void deleteAllArticles(String userLogin) {
        new DeleteAllArticlesByUserLoginAsyncTask(mArticleDao, userLogin).execute();
    }

    public LiveData<List<Article>> getAllArticles() {
        return allArticles;
    }

    public LiveData<List<Article>> getAllArticlesByLogin(String userLogin) {
        LiveData<List<Article>> listLiveData = mArticleDao.getAllArticles(userLogin);
        return listLiveData;
    }

    public Article getArticleByName(String name) {
        Article article = new Article();
        AsyncTask task = new GetArticleByName(mArticleDao, name).execute();
        try {
            article = (Article) task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return article;
    }

    public Article getArticleByNameJournal(String name) {
        Article article = new Article();
        AsyncTask task = new GetArticleByNameJournal(mArticleDao, name).execute();
        try {
            article = (Article) task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return article;
    }

    public Article getArticleByDate(String date) {
        Article article = new Article();
        AsyncTask task = new GetArticleByDate(mArticleDao, date).execute();
        try {
            article = (Article) task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return article;
    }

    public Article getArticleByNumber(String number) {
        Article article = new Article();
        AsyncTask task = new GetArticleByNumber(mArticleDao, number).execute();
        try {
            article = (Article) task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return article;
    }

    public Article getArticleByTypeOfWork(String typeOfWork) {
        Article article = new Article();
        AsyncTask task = new GetArticleByNumber(mArticleDao, typeOfWork).execute();
        try {
            article = (Article) task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return article;
    }

    public Article getArticleSheets(String sheets) {
        Article article = new Article();
        AsyncTask task = new GetArticleBySheets(mArticleDao, sheets).execute();
        try {
            article = (Article) task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return article;
    }


    private static class InsertArticleAsyncTask extends AsyncTask<Article, Void, Void> {
        private ArticleDao mArticleDao;

        private InsertArticleAsyncTask(ArticleDao articleDao) {
            mArticleDao = articleDao;
        }

        @Override
        protected Void doInBackground(Article... articles) {
            mArticleDao.insert(articles[0]);
            return null;
        }
    }

    private static class UpdateArticleAsyncTask extends AsyncTask<Article, Void, Void> {
        private ArticleDao mArticleDao;

        public UpdateArticleAsyncTask(ArticleDao articleDao) {
            mArticleDao = articleDao;
        }

        @Override
        protected Void doInBackground(Article... articles) {
            mArticleDao.update(articles[0]);
            return null;
        }
    }

    private static class DeleteArticleAsyncTask extends AsyncTask<Article, Void, Void> {
        private ArticleDao mArticleDao;

        public DeleteArticleAsyncTask(ArticleDao articleDao) {
            mArticleDao = articleDao;
        }

        @Override
        protected Void doInBackground(Article... articles) {
            mArticleDao.delete(articles[0]);
            return null;
        }
    }

    private static class DeleteAllArticlesByUserLoginAsyncTask extends AsyncTask<Void, Void, Void> {
        private ArticleDao mArticleDao;
        private String userLogin;

        public DeleteAllArticlesByUserLoginAsyncTask(ArticleDao articleDao, String userLogin) {
            mArticleDao = articleDao;
            this.userLogin = userLogin;
        }


        @Override
        protected Void doInBackground(Void... voids) {
            mArticleDao.deleteAllByUserLogin(userLogin);
            return null;
        }
    }

    private static class DeleteAllArticlesAsyncTask extends AsyncTask<Void, Void, Void> {
        private ArticleDao mArticleDao;

        public DeleteAllArticlesAsyncTask(ArticleDao articleDao) {
            mArticleDao = articleDao;
        }


        @Override
        protected Void doInBackground(Void... voids) {
            mArticleDao.deleteAll();
            return null;
        }
    }

    private static class GetArticleByName extends AsyncTask<Void, Void, Article> {
        private ArticleDao mArticleDao;
        private String name;

        public GetArticleByName(ArticleDao articleDao, String name) {
            this.name = name;
            mArticleDao = articleDao;

        }

        @Override
        protected Article doInBackground(Void... voids) {
            return mArticleDao.getArticleName(name);
        }

        @Override
        protected void onPostExecute(Article article) {
            super.onPostExecute(article);
        }
    }

    private static class GetALlArticleByLogin extends AsyncTask<Void, Void, LiveData<List<Article>>> {
        private ArticleDao mArticleDao;
        private String userLogin;

        public GetALlArticleByLogin(ArticleDao articleDao, String userLogin) {
            mArticleDao = articleDao;
            this.userLogin = userLogin;
        }

        @Override
        protected LiveData<List<Article>> doInBackground(Void... voids) {

            return mArticleDao.getAllArticles(userLogin);
        }

        @Override
        protected void onPostExecute(LiveData<List<Article>> listLiveData) {
            if (listLiveData == null) {
                Log.d("ScientWorks", "FUCK TASK");
            }

            super.onPostExecute(listLiveData);
        }
    }

    private static class GetArticleByNameJournal extends AsyncTask<Void, Void, Article>{
        private ArticleDao mArticleDao;
        private String nameJournal;

        public GetArticleByNameJournal(ArticleDao articleDao, String nameJournal) {
            this.nameJournal = nameJournal;
            mArticleDao = articleDao;
        }

        @Override
        protected Article doInBackground(Void... voids) {
            return mArticleDao.getArticleNameJournal(nameJournal);
        }

        @Override
        protected void onPostExecute(Article article) {
            super.onPostExecute(article);
        }
    }

    private static class GetArticleByDate extends AsyncTask<Void, Void, Article>{
        private ArticleDao mArticleDao;
        private String date;

        public GetArticleByDate(ArticleDao articleDao, String date) {
            this.date = date;
            mArticleDao = articleDao;

        }

        @Override
        protected Article doInBackground(Void... voids) {
            return mArticleDao.getArticleDatePublishing(date);
        }

        @Override
        protected void onPostExecute(Article article) {
            super.onPostExecute(article);
        }
    }

    private static class GetArticleByNumber extends AsyncTask<Void, Void, Article>{
        private ArticleDao mArticleDao;
        private String number;

        public GetArticleByNumber(ArticleDao articleDao, String number) {
            this.number = number;
            mArticleDao = articleDao;

        }

        @Override
        protected Article doInBackground(Void... voids) {
            return mArticleDao.getArticleNumber(number);
        }

        @Override
        protected void onPostExecute(Article article) {
            super.onPostExecute(article);
        }
    }

    private static class GetArticleByTypeOfWork extends AsyncTask<Void, Void, Article>{
        private ArticleDao mArticleDao;
        private String typeOfWork;

        public GetArticleByTypeOfWork(ArticleDao articleDao, String typeOfWork) {
            this.typeOfWork = typeOfWork;
            mArticleDao = articleDao;

        }

        @Override
        protected Article doInBackground(Void... voids) {
            return mArticleDao.getArticleTypeOfWork(typeOfWork);
        }

        @Override
        protected void onPostExecute(Article article) {
            super.onPostExecute(article);
        }
    }

    private static class GetArticleBySheets extends AsyncTask<Void, Void, Article>{
        private ArticleDao mArticleDao;
        private String sheets;

        public GetArticleBySheets(ArticleDao articleDao, String sheets) {
            this.sheets = sheets;
            mArticleDao = articleDao;

        }

        @Override
        protected Article doInBackground(Void... voids) {
            return mArticleDao.getArticleSheets(sheets);
        }

        @Override
        protected void onPostExecute(Article article) {
            super.onPostExecute(article);
        }
    }


}
