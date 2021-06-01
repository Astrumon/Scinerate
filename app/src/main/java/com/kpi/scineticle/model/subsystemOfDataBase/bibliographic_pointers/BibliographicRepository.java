package com.kpi.scineticle.model.subsystemOfDataBase.bibliographic_pointers;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.kpi.scineticle.model.subsystemOfDataBase.UserDatabase;
import com.kpi.scineticle.model.subsystemOfDataBase.book.Book;
import com.kpi.scineticle.model.subsystemOfDataBase.book.BookDao;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class BibliographicRepository {
    private BibliographicPointersDao mBibliographicPointersDao;
    private LiveData<List<BibliographicPointer>> allBibliographicPointers;

    public BibliographicRepository(Application application) {
        UserDatabase database = UserDatabase.getInstance(application);
        mBibliographicPointersDao = database.bibliographicPointers();
        allBibliographicPointers = mBibliographicPointersDao.getAllBibliograbicPointers();
    }

    public void insert(BibliographicPointer bibliographicPointer) {
        new InsertBibliographicPointerAsyncTask(mBibliographicPointersDao).execute(bibliographicPointer);
    }

    public void update(BibliographicPointer bibliographicPointer) {
        new UpdateBibliographicPointerAsyncTask(mBibliographicPointersDao).execute(bibliographicPointer);
    }

    public void delete(BibliographicPointer bibliographicPointer) {
        new DeleteBibliographicPointerAsyncTask(mBibliographicPointersDao).execute(bibliographicPointer);
    }

    public void deleteAllBibliographicPointers() {
        new DeleteAllCatalogsAsyncTask(mBibliographicPointersDao).execute();
    }

    public LiveData<List<BibliographicPointer>> getAllBibliographicPointers() {
        return allBibliographicPointers;
    }

    public LiveData<List<BibliographicPointer>> getAllBibliographicPointersByLogin(String userLogin) {

        AsyncTask task = new GetAllBibliographicPointersByLogin(mBibliographicPointersDao, userLogin).execute();
        try {
            LiveData<List<BibliographicPointer>>  bibliographicPointers = (LiveData<List<BibliographicPointer>>) task.get();
            return bibliographicPointers;
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public BibliographicPointer getBibliographicPointersByName(String name) {
        BibliographicPointer bibliographicPointer = new BibliographicPointer();
        AsyncTask task = new GetBibliographicPointerByName(mBibliographicPointersDao, name).execute();
        try {
            bibliographicPointer = (BibliographicPointer) task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return bibliographicPointer;
    }

    public BibliographicPointer getBibliographicPointersByNumberOfRelease(String numberOfRelease) {
        BibliographicPointer bibliographicPointer = new BibliographicPointer();
        AsyncTask task = new GetBibliographicPointerByNumberOfRelease(mBibliographicPointersDao, numberOfRelease).execute();
        try {
            bibliographicPointer = (BibliographicPointer) task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return bibliographicPointer;
    }

    public BibliographicPointer getBibliographicPointersByPlace(String place) {
        BibliographicPointer bibliographicPointer = new BibliographicPointer();
        AsyncTask task = new GetBibliographicPointerByPlace(mBibliographicPointersDao, place).execute();
        try {
            bibliographicPointer = (BibliographicPointer) task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return bibliographicPointer;
    }

    public BibliographicPointer getBibliographicPointersByCity(String city) {
        BibliographicPointer bibliographicPointer = new BibliographicPointer();
        AsyncTask task = new GetBibliographicPointerByCity(mBibliographicPointersDao, city).execute();
        try {
            bibliographicPointer = (BibliographicPointer) task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return bibliographicPointer;
    }

    public BibliographicPointer getBibliographicPointersByAbbreviation(String abbreviation) {
        BibliographicPointer bibliographicPointer = new BibliographicPointer();
        AsyncTask task = new GetBibliographicPointerByAbbreviation(mBibliographicPointersDao, abbreviation).execute();
        try {
            bibliographicPointer = (BibliographicPointer) task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return bibliographicPointer;
    }

    public BibliographicPointer getBibliographicPointersByYear(String year) {
        BibliographicPointer bibliographicPointer = new BibliographicPointer();
        AsyncTask task = new GetBibliographicPointerByYear(mBibliographicPointersDao, year).execute();
        try {
            bibliographicPointer = (BibliographicPointer) task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return bibliographicPointer;
    }

    public BibliographicPointer getBibliographicPointersBySheet(String sheet) {
        BibliographicPointer bibliographicPointer = new BibliographicPointer();
        AsyncTask task = new GetBibliographicPointerBySheet(mBibliographicPointersDao, sheet).execute();
        try {
            bibliographicPointer = (BibliographicPointer) task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return bibliographicPointer;
    }

    public BibliographicPointer getBibliographicPointersByAdditionally(String additionally) {
        BibliographicPointer bibliographicPointer = new BibliographicPointer();
        AsyncTask task = new GetBibliographicPointerByAdditionally(mBibliographicPointersDao, additionally).execute();
        try {
            bibliographicPointer = (BibliographicPointer) task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return bibliographicPointer;
    }


    private static class InsertBibliographicPointerAsyncTask extends AsyncTask<BibliographicPointer, Void, Void> {
        private BibliographicPointersDao mBibliographicPointersDao;

        private InsertBibliographicPointerAsyncTask(BibliographicPointersDao bibliographicPointersDao) {
            mBibliographicPointersDao = bibliographicPointersDao;
        }

        @Override
        protected Void doInBackground(BibliographicPointer... bibliographicPointers) {
            mBibliographicPointersDao.insert(bibliographicPointers[0]);
            return null;
        }
    }

    private static class GetAllBibliographicPointersByLogin extends AsyncTask<Void, Void, LiveData<List<BibliographicPointer>>> {
        private BibliographicPointersDao mBibliographicPointersDao;
        private String userLogin;

        public GetAllBibliographicPointersByLogin(BibliographicPointersDao bibliographicPointersDao, String userLogin) {
            mBibliographicPointersDao = bibliographicPointersDao;
            this.userLogin = userLogin;
        }

        @Override
        protected LiveData<List<BibliographicPointer>> doInBackground(Void... voids) {
            return mBibliographicPointersDao.getAllBibliograbicPointersByLogin(userLogin);
        }

        @Override
        protected void onPostExecute(LiveData<List<BibliographicPointer>> listLiveData) {
            super.onPostExecute(listLiveData);
        }
    }

    private static class UpdateBibliographicPointerAsyncTask extends AsyncTask<BibliographicPointer, Void, Void> {
        private BibliographicPointersDao mBibliographicPointersDao;

        private UpdateBibliographicPointerAsyncTask(BibliographicPointersDao bibliographicPointersDao) {
            mBibliographicPointersDao = bibliographicPointersDao;
        }

        @Override
        protected Void doInBackground(BibliographicPointer... bibliographicPointers) {
            mBibliographicPointersDao.update(bibliographicPointers[0]);
            return null;
        }
    }

    private static class DeleteBibliographicPointerAsyncTask extends AsyncTask<BibliographicPointer, Void, Void> {
        private BibliographicPointersDao mBibliographicPointersDao;

        private DeleteBibliographicPointerAsyncTask(BibliographicPointersDao bibliographicPointersDao) {
            mBibliographicPointersDao = bibliographicPointersDao;
        }

        @Override
        protected Void doInBackground(BibliographicPointer... bibliographicPointers) {
            mBibliographicPointersDao.delete(bibliographicPointers[0]);
            return null;
        }
    }

    private static class DeleteAllCatalogsAsyncTask extends AsyncTask<Void, Void, Void> {
        private BibliographicPointersDao mBibliographicPointersDao;

        public DeleteAllCatalogsAsyncTask(BibliographicPointersDao bibliographicPointersDao) {
            mBibliographicPointersDao = bibliographicPointersDao;
        }


        @Override
        protected Void doInBackground(Void... voids) {
            mBibliographicPointersDao.deleteAll();
            return null;
        }
    }

    private static class GetBibliographicPointerByName extends AsyncTask<Void, Void, BibliographicPointer> {
        private BibliographicPointersDao mBibliographicPointersDao;
        private String name;

        public GetBibliographicPointerByName(BibliographicPointersDao bibliographicPointersDao, String name) {
            this.name = name;
            mBibliographicPointersDao = bibliographicPointersDao;
        }

        @Override
        protected BibliographicPointer doInBackground(Void... voids) {
            return mBibliographicPointersDao.getBibliographicPointersByName(name);
        }

        @Override
        protected void onPostExecute(BibliographicPointer bibliographicPointer) {
            super.onPostExecute(bibliographicPointer);
        }
    }

    private static class GetBibliographicPointerByNumberOfRelease extends AsyncTask<Void, Void, BibliographicPointer> {
        private BibliographicPointersDao mBibliographicPointersDao;
        private String numberOfRelease;

        public GetBibliographicPointerByNumberOfRelease(BibliographicPointersDao bibliographicPointersDao, String numberOfRelease) {
            this.numberOfRelease = numberOfRelease;
            mBibliographicPointersDao = bibliographicPointersDao;
        }

        @Override
        protected BibliographicPointer doInBackground(Void... voids) {
            return mBibliographicPointersDao.getBibliographicPointersByNumberOfRelease(numberOfRelease);
        }

        @Override
        protected void onPostExecute(BibliographicPointer bibliographicPointer) {
            super.onPostExecute(bibliographicPointer);
        }
    }

    private static class GetBibliographicPointerByPlace extends AsyncTask<Void, Void, BibliographicPointer> {
        private BibliographicPointersDao mBibliographicPointersDao;
        private String place;

        public GetBibliographicPointerByPlace(BibliographicPointersDao bibliographicPointersDao, String place) {
            this.place = place;
            mBibliographicPointersDao = bibliographicPointersDao;
        }

        @Override
        protected BibliographicPointer doInBackground(Void... voids) {
            return mBibliographicPointersDao.getBibliographicPointersByNumberOfRelease(place);
        }

        @Override
        protected void onPostExecute(BibliographicPointer bibliographicPointer) {
            super.onPostExecute(bibliographicPointer);
        }
    }

    private static class GetBibliographicPointerByCity extends AsyncTask<Void, Void, BibliographicPointer> {
        private BibliographicPointersDao mBibliographicPointersDao;
        private String city;

        public GetBibliographicPointerByCity(BibliographicPointersDao bibliographicPointersDao, String city) {
            this.city = city;
            mBibliographicPointersDao = bibliographicPointersDao;
        }

        @Override
        protected BibliographicPointer doInBackground(Void... voids) {
            return mBibliographicPointersDao.getBibliographicPointersByCity(city);
        }

        @Override
        protected void onPostExecute(BibliographicPointer bibliographicPointer) {
            super.onPostExecute(bibliographicPointer);
        }
    }

    private static class GetBibliographicPointerByAbbreviation extends AsyncTask<Void, Void, BibliographicPointer> {
        private BibliographicPointersDao mBibliographicPointersDao;
        private String abbreviation;

        public GetBibliographicPointerByAbbreviation(BibliographicPointersDao bibliographicPointersDao, String abbreviation) {
            this.abbreviation = abbreviation;
            mBibliographicPointersDao = bibliographicPointersDao;
        }

        @Override
        protected BibliographicPointer doInBackground(Void... voids) {
            return mBibliographicPointersDao.getBibliographicPointersByAbbreviation(abbreviation);
        }

        @Override
        protected void onPostExecute(BibliographicPointer bibliographicPointer) {
            super.onPostExecute(bibliographicPointer);
        }
    }

    private static class GetBibliographicPointerByYear extends AsyncTask<Void, Void, BibliographicPointer> {
        private BibliographicPointersDao mBibliographicPointersDao;
        private String year;

        public GetBibliographicPointerByYear(BibliographicPointersDao bibliographicPointersDao, String year) {
            this.year = year;
            mBibliographicPointersDao = bibliographicPointersDao;
        }

        @Override
        protected BibliographicPointer doInBackground(Void... voids) {
            return mBibliographicPointersDao.getBibliographicPointersByYear(year);
        }

        @Override
        protected void onPostExecute(BibliographicPointer bibliographicPointer) {
            super.onPostExecute(bibliographicPointer);
        }
    }

    private static class GetBibliographicPointerBySheet extends AsyncTask<Void, Void, BibliographicPointer> {
        private BibliographicPointersDao mBibliographicPointersDao;
        private String sheet;

        public GetBibliographicPointerBySheet(BibliographicPointersDao bibliographicPointersDao, String sheet) {
            this.sheet = sheet;
            mBibliographicPointersDao = bibliographicPointersDao;
        }

        @Override
        protected BibliographicPointer doInBackground(Void... voids) {
            return mBibliographicPointersDao.getBibliographicPointersBySheet(sheet);
        }

        @Override
        protected void onPostExecute(BibliographicPointer bibliographicPointer) {
            super.onPostExecute(bibliographicPointer);
        }
    }

    private static class GetBibliographicPointerByAdditionally extends AsyncTask<Void, Void, BibliographicPointer> {
        private BibliographicPointersDao mBibliographicPointersDao;
        private String additionally;

        public GetBibliographicPointerByAdditionally(BibliographicPointersDao bibliographicPointersDao, String additionally) {
            this.additionally = additionally;
            mBibliographicPointersDao = bibliographicPointersDao;
        }

        @Override
        protected BibliographicPointer doInBackground(Void... voids) {
            return mBibliographicPointersDao.getBibliographicPointersByAdditionally(additionally);
        }

        @Override
        protected void onPostExecute(BibliographicPointer bibliographicPointer) {
            super.onPostExecute(bibliographicPointer);
        }
    }
}
