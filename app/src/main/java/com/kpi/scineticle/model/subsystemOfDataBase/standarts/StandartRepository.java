package com.kpi.scineticle.model.subsystemOfDataBase.standarts;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.kpi.scineticle.model.subsystemOfDataBase.UserDatabase;
import com.kpi.scineticle.model.subsystemOfDataBase.patents.Patent;
import com.kpi.scineticle.model.subsystemOfDataBase.patents.PatentRepository;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class StandartRepository {
    private StandartDao mStandartDao;
    private LiveData<List<Standart>> allStandarts;

    public StandartRepository(Application application) {
        UserDatabase database = UserDatabase.getInstance(application);
        mStandartDao = database.standartDao();
        allStandarts = mStandartDao.getAllStandarts();
    }

    public void insert(Standart standart) {
        new InsertStandartAsyncTask(mStandartDao).execute(standart);
    }

    public void update(Standart standart) {
        new UpdateStandartAsyncTask(mStandartDao).execute(standart);
    }

    public void delete(Standart standart) {
        new DeleteStandartAsyncTask(mStandartDao).execute(standart);
    }

    public void deleteAllPatents() {
        new DeleteAllStandartsAsyncTask(mStandartDao).execute();
    }

    public LiveData<List<Standart>> getAllStandarts() {
        return allStandarts;
    }

    public Standart getStandartByNameOfOrg(String nameOfOrg) {
        Standart standart = new Standart();
        AsyncTask task = new GetStandartByNameOfOrg(mStandartDao, nameOfOrg).execute();
        try {
            standart = (Standart) task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return standart;
    }

    public Standart getStandartByYearPublish(String yearPublish) {
        Standart standart = new Standart();
        AsyncTask task = new GetStandartByYearPublish(mStandartDao, yearPublish).execute();
        try {
            standart = (Standart) task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return standart;
    }

    public Standart getStandartByName(String name) {
        Standart standart = new Standart();
        AsyncTask task = new GetStandartByName(mStandartDao, name).execute();
        try {
            standart = (Standart) task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return standart;
    }

    public Standart getStandartByCodeLetter(String codeLetter) {
        Standart standart = new Standart();
        AsyncTask task = new GetStandartByCodeLetter(mStandartDao, codeLetter).execute();
        try {
            standart = (Standart) task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return standart;
    }

    public Standart getStandartByCodeNumber(String codeNumber) {
        Standart standart = new Standart();
        AsyncTask task = new GetStandartByCodeNumber(mStandartDao, codeNumber).execute();
        try {
            standart = (Standart) task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return standart;
    }

    public Standart getStandartByPublish(String publish) {
        Standart standart = new Standart();
        AsyncTask task = new GetStandartByPublish(mStandartDao, publish).execute();
        try {
            standart = (Standart) task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return standart;
    }

    public Standart getStandartByPlacePublish(String placePublish) {
        Standart standart = new Standart();
        AsyncTask task = new GetStandartByPlacePublish(mStandartDao, placePublish).execute();
        try {
            standart = (Standart) task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return standart;
    }

    private static class UpdateStandartAsyncTask extends AsyncTask<Standart, Void, Void> {
        private StandartDao mStandartDao;

        private UpdateStandartAsyncTask(StandartDao standartDao) {
            mStandartDao = standartDao;
        }

        @Override
        protected Void doInBackground(Standart... standarts) {
            mStandartDao.update(standarts[0]);
            return null;
        }
    }

    private static class DeleteStandartAsyncTask extends AsyncTask<Standart, Void, Void> {
        private StandartDao mStandartDao;

        private DeleteStandartAsyncTask(StandartDao standartDao) {
            mStandartDao = standartDao;
        }

        @Override
        protected Void doInBackground(Standart... standarts) {
            mStandartDao.delete(standarts[0]);
            return null;
        }
    }

    private static class InsertStandartAsyncTask extends AsyncTask<Standart, Void, Void> {
        private StandartDao mStandartDao;

        private InsertStandartAsyncTask(StandartDao standartDao) {
            mStandartDao = standartDao;
        }

        @Override
        protected Void doInBackground(Standart... standarts) {
            mStandartDao.insert(standarts[0]);
            return null;
        }
    }

    private static class DeleteAllStandartsAsyncTask extends AsyncTask<Void, Void, Void> {
        private StandartDao mStandartDao;

        public DeleteAllStandartsAsyncTask(StandartDao standartDao) {
            mStandartDao = standartDao;
        }


        @Override
        protected Void doInBackground(Void... voids) {
            mStandartDao.deleteAll();
            return null;
        }
    }

    private static class GetStandartByNameOfOrg extends AsyncTask<Void, Void, Standart> {
        private StandartDao mStandartDao;
        private String nameOfOrg;

        public GetStandartByNameOfOrg(StandartDao standartDao, String nameOfOrg) {
            this.nameOfOrg = nameOfOrg;
            mStandartDao = standartDao;

        }

        @Override
        protected Standart doInBackground(Void... voids) {
            return mStandartDao.getStandartByNameOfOrg(nameOfOrg);
        }

        @Override
        protected void onPostExecute(Standart standart) {
            super.onPostExecute(standart);
        }
    }

    private static class GetStandartByYearPublish extends AsyncTask<Void, Void, Standart> {
        private StandartDao mStandartDao;
        private String nameOfYearPublish;

        public GetStandartByYearPublish(StandartDao standartDao, String nameOfYearPublish) {
            this.nameOfYearPublish = nameOfYearPublish;
            mStandartDao = standartDao;

        }

        @Override
        protected Standart doInBackground(Void... voids) {
            return mStandartDao.getStandartByYearOfPublish(nameOfYearPublish);
        }

        @Override
        protected void onPostExecute(Standart standart) {
            super.onPostExecute(standart);
        }
    }

    private static class GetStandartByName extends AsyncTask<Void, Void, Standart> {
        private StandartDao mStandartDao;
        private String name;

        public GetStandartByName(StandartDao standartDao, String name) {
            this.name = name;
            mStandartDao = standartDao;

        }

        @Override
        protected Standart doInBackground(Void... voids) {
            return mStandartDao.getStandartByName(name);
        }

        @Override
        protected void onPostExecute(Standart standart) {
            super.onPostExecute(standart);
        }
    }

    private static class GetStandartByCodeLetter extends AsyncTask<Void, Void, Standart> {
        private StandartDao mStandartDao;
        private String codeLetter;

        public GetStandartByCodeLetter(StandartDao standartDao, String codeLetter) {
            this.codeLetter = codeLetter;
            mStandartDao = standartDao;

        }

        @Override
        protected Standart doInBackground(Void... voids) {
            return mStandartDao.getStandartByCodeLetter(codeLetter);
        }

        @Override
        protected void onPostExecute(Standart standart) {
            super.onPostExecute(standart);
        }
    }

    private static class GetStandartByCodeNumber extends AsyncTask<Void, Void, Standart> {
        private StandartDao mStandartDao;
        private String codeNumber;

        public GetStandartByCodeNumber(StandartDao standartDao, String codeNumber) {
            this.codeNumber = codeNumber;
            mStandartDao = standartDao;

        }

        @Override
        protected Standart doInBackground(Void... voids) {
            return mStandartDao.getStandartByCodeNumber(codeNumber);
        }

        @Override
        protected void onPostExecute(Standart standart) {
            super.onPostExecute(standart);
        }
    }

    private static class GetStandartByPublish extends AsyncTask<Void, Void, Standart> {
        private StandartDao mStandartDao;
        private String publish;

        public GetStandartByPublish(StandartDao standartDao, String publish) {
            this.publish = publish;
            mStandartDao = standartDao;

        }

        @Override
        protected Standart doInBackground(Void... voids) {
            return mStandartDao.getStandartByPublish(publish);
        }

        @Override
        protected void onPostExecute(Standart standart) {
            super.onPostExecute(standart);
        }
    }

    private static class GetStandartByPlacePublish extends AsyncTask<Void, Void, Standart> {
        private StandartDao mStandartDao;
        private String placePublish;

        public GetStandartByPlacePublish(StandartDao standartDao, String placePublish) {
            this.placePublish = placePublish;
            mStandartDao = standartDao;

        }

        @Override
        protected Standart doInBackground(Void... voids) {
            return mStandartDao.getStandartByPlacePublish(placePublish);
        }

        @Override
        protected void onPostExecute(Standart standart) {
            super.onPostExecute(standart);
        }
    }
}
