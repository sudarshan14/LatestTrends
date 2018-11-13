package sid.bhatt.latesttrends.androidViewModelWithDB.viewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import sid.bhatt.latesttrends.androidViewModelWithDB.db.DbSettings;
import sid.bhatt.latesttrends.androidViewModelWithDB.db.FavouritesDbHelper;
import sid.bhatt.latesttrends.androidViewModelWithDB.model.Favourite;

public class FavouritesViewModel extends AndroidViewModel {

    private FavouritesDbHelper favouritesDbHelper;
    private ArrayList<Favourite> favourites;

    public FavouritesViewModel(Application application) {
        super(application);

        favouritesDbHelper = new FavouritesDbHelper(application);

    }


    public List<Favourite> getFavourites() {

        if (favourites == null) {
            favourites = new ArrayList<>();
            createDummyList();
            loadData();
        }

        return favourites;
    }

    private void loadData() {


        favourites.clear();

        SQLiteDatabase db = favouritesDbHelper.getReadableDatabase();
        Cursor cursor = db.query(DbSettings.DBEntry.TABLE,
                new String[]{DbSettings.DBEntry._ID, DbSettings.DBEntry.COL_FAV_URL, DbSettings.DBEntry.COL_FAV_DATE},
                null, null, null, null, null);
        while (cursor.moveToNext()) {

            int idxId = cursor.getColumnIndex(DbSettings.DBEntry._ID);
            int idxUrl = cursor.getColumnIndex(DbSettings.DBEntry.COL_FAV_URL);
            int idxDate = cursor.getColumnIndex(DbSettings.DBEntry.COL_FAV_DATE);

            favourites.add(new Favourite(cursor.getLong(idxId), cursor.getString(idxUrl), cursor.getLong(idxDate)));
        }
        cursor.close();
        db.close();
    }

    private void createDummyList() {


        addFav("https://www.journaldev.com", (new Date()).getTime());
//        addFav("https://www.medium.com", (new Date()).getTime());
//        addFav("https://www.reddit.com", (new Date()).getTime());
//        addFav("https://www.github.com", (new Date()).getTime());
//        addFav("https://www.hackerrank.com", (new Date()).getTime());
//        addFav("https://www.developers.android.com", (new Date()).getTime());
    }

    private void addFav(String url, long date) {

        SQLiteDatabase db = favouritesDbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DbSettings.DBEntry.COL_FAV_URL, url);
        contentValues.put(DbSettings.DBEntry.COL_FAV_DATE, date);

        long id = db.insertWithOnConflict(DbSettings.DBEntry.TABLE, null,
                contentValues, SQLiteDatabase.CONFLICT_REPLACE);
        db.close();
        Favourite favourite = new Favourite(id, url, date);
        favourites.add(favourite);
      //  return new Favourite(favourite);

    }

    private void removeFavourite(long id) {

        SQLiteDatabase db = favouritesDbHelper.getWritableDatabase();
        db.delete(DbSettings.DBEntry.TABLE, DbSettings.DBEntry._ID + " = ?", new String[]{Long.toString(id)});
        db.close();

//        int index = -1;
        for (int i = 0; i < favourites.size(); i++) {
            Favourite fav = favourites.get(i);
            if (fav.mId == id) {
//                index = i;
                favourites.remove(i);
                break;
            }
        }
//        if(index != -1){
//            favourites.remove(index);
//        }
    }
}
