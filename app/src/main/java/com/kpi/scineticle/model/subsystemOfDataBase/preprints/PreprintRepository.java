package com.kpi.scineticle.model.subsystemOfDataBase.preprints;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.kpi.scineticle.model.subsystemOfDataBase.UserDatabase;
import com.kpi.scineticle.model.subsystemOfDataBase.patents.Patent;
import com.kpi.scineticle.model.subsystemOfDataBase.patents.PatentRepository;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class PreprintRepository {
    private PreprintDao mPreprintDao;
    private LiveData<List<Preprint>> allPreprints;

    public PreprintRepository(Application application) {
        UserDatabase database = UserDatabase.getInstance(application);
        mPreprintDao = database.preprintDao();
        allPreprints = mPreprintDao.getAllPreprints();
    }

    public void insert(Preprint preprint) {
        new InsertPreprintAsyncTask(mPreprintDao).execute(preprint);
    }

    public void update(Preprint preprint) {
        new UpdatePreprintAsyncTask(mPreprintDao).execute(preprint);
    }

    public void delete(Preprint preprint) {
        new DeletePreprintAsyncTask(mPreprintDao).execute(preprint);
    }

    public void deleteAllPreprints() {
        new DeleteAllPreprintsAsyncTask(mPreprintDao).execute();
    }

    public LiveData<List<Preprint>> getAllPreprints() {
        return allPreprints;
    }

    public Preprint getPreprintsByName(String name) {
        Preprint preprint = new Preprint();
        AsyncTask task = new GetPriprentByName(mPreprintDao, name).execute();
        try {
            preprint = (Preprint) task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return preprint;
    }

    public Preprint getPreprintsByCity(String city) {
        Preprint preprint = new Preprint();
        AsyncTask task = new GetPriprentByCity(mPreprintDao, city).execute();
        try {
            preprint = (Preprint) task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return preprint;
    }

    public Preprint getPreprintsByPlace(String place) {
        Preprint preprint = new Preprint();
        AsyncTask task = new GetPriprentByPlace(mPreprintDao, place).execute();
        try {
            preprint = (Preprint) task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return preprint;
    }

    public Preprint getPreprintsByYear(String year) {
        Preprint preprint = new Preprint();
        AsyncTask task = new GetPriprentByPlace(mPreprintDao, year).execute();
        try {
            preprint = (Preprint) task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return preprint;
    }

    public Preprint getPreprintsBySheet(String sheet) {
        Preprint preprint = new Preprint();
        AsyncTask task = new GetPriprentBySheet(mPreprintDao, sheet).execute();
        try {
            preprint = (Preprint) task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return preprint;
    }

    public Preprint getPreprintsByOrganisation(String organisation) {
        Preprint preprint = new Preprint();
        AsyncTask task = new GetPriprentByOrganisation(mPreprintDao, organisation).execute();
        try {
            preprint = (Preprint) task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return preprint;
    }

    public Preprint getPreprintsByAbbreviation(String abbreviation) {
        Preprint preprint = new Preprint();
        AsyncTask task = new GetPriprentByAbbreviation(mPreprintDao, abbreviation).execute();
        try {
            preprint = (Preprint) task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return preprint;
    }



    private static class InsertPreprintAsyncTask extends AsyncTask<Preprint, Void, Void> {
        private PreprintDao mPreprintDao;

        private InsertPreprintAsyncTask(PreprintDao preprintDao) {
            mPreprintDao = preprintDao;
        }

        @Override
        protected Void doInBackground(Preprint... preprints) {
            mPreprintDao.insert(preprints[0]);
            return null;
        }
    }

    private static class UpdatePreprintAsyncTask extends AsyncTask<Preprint, Void, Void> {
        private PreprintDao mPreprintDao;

        private UpdatePreprintAsyncTask(PreprintDao preprintDao) {
            mPreprintDao = preprintDao;
        }

        @Override
        protected Void doInBackground(Preprint... preprints) {
            mPreprintDao.update(preprints[0]);
            return null;
        }
    }

    private static class DeletePreprintAsyncTask extends AsyncTask<Preprint, Void, Void> {
        private PreprintDao mPreprintDao;

        private DeletePreprintAsyncTask(PreprintDao preprintDao) {
            mPreprintDao = preprintDao;
        }

        @Override
        protected Void doInBackground(Preprint... preprints) {
            mPreprintDao.delete(preprints[0]);
            return null;
        }
    }

    private static class DeleteAllPreprintsAsyncTask extends AsyncTask<Void, Void, Void> {
        private PreprintDao mPreprintDao;

        public DeleteAllPreprintsAsyncTask(PreprintDao preprintDao) {
            mPreprintDao = preprintDao;
        }


        @Override
        protected Void doInBackground(Void... voids) {
            mPreprintDao.deleteAll();
            return null;
        }
    }

    private static class GetPriprentByName extends AsyncTask<Void, Void, Preprint> {
        private PreprintDao mPreprintDao;
        private String name;

        public GetPriprentByName(PreprintDao preprintDao, String name) {
            this.name = name;
            mPreprintDao = preprintDao;
        }

        @Override
        protected Preprint doInBackground(Void... voids) {
            return mPreprintDao.getPreprintsByName(name);
        }

        @Override
        protected void onPostExecute(Preprint preprint) {
            super.onPostExecute(preprint);
        }
    }

    private static class GetPriprentByCity extends AsyncTask<Void, Void, Preprint> {
        private PreprintDao mPreprintDao;
        private String city;

        public GetPriprentByCity(PreprintDao preprintDao, String city) {
            this.city = city;
            mPreprintDao = preprintDao;

        }

        @Override
        protected Preprint doInBackground(Void... voids) {
            return mPreprintDao.getPreprintsByCity(city);
        }

        @Override
        protected void onPostExecute(Preprint preprint) {
            super.onPostExecute(preprint);
        }
    }

    private static class GetPriprentByPlace extends AsyncTask<Void, Void, Preprint> {
        private PreprintDao mPreprintDao;
        private String place;

        public GetPriprentByPlace(PreprintDao preprintDao, String place) {
            this.place = place;
            mPreprintDao = preprintDao;

        }

        @Override
        protected Preprint doInBackground(Void... voids) {
            return mPreprintDao.getPreprintsByPlace(place);
        }

        @Override
        protected void onPostExecute(Preprint preprint) {
            super.onPostExecute(preprint);
        }
    }

    private static class GetPriprentByYear extends AsyncTask<Void, Void, Preprint> {
        private PreprintDao mPreprintDao;
        private String year;

        public GetPriprentByYear(PreprintDao preprintDao, String year) {
            this.year = year;
            mPreprintDao = preprintDao;

        }

        @Override
        protected Preprint doInBackground(Void... voids) {
            return mPreprintDao.getPreprintsByYear(year);
        }

        @Override
        protected void onPostExecute(Preprint preprint) {
            super.onPostExecute(preprint);
        }
    }

    private static class GetPriprentBySheet extends AsyncTask<Void, Void, Preprint> {
        private PreprintDao mPreprintDao;
        private String sheet;

        public GetPriprentBySheet(PreprintDao preprintDao, String sheet) {
            this.sheet = sheet;
            mPreprintDao = preprintDao;

        }

        @Override
        protected Preprint doInBackground(Void... voids) {
            return mPreprintDao.getPreprintsBySheet(sheet);
        }

        @Override
        protected void onPostExecute(Preprint preprint) {
            super.onPostExecute(preprint);
        }
    }

    private static class GetPriprentByOrganisation extends AsyncTask<Void, Void, Preprint> {
        private PreprintDao mPreprintDao;
        private String organisation;

        public GetPriprentByOrganisation(PreprintDao preprintDao, String organisation) {
            this.organisation = organisation;
            mPreprintDao = preprintDao;

        }

        @Override
        protected Preprint doInBackground(Void... voids) {
            return mPreprintDao.getPreprintsByOrganisation(organisation);
        }

        @Override
        protected void onPostExecute(Preprint preprint) {
            super.onPostExecute(preprint);
        }
    }

    private static class GetPriprentByAbbreviation extends AsyncTask<Void, Void, Preprint> {
        private PreprintDao mPreprintDao;
        private String abbreviation;

        public GetPriprentByAbbreviation(PreprintDao preprintDao, String abbreviation) {
            this.abbreviation = abbreviation;
            mPreprintDao = preprintDao;

        }

        @Override
        protected Preprint doInBackground(Void... voids) {
            return mPreprintDao.getPreprintsByAbbreviation(abbreviation);
        }

        @Override
        protected void onPostExecute(Preprint preprint) {
            super.onPostExecute(preprint);
        }
    }
}
