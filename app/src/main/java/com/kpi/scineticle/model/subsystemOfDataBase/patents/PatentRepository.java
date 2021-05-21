package com.kpi.scineticle.model.subsystemOfDataBase.patents;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.kpi.scineticle.model.subsystemOfDataBase.UserDatabase;


import java.util.List;
import java.util.concurrent.ExecutionException;

public class PatentRepository {
    private PatentDao mPatentDao;
    private LiveData<List<Patent>> allPatents;

    public PatentRepository(Application application) {
        UserDatabase database = UserDatabase.getInstance(application);
        mPatentDao = database.patentDao();
        allPatents = mPatentDao.getAllPatents();
    }

    public void insert(Patent patent) {
        new InsertPatentAsyncTask(mPatentDao).execute(patent);
    }

    public void update(Patent patent) {
        new UpdatePatentAsyncTask(mPatentDao).execute(patent);
    }

    public void delete(Patent patent) {
        new DeletePatentAsyncTask(mPatentDao).execute(patent);
    }

    public void deleteAllArticles() {
        new DeleteAllPatentsAsyncTask(mPatentDao).execute();
    }

    public LiveData<List<Patent>> getAllPatents() {
        return allPatents;
    }

    public Patent getPatentByName(String name) {
        Patent patent = new Patent();
        AsyncTask task = new GetPatentByNamePatentOwner(mPatentDao, name).execute();
        try {
            patent = (Patent) task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return patent;
    }

    public Patent getPatentByNamePatentOwner(String namePatentOwner) {
        Patent patent = new Patent();
        AsyncTask task = new GetPatentByNamePatentOwner(mPatentDao, namePatentOwner).execute();
        try {
            patent = (Patent) task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return patent;
    }

    public Patent getPatentByCountry(String country) {
        Patent patent = new Patent();
        AsyncTask task = new GetPatentByCountry(mPatentDao, country).execute();
        try {
            patent = (Patent) task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return patent;
    }

    public Patent getPatentByNumber(String number) {
        Patent patent = new Patent();
        AsyncTask task = new GetPatentByNumber(mPatentDao, number).execute();
        try {
            patent = (Patent) task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return patent;
    }

    public Patent getPatentByDate(String date) {
        Patent patent = new Patent();
        AsyncTask task = new GetPatentByDate(mPatentDao, date).execute();
        try {
            patent = (Patent) task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return patent;
    }



    private static class InsertPatentAsyncTask extends AsyncTask<Patent, Void, Void> {
        private PatentDao mPatentDao;

        private InsertPatentAsyncTask(PatentDao patentDao) {
            mPatentDao = patentDao;
        }

        @Override
        protected Void doInBackground(Patent... patents) {
            mPatentDao.insert(patents[0]);
            return null;
        }
    }

    private static class UpdatePatentAsyncTask extends AsyncTask<Patent, Void, Void> {
        private PatentDao mPatentDao;

        public UpdatePatentAsyncTask(PatentDao patentDao) {
            mPatentDao = patentDao;
        }

        @Override
        protected Void doInBackground(Patent... patents) {
            mPatentDao.update(patents[0]);
            return null;
        }
    }

    private static class DeletePatentAsyncTask extends AsyncTask<Patent, Void, Void> {
        private PatentDao mPatentDao;

        public DeletePatentAsyncTask(PatentDao patentDao) {
            mPatentDao = patentDao;
        }

        @Override
        protected Void doInBackground(Patent... patents) {
            mPatentDao.delete(patents[0]);
            return null;
        }
    }

    private static class DeleteAllPatentsAsyncTask extends AsyncTask<Void, Void, Void> {
        private PatentDao mPatentDao;

        public DeleteAllPatentsAsyncTask(PatentDao patentDao) {
            mPatentDao = patentDao;
        }


        @Override
        protected Void doInBackground(Void... voids) {
            mPatentDao.deleteAll();
            return null;
        }
    }

    private static class GetPatentByNamePatentOwner extends AsyncTask<Void, Void, Patent> {
        private PatentDao mPatentDao;
        private String namePatentOwner;

        public GetPatentByNamePatentOwner(PatentDao patentDao, String namePatentOwner) {
            this.namePatentOwner = namePatentOwner;
            mPatentDao = patentDao;

        }

        @Override
        protected Patent doInBackground(Void... voids) {
            return mPatentDao.getPatentByNamePatentOwner(namePatentOwner);
        }

        @Override
        protected void onPostExecute(Patent patent) {
            super.onPostExecute(patent);
        }
    }

    private static class GetPatentByName extends AsyncTask<Void, Void, Patent> {
        private PatentDao mPatentDao;
        private String name;

        public GetPatentByName(PatentDao patentDao, String name) {
            this.name = name;
            mPatentDao = patentDao;

        }

        @Override
        protected Patent doInBackground(Void... voids) {
            return mPatentDao.getPatentByName(name);
        }

        @Override
        protected void onPostExecute(Patent patent) {
            super.onPostExecute(patent);
        }
    }

    private static class GetPatentByCountry extends AsyncTask<Void, Void, Patent> {
        private PatentDao mPatentDao;
        private String country;

        public GetPatentByCountry(PatentDao patentDao, String country) {
            this.country = country;
            mPatentDao = patentDao;

        }

        @Override
        protected Patent doInBackground(Void... voids) {
            return mPatentDao.getPatentByCountry(country);
        }

        @Override
        protected void onPostExecute(Patent patent) {
            super.onPostExecute(patent);
        }
    }

    private static class GetPatentByNumber extends AsyncTask<Void, Void, Patent> {
        private PatentDao mPatentDao;
        private String number;

        public GetPatentByNumber(PatentDao patentDao, String number) {
            this.number = number;
            mPatentDao = patentDao;

        }

        @Override
        protected Patent doInBackground(Void... voids) {
            return mPatentDao.getPatentByNumber(number);
        }

        @Override
        protected void onPostExecute(Patent patent) {
            super.onPostExecute(patent);
        }
    }

    private static class GetPatentByDate extends AsyncTask<Void, Void, Patent> {
        private PatentDao mPatentDao;
        private String date;

        public GetPatentByDate(PatentDao patentDao, String date) {
            this.date = date;
            mPatentDao = patentDao;

        }

        @Override
        protected Patent doInBackground(Void... voids) {
            return mPatentDao.getPatentByDate(date);
        }

        @Override
        protected void onPostExecute(Patent patent) {
            super.onPostExecute(patent);
        }
    }
}
