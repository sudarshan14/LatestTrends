package sid.bhatt.latesttrends.androidViewModelWithDB.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class FavouritesDbHelper extends SQLiteOpenHelper {


    public FavouritesDbHelper(Context context) {
        super(context, DbSettings.DB_NAME, null, DbSettings.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String ct = "CREATE TABLE " + DbSettings.DBEntry.TABLE + " ( " +
                DbSettings.DBEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                DbSettings.DBEntry.COL_FAV_URL + " TEXT NOT NULL, " +
                DbSettings.DBEntry.COL_FAV_DATE + " INTEGER NOT NULL);";

        String createTable = "CREATE TABLE " + DbSettings.DBEntry.TABLE + " ( " +
                DbSettings.DBEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                DbSettings.DBEntry.COL_FAV_URL + " TEXT NOT NULL, " +
                DbSettings.DBEntry.COL_FAV_DATE + " INTEGER NOT NULL);";


        sqLiteDatabase.execSQL(createTable);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
