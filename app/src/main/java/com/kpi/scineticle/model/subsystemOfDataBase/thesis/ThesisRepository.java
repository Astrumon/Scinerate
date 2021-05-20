package com.kpi.scineticle.model.subsystemOfDataBase.thesis;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.kpi.scineticle.model.subsystemOfDataBase.UserDatabase;


import java.util.List;
import java.util.concurrent.ExecutionException;

public class ThesisRepository {
    private ThesisDao mThesisDao;
    private LiveData<List<Thesis>> allThesis;

    public ThesisRepository(Application application) {
        UserDatabase database = UserDatabase.getInstance(application);
        mThesisDao = database.thesisDao();
        allThesis = mThesisDao.getAllThesis();
    }

    public void insert(Thesis thesis) {
        new InsertThesisAsyncTask(mThesisDao).execute(thesis);
    }

    public void update(Thesis thesis) {
        new UpdateThesisAsyncTask(mThesisDao).execute(thesis);
    }

    public void delete(Thesis thesis) {
        new DeleteDeleteAsyncTask(mThesisDao).execute(thesis);
    }

    public void deleteAllThesis() {
        new DeleteAllThesisAsyncTask(mThesisDao).execute();
    }

    public LiveData<List<Thesis>> getAllThesis() {
        return allThesis;
    }

