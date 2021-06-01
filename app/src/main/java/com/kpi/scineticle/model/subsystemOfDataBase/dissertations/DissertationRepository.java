package com.kpi.scineticle.model.subsystemOfDataBase.dissertations;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.kpi.scineticle.model.subsystemOfDataBase.UserDatabase;
import com.kpi.scineticle.model.subsystemOfDataBase.catalogs.CatalogDao;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class DissertationRepository {
    private DissertationDao mDissertationDao;
    private LiveData<List<Dissertation>> allDissertations;

    public DissertationRepository(Application application) {
        UserDatabase database = UserDatabase.getInstance(application);
        mDissertationDao = database.dissertationDao();
        allDissertations = mDissertationDao.getAllDissertations();
    }

    public void insert(Dissertation dissertation) {
        new InsertDissertationAsyncTask(mDissertationDao).execute(dissertation);
    }

    public void update(Dissertation dissertation) {
        new UpdateDissertationAsyncTask(mDissertationDao).execute(dissertation);
    }

    public void delete(Dissertation dissertation) {
        new DeleteDissertationAsyncTask(mDissertationDao).execute(dissertation);
    }

    public void deleteAllDissertations() {
        new DeleteAllDissertations(mDissertationDao).execute();
    }

    public void deleteAllDissertations(String userLogin) {
        new DeleteAllDissertationsByUserLoginAsyncTask(mDissertationDao, userLogin).execute();
    }

    public LiveData<List<Dissertation>> getAllDissertation() {
        return allDissertations;
    }

    public Dissertation getDissertationName(String name) {
        Dissertation dissertation = new Dissertation();
        AsyncTask task = new GetDissertationByName(mDissertationDao, name).execute();
        try {
            dissertation = (Dissertation) task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return dissertation;
    }

    public Dissertation getDissertationByType(String type) {
        Dissertation dissertation = new Dissertation();
        AsyncTask task = new GetDissertationByType(mDissertationDao, type).execute();
        try {
            dissertation = (Dissertation) task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return dissertation;
    }

    public Dissertation getDissertationByPlace(String place) {
        Dissertation dissertation = new Dissertation();
        AsyncTask task = new GetDissertionByPlace(mDissertationDao, place).execute();
        try {
            dissertation = (Dissertation) task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return dissertation;
    }

    public Dissertation getDissertationByPublish(String publish) {
        Dissertation dissertation = new Dissertation();
        AsyncTask task = new GetDissertationByPublish(mDissertationDao, publish).execute();
        try {
            dissertation = (Dissertation) task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return dissertation;
    }

    public Dissertation getDissertationByYear(String year) {
        Dissertation dissertation = new Dissertation();
        AsyncTask task = new GetDissertationByYear(mDissertationDao, year).execute();
        try {
            dissertation = (Dissertation) task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return dissertation;
    }

    public Dissertation getDissertationByCountOfSheets(int countOfSheets) {
        Dissertation dissertation = new Dissertation();
        AsyncTask task = new GetDissertationByCountOfList(mDissertationDao, countOfSheets).execute();
        try {
            dissertation = (Dissertation) task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return dissertation;
    }

    public LiveData<List<Dissertation>> getAllBooksByLogin(String userLogin) {

        AsyncTask task = new GetALlDissertationByLogin(mDissertationDao, userLogin).execute();
        try {
            LiveData<List<Dissertation>>  dissertation = (LiveData<List<Dissertation>>) task.get();
            return dissertation;
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return null;
    }



    private static class InsertDissertationAsyncTask extends AsyncTask<Dissertation, Void, Void> {
        private DissertationDao mDissertationDao;

        private InsertDissertationAsyncTask(DissertationDao dissertationDao) {
            mDissertationDao = dissertationDao;
        }

        @Override
        protected Void doInBackground(Dissertation... dissertations) {
            mDissertationDao.insert(dissertations[0]);
            return null;
        }
    }

    private static class UpdateDissertationAsyncTask extends AsyncTask<Dissertation, Void, Void> {
        private DissertationDao mDissertationDao;

        public UpdateDissertationAsyncTask(DissertationDao dissertationDao) {
            mDissertationDao = dissertationDao;
        }

        @Override
        protected Void doInBackground(Dissertation... dissertations) {
            mDissertationDao.update(dissertations[0]);
            return null;
        }
    }

    private static class DeleteDissertationAsyncTask extends AsyncTask<Dissertation, Void, Void> {
        private DissertationDao mDissertationDao;

        public DeleteDissertationAsyncTask(DissertationDao dissertationDao) {
            mDissertationDao = dissertationDao;
        }

        @Override
        protected Void doInBackground(Dissertation... dissertations) {
            mDissertationDao.delete(dissertations[0]);
            return null;
        }
    }

    private static class DeleteAllDissertations extends AsyncTask<Void, Void, Void> {
        private DissertationDao mDissertationDao;

        public DeleteAllDissertations(DissertationDao dissertationDao) {
            mDissertationDao = dissertationDao;
        }


        @Override
        protected Void doInBackground(Void... voids) {
            mDissertationDao.deleteAll();
            return null;
        }
    }

    private static class GetDissertationByName extends AsyncTask<Void, Void, Dissertation> {
        private DissertationDao mDissertationDao;
        private String name;

        public GetDissertationByName(DissertationDao dissertationDao, String name) {
            this.name = name;
            mDissertationDao = dissertationDao;

        }

        @Override
        protected Dissertation doInBackground(Void... voids) {
            return mDissertationDao.getDissertationByName(name);
        }

        @Override
        protected void onPostExecute(Dissertation dissertation) {
            super.onPostExecute(dissertation);
        }
    }

    private static class GetDissertationByType extends AsyncTask<Void, Void, Dissertation> {
        private DissertationDao mDissertationDao;
        private String type;

        public GetDissertationByType(DissertationDao dissertationDao, String type) {
            this.type = type;
            mDissertationDao = dissertationDao;

        }

        @Override
        protected Dissertation doInBackground(Void... voids) {
            return mDissertationDao.getDissertationByType(type);
        }

        @Override
        protected void onPostExecute(Dissertation dissertation) {
            super.onPostExecute(dissertation);
        }
    }

    private static class GetDissertionByPlace extends AsyncTask<Void, Void, Dissertation> {
        private DissertationDao mDissertationDao;
        private String place;

        public GetDissertionByPlace(DissertationDao dissertationDao, String place) {
            this.place = place;
            mDissertationDao = dissertationDao;

        }

        @Override
        protected Dissertation doInBackground(Void... voids) {
            return mDissertationDao.getDissertationByPlace(place);
        }

        @Override
        protected void onPostExecute(Dissertation dissertation) {
            super.onPostExecute(dissertation);
        }
    }

    private static class GetDissertationByPublish extends AsyncTask<Void, Void, Dissertation> {
        private DissertationDao mDissertationDao;
        private String publish;

        public GetDissertationByPublish(DissertationDao dissertationDao, String publish) {
            this.publish = publish;
            mDissertationDao = dissertationDao;

        }

        @Override
        protected Dissertation doInBackground(Void... voids) {
            return mDissertationDao.getDissertationByPublish(publish);
        }

        @Override
        protected void onPostExecute(Dissertation dissertation) {
            super.onPostExecute(dissertation);
        }
    }

    private static class GetDissertationByYear extends AsyncTask<Void, Void, Dissertation> {
        private DissertationDao mDissertationDao;
        private String year;

        public GetDissertationByYear(DissertationDao dissertationDao, String year) {
            this.year = year;
            mDissertationDao = dissertationDao;

        }

        @Override
        protected Dissertation doInBackground(Void... voids) {
            return mDissertationDao.getDissertationByYear(year);
        }

        @Override
        protected void onPostExecute(Dissertation dissertation) {
            super.onPostExecute(dissertation);
        }
    }

    private static class GetALlDissertationByLogin extends AsyncTask<Void, Void, LiveData<List<Dissertation>>> {
        private DissertationDao mDissertationDao;
        private String userLogin;

        public GetALlDissertationByLogin(DissertationDao dissertationDao, String userLogin) {
            mDissertationDao = dissertationDao;
            this.userLogin = userLogin;
        }

        @Override
        protected LiveData<List<Dissertation>> doInBackground(Void... voids) {
            return mDissertationDao.getAllDissertationByLogin(userLogin);
        }

        @Override
        protected void onPostExecute(LiveData<List<Dissertation>> listLiveData) {
            super.onPostExecute(listLiveData);
        }
    }

    private static class DeleteAllDissertationsByUserLoginAsyncTask extends AsyncTask<Void, Void, Void> {
        private DissertationDao mDissertationDao1;
        private String userLogin;

        public DeleteAllDissertationsByUserLoginAsyncTask(DissertationDao dissertationDao, String userLogin) {
            mDissertationDao1 = dissertationDao;
            this.userLogin = userLogin;
        }


        @Override
        protected Void doInBackground(Void... voids) {
            mDissertationDao1.deleteAllByUserLogin(userLogin);
            return null;
        }
    }
    private static class GetDissertationByCountOfList extends AsyncTask<Void, Void, Dissertation> {
        private DissertationDao mDissertationDao;
        private int countOfSheets;

        public GetDissertationByCountOfList(DissertationDao dissertationDao, int countOfSheets) {
            this.countOfSheets = countOfSheets;
            mDissertationDao = dissertationDao;

        }

        @Override
        protected Dissertation doInBackground(Void... voids) {
            return mDissertationDao.getDissertationByCountOfSheets(countOfSheets);
        }

        @Override
        protected void onPostExecute(Dissertation dissertation) {
            super.onPostExecute(dissertation);
        }
    }
}
