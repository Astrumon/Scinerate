package com.kpi.scineticle.model;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class UserRepository {
    private UserDao mUserDao;
    private LiveData<List<User>> allUsers;

    public UserRepository(Application application) {
        UserDatabase database = UserDatabase.getInstance(application);
        mUserDao = database.userDao();
        allUsers = mUserDao.getAllUsers();
    }

    public void insert(User user) {
        new InsertUserAsyncTask(mUserDao).execute(user);
    }

    public void update(User user) {
        new UpdateUserAsyncTask(mUserDao).execute(user);
    }

    public void delete(User user) {
        new DeleteUserAsyncTask(mUserDao).execute(user);
    }

    public void deleteAllUsers() {
        new DeleteAllUserAsyncTask(mUserDao).execute();
    }

    public LiveData<List<User>> getAllUsers() {
        return allUsers;
    }

    private static class InsertUserAsyncTask extends AsyncTask<User, Void, Void> {
        private UserDao mUserDao;

        private InsertUserAsyncTask(UserDao userDao) {
            mUserDao = userDao;
        }

        @Override
        protected Void doInBackground(User... users) {
            mUserDao.insert(users[0]);
            return null;
        }
    }

    private static class UpdateUserAsyncTask extends AsyncTask<User, Void, Void> {
        private UserDao mUserDao;

        public UpdateUserAsyncTask(UserDao userDao) {
            mUserDao = userDao;
        }

        @Override
        protected Void doInBackground(User... users) {
            mUserDao.update(users[0]);
            return null;
        }
    }

    private static class DeleteUserAsyncTask extends AsyncTask<User, Void, Void> {
        private UserDao mUserDao;

        public DeleteUserAsyncTask(UserDao userDao) {
            mUserDao = userDao;
        }

        @Override
        protected Void doInBackground(User... users) {
            mUserDao.delete(users[0]);
            return null;
        }
    }

    private static class DeleteAllUserAsyncTask extends AsyncTask<Void, Void, Void> {
        private UserDao mUserDao;

        public DeleteAllUserAsyncTask(UserDao userDao) {
            mUserDao = userDao;
        }


        @Override
        protected Void doInBackground(Void... voids) {
            mUserDao.deleteAll();
            return null;
        }
    }
}