    public Thesis getThesisByName(String name) {
        Thesis thesis = new Thesis();
        AsyncTask task = new GetThesisName(mThesisDao, name).execute();
        try {
            thesis = (Thesis) task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return thesis;
    }

    public Thesis getThesisByNamePublish(String namePublish) {
        Thesis thesis = new Thesis();
        AsyncTask task = new GetThesisByNamePublish(mThesisDao, namePublish).execute();
        try {
            thesis = (Thesis) task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return thesis;
    }

    public Thesis getThesisByDate(String date) {
        Thesis thesis = new Thesis();
        AsyncTask task = new GetThesisByDate(mThesisDao, date).execute();
        try {
            thesis = (Thesis) task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return thesis;
    }

    public Thesis getThesisByPlaceConference(String placeConference) {
        Thesis thesis = new Thesis();
        AsyncTask task = new GetThesisByPlaceConference(mThesisDao, placeConference).execute();
        try {
            thesis = (Thesis) task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return thesis;
    }

    public Thesis getThesisByPlacePublish(String placePublish) {
        Thesis thesis = new Thesis();
        AsyncTask task = new GetThesisByPlacePublish(mThesisDao, placePublish).execute();
        try {
            thesis = (Thesis) task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return thesis;
    }

    public Thesis getThesisByYear(String year) {
        Thesis thesis = new Thesis();
        AsyncTask task = new GetThesisByYear(mThesisDao, year).execute();
        try {
            thesis = (Thesis) task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return thesis;
    }

    public Thesis getThesisBySheets(String sheets) {
        Thesis thesis = new Thesis();
        AsyncTask task = new GetThesisBySheets(mThesisDao, sheets).execute();
        try {
            thesis = (Thesis) task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return thesis;
    }

    private static class InsertThesisAsyncTask extends AsyncTask<Thesis, Void, Void> {
        private ThesisDao mThesisDao;

        private InsertThesisAsyncTask(ThesisDao thesisDao) {
            mThesisDao = thesisDao;
        }

        @Override
        protected Void doInBackground(Thesis... theses) {
            mThesisDao.insert(theses[0]);
            return null;
        }
    }

    private static class UpdateThesisAsyncTask extends AsyncTask<Thesis, Void, Void> {
        private ThesisDao mThesisDao;

        public UpdateThesisAsyncTask(ThesisDao thesisDao) {
            mThesisDao = thesisDao;
        }

        @Override
        protected Void doInBackground(Thesis... theses) {
            mThesisDao.update(theses[0]);
            return null;
        }
    }

    private static class DeleteDeleteAsyncTask extends AsyncTask<Thesis, Void, Void> {
        private ThesisDao mThesisDao;

        public DeleteDeleteAsyncTask(ThesisDao thesisDao) {
            mThesisDao = thesisDao;
        }

        @Override
        protected Void doInBackground(Thesis... theses) {
            mThesisDao.delete(theses[0]);
            return null;
        }
    }

    private static class DeleteAllThesisAsyncTask extends AsyncTask<Void, Void, Void> {
        private ThesisDao mThesisDao;

        public DeleteAllThesisAsyncTask(ThesisDao thesisDao) {
            mThesisDao = thesisDao;
        }


        @Override
        protected Void doInBackground(Void... voids) {
            mThesisDao.deleteAll();
            return null;
        }
    }

    private static class GetThesisName extends AsyncTask<Void, Void, Thesis> {
        private ThesisDao mThesisDao;
        private String name;

        public GetThesisName(ThesisDao thesisDao, String name) {
            this.name = name;
            mThesisDao = thesisDao;

        }

        @Override
        protected Thesis doInBackground(Void... voids) {
            return mThesisDao.getThesisByName(name);
        }

        @Override
        protected void onPostExecute(Thesis thesis) {
            super.onPostExecute(thesis);
        }
    }

    private static class GetThesisByNamePublish extends AsyncTask<Void, Void, Thesis> {
        private ThesisDao mThesisDao;
        private String namePublish;

        public GetThesisByNamePublish(ThesisDao thesisDao, String namePublish) {
            this.namePublish = namePublish;
            mThesisDao = thesisDao;

        }

        @Override
        protected Thesis doInBackground(Void... voids) {
            return mThesisDao.getThesisByNamePublish(namePublish);
        }

        @Override
        protected void onPostExecute(Thesis thesis) {
            super.onPostExecute(thesis);
        }
    }

    private static class GetThesisByDate extends AsyncTask<Void, Void, Thesis> {
        private ThesisDao mThesisDao;
        private String date;

        public GetThesisByDate(ThesisDao thesisDao, String date) {
            this.date = date;
            mThesisDao = thesisDao;

        }

        @Override
        protected Thesis doInBackground(Void... voids) {
            return mThesisDao.getThesisByDate(date);
        }

        @Override
        protected void onPostExecute(Thesis thesis) {
            super.onPostExecute(thesis);
        }
    }

    private static class GetThesisByPlaceConference extends AsyncTask<Void, Void, Thesis> {
        private ThesisDao mThesisDao;
        private String placeConference;

        public GetThesisByPlaceConference(ThesisDao thesisDao, String placeConference) {
            this.placeConference = placeConference;
            mThesisDao = thesisDao;

        }

        @Override
        protected Thesis doInBackground(Void... voids) {
            return mThesisDao.getThesisByPlaceConference(placeConference);
        }

        @Override
        protected void onPostExecute(Thesis thesis) {
            super.onPostExecute(thesis);
        }
    }

    private static class GetThesisByPlacePublish extends AsyncTask<Void, Void, Thesis> {
        private ThesisDao mThesisDao;
        private String placePublish;

        public GetThesisByPlacePublish(ThesisDao thesisDao, String placePublish) {
            this.placePublish = placePublish;
            mThesisDao = thesisDao;

        }

        @Override
        protected Thesis doInBackground(Void... voids) {
            return mThesisDao.getThesisByPlacePublish(placePublish);
        }

        @Override
        protected void onPostExecute(Thesis thesis) {
            super.onPostExecute(thesis);
        }
    }

    private static class GetThesisByYear extends AsyncTask<Void, Void, Thesis> {
        private ThesisDao mThesisDao;
        private String year;

        public GetThesisByYear(ThesisDao thesisDao, String year) {
            this.year = year;
            mThesisDao = thesisDao;

        }

        @Override
        protected Thesis doInBackground(Void... voids) {
            return mThesisDao.getThesisByYear(year);
        }

        @Override
        protected void onPostExecute(Thesis thesis) {
            super.onPostExecute(thesis);
        }
    }

    private static class GetThesisBySheets extends AsyncTask<Void, Void, Thesis> {
        private ThesisDao mThesisDao;
        private String sheets;

        public GetThesisBySheets(ThesisDao thesisDao, String sheets) {
            this.sheets = sheets;
            mThesisDao = thesisDao;

        }

        @Override
        protected Thesis doInBackground(Void... voids) {
            return mThesisDao.getThesisBySheets(sheets);
        }

        @Override
        protected void onPostExecute(Thesis thesis) {
            super.onPostExecute(thesis);
        }
    }
}
