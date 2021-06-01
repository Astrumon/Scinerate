package com.kpi.scineticle.model.subsystemOfDataBase.electronic_resource;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.kpi.scineticle.model.subsystemOfDataBase.UserDatabase;


import java.util.List;
import java.util.concurrent.ExecutionException;

public class ElectronicResourceRepository {
    private ElectronicResourceDao mElectronicResourceDao;
    private LiveData<List<ElectronicResource>> allElectronicResources;

    public ElectronicResourceRepository(Application application) {
        UserDatabase database = UserDatabase.getInstance(application);
        mElectronicResourceDao = database.electronicResourceDao();
        allElectronicResources = mElectronicResourceDao.getAllElectronicResources();
    }

    public void insert(ElectronicResource electronicResource) {
        new InsertElectronicAsyncTask(mElectronicResourceDao).execute(electronicResource);
    }

    public void update(ElectronicResource electronicResource) {
        new UpdateElectronicResourceAsyncTask(mElectronicResourceDao).execute(electronicResource);
    }

    public void delete(ElectronicResource electronicResource) {
        new DeleteElectronicResourceAsyncTask(mElectronicResourceDao).execute(electronicResource);
    }

    public void deleteAllElectronicResources() {
        new DeleteAllElectronicResourceAsyncTask(mElectronicResourceDao).execute();
    }

    public void deleteAllElectronicResources(String userLogin) {
        new DeleteAllElectronicResourcesByUserLoginAsyncTask(mElectronicResourceDao, userLogin).execute();
    }

    public LiveData<List<ElectronicResource>> getAllElectronicResources() {
        return allElectronicResources;
    }

