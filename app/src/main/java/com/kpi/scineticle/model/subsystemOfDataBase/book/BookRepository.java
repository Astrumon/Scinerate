package com.kpi.scineticle.model.subsystemOfDataBase.book;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.kpi.scineticle.model.subsystemOfDataBase.UserDatabase;
import com.kpi.scineticle.model.subsystemOfDataBase.article.Article;
import com.kpi.scineticle.model.subsystemOfDataBase.article.ArticleDao;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class BookRepository {
    private BookDao mBookDao;
    private LiveData<List<Book>> allBooks;

    public BookRepository(Application application) {
        UserDatabase database = UserDatabase.getInstance(application);
        mBookDao = database.bookDao();
        allBooks = mBookDao.getAllBooks();
    }

    public void insert(Book book) {
        new InsertBookAsyncTask(mBookDao).execute(book);
    }

    public void update(Book book) {
        new UpdateBookAsyncTask(mBookDao).execute(book);
    }

    public void delete(Book book) {
        new DeleteBookAsyncTask(mBookDao).execute(book);
    }

    public void deleteAllBooks() {
        new DeleteAllBookAsyncTask(mBookDao).execute();
    }

    public LiveData<List<Book>> getAllBooks() {
        return allBooks;
    }

    public LiveData<List<Book>> getAllBooksByLogin(String userLogin) {

        AsyncTask task = new GetALlBooksByLogin(mBookDao, userLogin).execute();
        try {
            LiveData<List<Book>>  books = (LiveData<List<Book>>) task.get();
            return books;
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public Book getBookByName(String name) {
        Book book = new Book();
        AsyncTask task = new GetBookByName(mBookDao, name).execute();
        try {
            book = (Book) task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return book;
    }

    public Book getBookByStatement(String statement) {
        Book book = new Book();
        AsyncTask task = new GetBookByStatemnet(mBookDao, statement).execute();
        try {
            book = (Book) task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return book;
    }

    public Book getBookByPublish(String publish) {
        Book book = new Book();
        AsyncTask task = new GetBookByPublish(mBookDao, publish).execute();
        try {
            book = (Book) task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return book;
    }

    public Book getBookByYear(String year) {
        Book book = new Book();
        AsyncTask task = new GetBookByYear(mBookDao, year).execute();
        try {
            book = (Book) task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return book;
    }

    public Book getBookByCountOfSheets(int countOfSheets) {
        Book book = new Book();
        AsyncTask task = new GetBookByCountOfSheets(mBookDao, countOfSheets).execute();
        try {
            book = (Book) task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return book;
    }



    private static class InsertBookAsyncTask extends AsyncTask<Book, Void, Void> {
        private BookDao mBookDao;

        private InsertBookAsyncTask(BookDao bookDao) {
            mBookDao = bookDao;
        }

        @Override
        protected Void doInBackground(Book... books) {
            mBookDao.insert(books[0]);
            return null;
        }
    }

    private static class UpdateBookAsyncTask extends AsyncTask<Book, Void, Void> {
        private BookDao mBookDao;

        public UpdateBookAsyncTask(BookDao bookDao) {
            mBookDao = bookDao;
        }

        @Override
        protected Void doInBackground(Book... books) {
            mBookDao.update(books[0]);
            return null;
        }
    }

    private static class GetALlBooksByLogin extends AsyncTask<Void, Void, LiveData<List<Book>>> {
        private BookDao mBookDao;
        private String userLogin;

        public GetALlBooksByLogin(BookDao bookDao, String userLogin) {
            mBookDao = bookDao;
            this.userLogin = userLogin;
        }

        @Override
        protected LiveData<List<Book>> doInBackground(Void... voids) {
            return mBookDao.getAllBooksByLogin(userLogin);
        }

        @Override
        protected void onPostExecute(LiveData<List<Book>> listLiveData) {
            super.onPostExecute(listLiveData);
        }
    }

    private static class DeleteBookAsyncTask extends AsyncTask<Book, Void, Void> {
        private BookDao mBookDao;

        public DeleteBookAsyncTask(BookDao bookDao) {
            mBookDao = bookDao;
        }

        @Override
        protected Void doInBackground(Book... books) {
            mBookDao.delete(books[0]);
            return null;
        }
    }

    private static class DeleteAllBookAsyncTask extends AsyncTask<Void, Void, Void> {
        private BookDao mBookDao;

        public DeleteAllBookAsyncTask(BookDao bookDao) {
            mBookDao = bookDao;
        }


        @Override
        protected Void doInBackground(Void... voids) {
            mBookDao.deleteAll();
            return null;
        }
    }

    private static class GetBookByName extends AsyncTask<Void, Void, Book> {
        private BookDao mBookDao;
        private String name;

        public GetBookByName(BookDao bookDao, String name) {
            this.name = name;
            mBookDao = bookDao;

        }

        @Override
        protected Book doInBackground(Void... voids) {
            return mBookDao.getBookByName(name);
        }

        @Override
        protected void onPostExecute(Book book) {
            super.onPostExecute(book);
        }
    }

    private static class GetBookByStatemnet extends AsyncTask<Void, Void, Book> {
        private BookDao mBookDao;
        private String statement;

        public GetBookByStatemnet(BookDao bookDao, String statement) {
            this.statement = statement;
            mBookDao = bookDao;

        }

        @Override
        protected Book doInBackground(Void... voids) {
            return mBookDao.getBookByStatement(statement);
        }

        @Override
        protected void onPostExecute(Book book) {
            super.onPostExecute(book);
        }
    }

    private static class GetBookByPublish extends AsyncTask<Void, Void, Book> {
        private BookDao mBookDao;
        private String publish;

        public GetBookByPublish(BookDao bookDao, String statement) {
            this.publish = statement;
            mBookDao = bookDao;

        }

        @Override
        protected Book doInBackground(Void... voids) {
            return mBookDao.getBookByPublish(publish);
        }

        @Override
        protected void onPostExecute(Book book) {
            super.onPostExecute(book);
        }
    }

    private static class GetBookByYear extends AsyncTask<Void, Void, Book> {
        private BookDao mBookDao;
        private String year;

        public GetBookByYear(BookDao bookDao, String year) {
            this.year = year;
            mBookDao = bookDao;

        }

        @Override
        protected Book doInBackground(Void... voids) {
            return mBookDao.getBookByYear(year);
        }

        @Override
        protected void onPostExecute(Book book) {
            super.onPostExecute(book);
        }
    }

    private static class GetBookByCountOfSheets extends AsyncTask<Void, Void, Book> {
        private BookDao mBookDao;
        private int countOfSheets;

        public GetBookByCountOfSheets(BookDao bookDao, int countOfSheets) {
            this.countOfSheets = countOfSheets;
            mBookDao = bookDao;

        }

        @Override
        protected Book doInBackground(Void... voids) {
            return mBookDao.getBookByCountOfSheets(countOfSheets);
        }

        @Override
        protected void onPostExecute(Book book) {
            super.onPostExecute(book);
        }
    }


}
