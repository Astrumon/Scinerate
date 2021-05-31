package com.kpi.scineticle.model.subsystemOfDataBase.catalogs;
import android.app.Application;
import android.os.AsyncTask;
import androidx.lifecycle.LiveData;
import com.kpi.scineticle.model.subsystemOfDataBase.UserDatabase;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class CatalogRepository {
    private CatalogDao mCatalogDao;
    private LiveData<List<Catalog>> allCatalogs;

    public CatalogRepository(Application application) {
        UserDatabase database = UserDatabase.getInstance(application);
        mCatalogDao = database.catalogDao();
        allCatalogs = mCatalogDao.getAllCatalogs();
    }

    public void insert(Catalog catalog) {
        new InsertCatalogAsyncTask(mCatalogDao).execute(catalog);
    }

    public void update(Catalog catalog) {
        new UpdateCatalogAsyncTask(mCatalogDao).execute(catalog);
    }

    public void delete(Catalog catalog) {
        new DeleteCatalogAsyncTask(mCatalogDao).execute(catalog);
    }

    public void deleteAllCatalogs() {
        new DeleteAllCatalogsAsyncTask(mCatalogDao).execute();
    }

    public LiveData<List<Catalog>> getAllCatalogs() {
        return allCatalogs;
    }

    public Catalog getCatalogByName(String name) {
        Catalog catalog = new Catalog();
        AsyncTask task = new GetCatalogByName(mCatalogDao, name).execute();
        try {
            catalog = (Catalog) task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return catalog;
    }

    public Catalog getCatalogByPlace(String place) {
        Catalog catalog = new Catalog();
        AsyncTask task = new GetCatalogByPlace(mCatalogDao, place).execute();
        try {
            catalog = (Catalog) task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return catalog;
    }

    public Catalog getCatalogByCity(String city) {
        Catalog catalog = new Catalog();
        AsyncTask task = new GetCatalogByCity(mCatalogDao, city).execute();
        try {
            catalog = (Catalog) task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return catalog;
    }

    public Catalog getCatalogByPublish(String publish) {
        Catalog catalog = new Catalog();
        AsyncTask task = new GetCatalogByPublish(mCatalogDao, publish).execute();
        try {
            catalog = (Catalog) task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return catalog;
    }

    public Catalog getCatalogByYear(String year) {
        Catalog catalog = new Catalog();
        AsyncTask task = new GetCatalogByYear(mCatalogDao, year).execute();
        try {
            catalog = (Catalog) task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return catalog;
    }

    public Catalog getCatalogBySheet(String sheet) {
        Catalog catalog = new Catalog();
        AsyncTask task = new GetCatalogBySheet(mCatalogDao, sheet).execute();
        try {
            catalog = (Catalog) task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return catalog;
    }



    private static class InsertCatalogAsyncTask extends AsyncTask<Catalog, Void, Void> {
        private CatalogDao mCatalogDao;

        private InsertCatalogAsyncTask(CatalogDao catalogDao) {
            mCatalogDao = catalogDao;
        }

        @Override
        protected Void doInBackground(Catalog... catalogs) {
            mCatalogDao.insert(catalogs[0]);
            return null;
        }
    }

    private static class UpdateCatalogAsyncTask extends AsyncTask<Catalog, Void, Void> {
        private CatalogDao mCatalogDao;

        private UpdateCatalogAsyncTask(CatalogDao catalogDao) {
            mCatalogDao = catalogDao;
        }

        @Override
        protected Void doInBackground(Catalog... catalogs) {
            mCatalogDao.update(catalogs[0]);
            return null;
        }
    }

    private static class DeleteCatalogAsyncTask extends AsyncTask<Catalog, Void, Void> {
        private CatalogDao mCatalogDao;

        private DeleteCatalogAsyncTask(CatalogDao catalogDao) {
            mCatalogDao = catalogDao;
        }

        @Override
        protected Void doInBackground(Catalog... catalogs) {
            mCatalogDao.delete(catalogs[0]);
            return null;
        }
    }

    private static class DeleteAllCatalogsAsyncTask extends AsyncTask<Void, Void, Void> {
        private CatalogDao mCatalogDao;

        public DeleteAllCatalogsAsyncTask(CatalogDao catalogDao) {
            mCatalogDao = catalogDao;
        }


        @Override
        protected Void doInBackground(Void... voids) {
            mCatalogDao.deleteAll();
            return null;
        }
    }

    private static class GetCatalogByName extends AsyncTask<Void, Void, Catalog> {
        private CatalogDao mCatalogDao;
        private String name;

        public GetCatalogByName(CatalogDao catalogDao, String name) {
            this.name = name;
            mCatalogDao = catalogDao;
        }

        @Override
        protected Catalog doInBackground(Void... voids) {
            return mCatalogDao.getCatalogByName(name);
        }

        @Override
        protected void onPostExecute(Catalog catalog) {
            super.onPostExecute(catalog);
        }
    }

    private static class GetCatalogByPlace extends AsyncTask<Void, Void, Catalog> {
        private CatalogDao mCatalogDao;
        private String place;

        public GetCatalogByPlace(CatalogDao catalogDao, String place) {
            this.place = place;
            mCatalogDao = catalogDao;
        }

        @Override
        protected Catalog doInBackground(Void... voids) {
            return mCatalogDao.getCatalogByPlace(place);
        }

        @Override
        protected void onPostExecute(Catalog catalog) {
            super.onPostExecute(catalog);
        }
    }

    private static class GetCatalogByCity extends AsyncTask<Void, Void, Catalog> {
        private CatalogDao mCatalogDao;
        private String city;

        public GetCatalogByCity(CatalogDao catalogDao, String city) {
            this.city = city;
            mCatalogDao = catalogDao;
        }

        @Override
        protected Catalog doInBackground(Void... voids) {
            return mCatalogDao.getCatalogByCity(city);
        }

        @Override
        protected void onPostExecute(Catalog catalog) {
            super.onPostExecute(catalog);
        }
    }

    private static class GetCatalogByPublish extends AsyncTask<Void, Void, Catalog> {
        private CatalogDao mCatalogDao;
        private String publish;

        public GetCatalogByPublish(CatalogDao catalogDao, String publish) {
            this.publish = publish;
            mCatalogDao = catalogDao;
        }

        @Override
        protected Catalog doInBackground(Void... voids) {
            return mCatalogDao.getCatalogByPublish(publish);
        }

        @Override
        protected void onPostExecute(Catalog catalog) {
            super.onPostExecute(catalog);
        }
    }

    private static class GetCatalogByYear extends AsyncTask<Void, Void, Catalog> {
        private CatalogDao mCatalogDao;
        private String year;

        public GetCatalogByYear(CatalogDao catalogDao, String year) {
            this.year = year;
            mCatalogDao = catalogDao;
        }

        @Override
        protected Catalog doInBackground(Void... voids) {
            return mCatalogDao.getCatalogByYear(year);
        }

        @Override
        protected void onPostExecute(Catalog catalog) {
            super.onPostExecute(catalog);
        }
    }

    private static class GetCatalogBySheet extends AsyncTask<Void, Void, Catalog> {
        private CatalogDao mCatalogDao;
        private String sheet;

        public GetCatalogBySheet(CatalogDao catalogDao, String sheet) {
            this.sheet = sheet;
            mCatalogDao = catalogDao;
        }

        @Override
        protected Catalog doInBackground(Void... voids) {
            return mCatalogDao.getCatalogByYear(sheet);
        }

        @Override
        protected void onPostExecute(Catalog catalog) {
            super.onPostExecute(catalog);
        }
    }

}
