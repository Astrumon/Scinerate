package com.kpi.scineticle.model.subsystemOfDataBase.legislative_normative_documents;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.kpi.scineticle.model.subsystemOfDataBase.UserDatabase;
import com.kpi.scineticle.model.subsystemOfDataBase.patents.Patent;
import com.kpi.scineticle.model.subsystemOfDataBase.patents.PatentRepository;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class LegisNormDocumentsRepository {
    private LegisNormDocumentsDao mLegisNormDocumentsDao;
    private LiveData<List<LegisNormDocuments>> allLegisNormDoucuments;

    public LegisNormDocumentsRepository(Application application) {
        UserDatabase database = UserDatabase.getInstance(application);
        mLegisNormDocumentsDao = database.legisNormDocumentsDao();
        allLegisNormDoucuments = mLegisNormDocumentsDao.getAllLegisNormDocuments();
    }

    public void insert(LegisNormDocuments legisNormDocuments) {
        new InsertLegisNormDocumentsAsyncTask(mLegisNormDocumentsDao).execute(legisNormDocuments);
    }

    public void update(LegisNormDocuments legisNormDocuments) {
        new UpdateLegisNormDocumentsAsyncTask(mLegisNormDocumentsDao).execute(legisNormDocuments);
    }

    public void delete(LegisNormDocuments legisNormDocuments) {
        new DeleteLegisNormDocumentsAsyncTask(mLegisNormDocumentsDao).execute(legisNormDocuments);
    }

    public void deleteAllLegisNormDocuments() {
        new DeleteAllLegisNormDocumentsAsyncTask(mLegisNormDocumentsDao).execute();
    }

    public LiveData<List<LegisNormDocuments>> getAllLegisNormDoucuments() {
        return allLegisNormDoucuments;
    }

    public LegisNormDocuments getLegisNormDocumentsByName(String name) {
        LegisNormDocuments legisNormDocuments = new LegisNormDocuments();
        AsyncTask task = new GetLegisNormDocumentsByName(mLegisNormDocumentsDao, name).execute();
        try {
            legisNormDocuments = (LegisNormDocuments) task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return legisNormDocuments;
    }

    public LegisNormDocuments getLegisNormDocumentsByType(String type) {
        LegisNormDocuments legisNormDocuments = new LegisNormDocuments();
        AsyncTask task = new GetLegisNormDocumentsByType(mLegisNormDocumentsDao, type).execute();
        try {
            legisNormDocuments = (LegisNormDocuments) task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return legisNormDocuments;
    }

    public LegisNormDocuments getLegisNormDocumentsByDateAccess(String dateAccess) {
        LegisNormDocuments legisNormDocuments = new LegisNormDocuments();
        AsyncTask task = new GetLegisNormDocumentsByDateAccess(mLegisNormDocumentsDao, dateAccess).execute();
        try {
            legisNormDocuments = (LegisNormDocuments) task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return legisNormDocuments;
    }

    public LegisNormDocuments getLegisNormDocumentsByNumber(String number) {
        LegisNormDocuments legisNormDocuments = new LegisNormDocuments();
        AsyncTask task = new GetLegisNormDocumentsByNumber(mLegisNormDocumentsDao, number).execute();
        try {
            legisNormDocuments = (LegisNormDocuments) task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return legisNormDocuments;
    }

    public LegisNormDocuments getLegisNormDocumentsByPublish(String publish) {
        LegisNormDocuments legisNormDocuments = new LegisNormDocuments();
        AsyncTask task = new GetLegisNormDocumentsByPublish(mLegisNormDocumentsDao, publish).execute();
        try {
            legisNormDocuments = (LegisNormDocuments) task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return legisNormDocuments;
    }

    public LegisNormDocuments getLegisNormDocumentsByDatePublish(String datePublish) {
        LegisNormDocuments legisNormDocuments = new LegisNormDocuments();
        AsyncTask task = new GetLegisNormDocumentsByDatePublish(mLegisNormDocumentsDao, datePublish).execute();
        try {
            legisNormDocuments = (LegisNormDocuments) task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return legisNormDocuments;
    }

    public LegisNormDocuments getLegisNormDocumentsBySerial(String serial) {
        LegisNormDocuments legisNormDocuments = new LegisNormDocuments();
        AsyncTask task = new GetLegisNormDocumentsBySerial(mLegisNormDocumentsDao, serial).execute();
        try {
            legisNormDocuments = (LegisNormDocuments) task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return legisNormDocuments;
    }

    public LegisNormDocuments getLegisNormDocumentsBySheets(String sheets) {
        LegisNormDocuments legisNormDocuments = new LegisNormDocuments();
        AsyncTask task = new GetLegisNormDocumentsBySheets(mLegisNormDocumentsDao, sheets).execute();
        try {
            legisNormDocuments = (LegisNormDocuments) task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return legisNormDocuments;
    }


    private static class InsertLegisNormDocumentsAsyncTask extends AsyncTask<LegisNormDocuments, Void, Void> {
        private LegisNormDocumentsDao mLegisNormDocumentsDao;

        private InsertLegisNormDocumentsAsyncTask(LegisNormDocumentsDao legisNormDocumentsDao) {
            mLegisNormDocumentsDao = legisNormDocumentsDao;
        }

        @Override
        protected Void doInBackground(LegisNormDocuments... legisNormDocuments) {
            mLegisNormDocumentsDao.insert(legisNormDocuments[0]);
            return null;
        }
    }

    private static class UpdateLegisNormDocumentsAsyncTask extends AsyncTask<LegisNormDocuments, Void, Void> {
        private LegisNormDocumentsDao mLegisNormDocumentsDao;

        private UpdateLegisNormDocumentsAsyncTask(LegisNormDocumentsDao legisNormDocumentsDao) {
            mLegisNormDocumentsDao = legisNormDocumentsDao;
        }

        @Override
        protected Void doInBackground(LegisNormDocuments... legisNormDocuments) {
            mLegisNormDocumentsDao.update(legisNormDocuments[0]);
            return null;
        }
    }

    private static class DeleteLegisNormDocumentsAsyncTask extends AsyncTask<LegisNormDocuments, Void, Void> {
        private LegisNormDocumentsDao mLegisNormDocumentsDao;

        private DeleteLegisNormDocumentsAsyncTask(LegisNormDocumentsDao legisNormDocumentsDao) {
            mLegisNormDocumentsDao = legisNormDocumentsDao;
        }

        @Override
        protected Void doInBackground(LegisNormDocuments... legisNormDocuments) {
            mLegisNormDocumentsDao.delete(legisNormDocuments[0]);
            return null;
        }
    }

    private static class DeleteAllLegisNormDocumentsAsyncTask extends AsyncTask<Void, Void, Void> {
        private LegisNormDocumentsDao mLegisNormDocumentsDao;

        public DeleteAllLegisNormDocumentsAsyncTask(LegisNormDocumentsDao legisNormDocumentsDao) {
            mLegisNormDocumentsDao = legisNormDocumentsDao;
        }


        @Override
        protected Void doInBackground(Void... voids) {
            mLegisNormDocumentsDao.deleteAll();
            return null;
        }
    }

    private static class GetLegisNormDocumentsByName extends AsyncTask<Void, Void, LegisNormDocuments> {
        private LegisNormDocumentsDao mLegisNormDocumentsDao;
        private String name;

        public GetLegisNormDocumentsByName(LegisNormDocumentsDao legisNormDocumentsDao, String name) {
            this.name = name;
            mLegisNormDocumentsDao = legisNormDocumentsDao;

        }

        @Override
        protected LegisNormDocuments doInBackground(Void... voids) {
            return mLegisNormDocumentsDao.getLegisNormDocumentsByName(name);
        }

        @Override
        protected void onPostExecute(LegisNormDocuments legisNormDocuments) {
            super.onPostExecute(legisNormDocuments);
        }
    }

    private static class GetLegisNormDocumentsByType extends AsyncTask<Void, Void, LegisNormDocuments> {
        private LegisNormDocumentsDao mLegisNormDocumentsDao;
        private String type;

        public GetLegisNormDocumentsByType(LegisNormDocumentsDao legisNormDocumentsDao, String type) {
            this.type = type;
            mLegisNormDocumentsDao = legisNormDocumentsDao;

        }

        @Override
        protected LegisNormDocuments doInBackground(Void... voids) {
            return mLegisNormDocumentsDao.getLegisNormDocumentsByType(type);
        }

        @Override
        protected void onPostExecute(LegisNormDocuments legisNormDocuments) {
            super.onPostExecute(legisNormDocuments);
        }
    }

    private static class GetLegisNormDocumentsByDateAccess extends AsyncTask<Void, Void, LegisNormDocuments> {
        private LegisNormDocumentsDao mLegisNormDocumentsDao;
        private String dateAccess;

        public GetLegisNormDocumentsByDateAccess(LegisNormDocumentsDao legisNormDocumentsDao, String dateAccess) {
            this.dateAccess = dateAccess;
            mLegisNormDocumentsDao = legisNormDocumentsDao;

        }

        @Override
        protected LegisNormDocuments doInBackground(Void... voids) {
            return mLegisNormDocumentsDao.getLegisNormDocumentsByDateAccess(dateAccess);
        }

        @Override
        protected void onPostExecute(LegisNormDocuments legisNormDocuments) {
            super.onPostExecute(legisNormDocuments);
        }
    }

    private static class GetLegisNormDocumentsByNumber extends AsyncTask<Void, Void, LegisNormDocuments> {
        private LegisNormDocumentsDao mLegisNormDocumentsDao;
        private String number;

        public GetLegisNormDocumentsByNumber(LegisNormDocumentsDao legisNormDocumentsDao, String number) {
            this.number = number;
            mLegisNormDocumentsDao = legisNormDocumentsDao;

        }

        @Override
        protected LegisNormDocuments doInBackground(Void... voids) {
            return mLegisNormDocumentsDao.getLegisNormDocumentsByNumber(number);
        }

        @Override
        protected void onPostExecute(LegisNormDocuments legisNormDocuments) {
            super.onPostExecute(legisNormDocuments);
        }
    }

    private static class GetLegisNormDocumentsByPublish extends AsyncTask<Void, Void, LegisNormDocuments> {
        private LegisNormDocumentsDao mLegisNormDocumentsDao;
        private String publish;

        public GetLegisNormDocumentsByPublish(LegisNormDocumentsDao legisNormDocumentsDao, String publish) {
            this.publish = publish;
            mLegisNormDocumentsDao = legisNormDocumentsDao;

        }

        @Override
        protected LegisNormDocuments doInBackground(Void... voids) {
            return mLegisNormDocumentsDao.getLegisNormDocumentsByPublish(publish);
        }

        @Override
        protected void onPostExecute(LegisNormDocuments legisNormDocuments) {
            super.onPostExecute(legisNormDocuments);
        }
    }

    private static class GetLegisNormDocumentsByDatePublish extends AsyncTask<Void, Void, LegisNormDocuments> {
        private LegisNormDocumentsDao mLegisNormDocumentsDao;
        private String datePublish;

        public GetLegisNormDocumentsByDatePublish(LegisNormDocumentsDao legisNormDocumentsDao, String datePublish) {
            this.datePublish = datePublish;
            mLegisNormDocumentsDao = legisNormDocumentsDao;

        }

        @Override
        protected LegisNormDocuments doInBackground(Void... voids) {
            return mLegisNormDocumentsDao.getLegisNormDocumentsByDatePublish(datePublish);
        }

        @Override
        protected void onPostExecute(LegisNormDocuments legisNormDocuments) {
            super.onPostExecute(legisNormDocuments);
        }
    }

    private static class GetLegisNormDocumentsBySerial extends AsyncTask<Void, Void, LegisNormDocuments> {
        private LegisNormDocumentsDao mLegisNormDocumentsDao;
        private String serial;

        public GetLegisNormDocumentsBySerial(LegisNormDocumentsDao legisNormDocumentsDao, String serial) {
            this.serial = serial;
            mLegisNormDocumentsDao = legisNormDocumentsDao;

        }

        @Override
        protected LegisNormDocuments doInBackground(Void... voids) {
            return mLegisNormDocumentsDao.getLegisNormDocumentsBySerial(serial);
        }

        @Override
        protected void onPostExecute(LegisNormDocuments legisNormDocuments) {
            super.onPostExecute(legisNormDocuments);
        }
    }

    private static class GetLegisNormDocumentsBySheets extends AsyncTask<Void, Void, LegisNormDocuments> {
        private LegisNormDocumentsDao mLegisNormDocumentsDao;
        private String sheets;

        public GetLegisNormDocumentsBySheets(LegisNormDocumentsDao legisNormDocumentsDao, String sheets) {
            this.sheets = sheets;
            mLegisNormDocumentsDao = legisNormDocumentsDao;

        }

        @Override
        protected LegisNormDocuments doInBackground(Void... voids) {
            return mLegisNormDocumentsDao.getLegisNormDocumentsBySheets(sheets);
        }

        @Override
        protected void onPostExecute(LegisNormDocuments legisNormDocuments) {
            super.onPostExecute(legisNormDocuments);
        }
    }
}