    public ElectronicResource getElectronicResourceByName(String name) {
        ElectronicResource electronicResource = new ElectronicResource();
        AsyncTask task = new GetElectronicResourceByName(mElectronicResourceDao, name).execute();
        try {
            electronicResource = (ElectronicResource) task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return electronicResource;
    }

    public ElectronicResource getElectronicResourceByPlacePublish(String placePublish) {
        ElectronicResource electronicResource = new ElectronicResource();
        AsyncTask task = new GetElectronicResourceByPlacePublish(mElectronicResourceDao, placePublish).execute();
        try {
            electronicResource = (ElectronicResource) task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return electronicResource;
    }

    public ElectronicResource getElectronicResourceByPublish(String publish) {
        ElectronicResource electronicResource = new ElectronicResource();
        AsyncTask task = new GetElectronicResourceByPublish(mElectronicResourceDao, publish).execute();
        try {
            electronicResource = (ElectronicResource) task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return electronicResource;
    }

    public ElectronicResource getElectronicResourceByDate(String date) {
        ElectronicResource electronicResource = new ElectronicResource();
        AsyncTask task = new GetElectronicResourceByDate(mElectronicResourceDao, date).execute();
        try {
            electronicResource = (ElectronicResource) task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return electronicResource;
    }

    public ElectronicResource getElectronicResourceByUpdateDate(String updateDate) {
        ElectronicResource electronicResource = new ElectronicResource();
        AsyncTask task = new GetElectronicResourceByUpdateDate(mElectronicResourceDao, updateDate).execute();
        try {
            electronicResource = (ElectronicResource) task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return electronicResource;
    }

    public ElectronicResource getElectronicResourceByUrl(String url) {
        ElectronicResource electronicResource = new ElectronicResource();
        AsyncTask task = new GetElectronicResourceByUrl(mElectronicResourceDao, url).execute();
        try {
            electronicResource = (ElectronicResource) task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return electronicResource;
    }

    public LiveData<List<ElectronicResource>> getAllElectronicResourcesByLogin(String userLogin) {

        AsyncTask task = new GetALlElectronicResourcesByLogin(mElectronicResourceDao, userLogin).execute();
        try {
            LiveData<List<ElectronicResource>>  electronicResources = (LiveData<List<ElectronicResource>>) task.get();
            return electronicResources;
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return null;
    }


    private static class InsertElectronicAsyncTask extends AsyncTask<ElectronicResource, Void, Void> {
        private ElectronicResourceDao mElectronicResourceDao;

        private InsertElectronicAsyncTask(ElectronicResourceDao electronicResourceDao) {
            mElectronicResourceDao = electronicResourceDao;
        }

        @Override
        protected Void doInBackground(ElectronicResource... electronicResources) {
            mElectronicResourceDao.insert(electronicResources[0]);
            return null;
        }
    }

    private static class UpdateElectronicResourceAsyncTask extends AsyncTask<ElectronicResource, Void, Void> {
        private ElectronicResourceDao mElectronicResource;

        public UpdateElectronicResourceAsyncTask(ElectronicResourceDao electronicResource) {
            mElectronicResource = electronicResource;
        }

        @Override
        protected Void doInBackground(ElectronicResource... electronicResources) {
            mElectronicResource.update(electronicResources[0]);
            return null;
        }
    }

    private static class DeleteAllElectronicResourcesByUserLoginAsyncTask extends AsyncTask<Void, Void, Void> {
        private ElectronicResourceDao mElectronicResourceDao1;
        private String userLogin;

        public DeleteAllElectronicResourcesByUserLoginAsyncTask(ElectronicResourceDao electronicResourceDao, String userLogin) {
            mElectronicResourceDao1 = electronicResourceDao;
            this.userLogin = userLogin;
        }


        @Override
        protected Void doInBackground(Void... voids) {
            mElectronicResourceDao1.deleteAllByUserLogin(userLogin);
            return null;
        }
    }

    private static class DeleteElectronicResourceAsyncTask extends AsyncTask<ElectronicResource, Void, Void> {
        private ElectronicResourceDao mElectronicResourceDao;

        public DeleteElectronicResourceAsyncTask(ElectronicResourceDao electronicResourceDao) {
            mElectronicResourceDao = electronicResourceDao;
        }

        @Override
        protected Void doInBackground(ElectronicResource... electronicResources) {
            mElectronicResourceDao.delete(electronicResources[0]);
            return null;
        }
    }

    private static class DeleteAllElectronicResourceAsyncTask extends AsyncTask<Void, Void, Void> {
        private ElectronicResourceDao mElectronicResourceDao;

        public DeleteAllElectronicResourceAsyncTask(ElectronicResourceDao electronicResourceDao) {
            mElectronicResourceDao = electronicResourceDao;
        }


        @Override
        protected Void doInBackground(Void... voids) {
            mElectronicResourceDao.deleteAll();
            return null;
        }
    }

    private static class GetElectronicResourceByName extends AsyncTask<Void, Void, ElectronicResource> {
        private ElectronicResourceDao mElectronicResourceDao;
        private String name;

        public GetElectronicResourceByName(ElectronicResourceDao electronicResourceDao, String name) {
            this.name = name;
            mElectronicResourceDao = electronicResourceDao;

        }

        @Override
        protected ElectronicResource doInBackground(Void... voids) {
            return mElectronicResourceDao.getElectronicByName(name);
        }

        @Override
        protected void onPostExecute(ElectronicResource electronicResource) {
            super.onPostExecute(electronicResource);
        }
    }

    private static class GetElectronicResourceByPlacePublish extends AsyncTask<Void, Void, ElectronicResource> {
        private ElectronicResourceDao mElectronicResourceDao;
        private String placePublish;

        public GetElectronicResourceByPlacePublish(ElectronicResourceDao electronicResourceDao, String placePublish) {
            this.placePublish = placePublish;
            mElectronicResourceDao = electronicResourceDao;

        }

        @Override
        protected ElectronicResource doInBackground(Void... voids) {
            return mElectronicResourceDao.getElectronicByPlacePublish(placePublish);
        }

        @Override
        protected void onPostExecute(ElectronicResource electronicResource) {
            super.onPostExecute(electronicResource);
        }
    }

    private static class GetElectronicResourceByPublish extends AsyncTask<Void, Void, ElectronicResource> {
        private ElectronicResourceDao mElectronicResourceDao;
        private String publish;

        public GetElectronicResourceByPublish(ElectronicResourceDao electronicResourceDao, String publish) {
            this.publish = publish;
            mElectronicResourceDao = electronicResourceDao;

        }

        @Override
        protected ElectronicResource doInBackground(Void... voids) {
            return mElectronicResourceDao.getElectronicByPublish(publish);
        }

        @Override
        protected void onPostExecute(ElectronicResource electronicResource) {
            super.onPostExecute(electronicResource);
        }
    }

    private static class GetElectronicResourceByDate extends AsyncTask<Void, Void, ElectronicResource> {
        private ElectronicResourceDao mElectronicResourceDao;
        private String date;

        public GetElectronicResourceByDate(ElectronicResourceDao electronicResourceDao, String date) {
            this.date = date;
            mElectronicResourceDao = electronicResourceDao;

        }

        @Override
        protected ElectronicResource doInBackground(Void... voids) {
            return mElectronicResourceDao.getElectronicByDate(date);
        }

        @Override
        protected void onPostExecute(ElectronicResource electronicResource) {
            super.onPostExecute(electronicResource);
        }
    }

    private static class GetElectronicResourceByUpdateDate extends AsyncTask<Void, Void, ElectronicResource> {
        private ElectronicResourceDao mElectronicResourceDao;
        private String updateDate;

        public GetElectronicResourceByUpdateDate(ElectronicResourceDao electronicResourceDao, String updateDate) {
            this.updateDate = updateDate;
            mElectronicResourceDao = electronicResourceDao;

        }

        @Override
        protected ElectronicResource doInBackground(Void... voids) {
            return mElectronicResourceDao.getElectronicByUpdateDate(updateDate);
        }

        @Override
        protected void onPostExecute(ElectronicResource electronicResource) {
            super.onPostExecute(electronicResource);
        }
    }

    private static class GetElectronicResourceByUrl extends AsyncTask<Void, Void, ElectronicResource> {
        private ElectronicResourceDao mElectronicResourceDao;
        private String url;

        public GetElectronicResourceByUrl(ElectronicResourceDao electronicResourceDao, String url) {
            this.url = url;
            mElectronicResourceDao = electronicResourceDao;

        }

        @Override
        protected ElectronicResource doInBackground(Void... voids) {
            return mElectronicResourceDao.getElectronicByUrl(url);
        }

        @Override
        protected void onPostExecute(ElectronicResource electronicResource) {
            super.onPostExecute(electronicResource);
        }
    }

    private static class GetALlElectronicResourcesByLogin extends AsyncTask<Void, Void, LiveData<List<ElectronicResource>>> {
        private ElectronicResourceDao mElectronicResourceDao;
        private String userLogin;

        public GetALlElectronicResourcesByLogin(ElectronicResourceDao electronicResourceDao, String userLogin) {
            mElectronicResourceDao = electronicResourceDao;
            this.userLogin = userLogin;
        }

        @Override
        protected LiveData<List<ElectronicResource>> doInBackground(Void... voids) {
            return mElectronicResourceDao.getAllElectronicResourcesByLogin(userLogin);
        }

        @Override
        protected void onPostExecute(LiveData<List<ElectronicResource>> listLiveData) {
            super.onPostExecute(listLiveData);
        }
    }


}
