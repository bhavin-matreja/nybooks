package bhavin.nybooks.data.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

import bhavin.nybooks.model.bookcategory.CategoryListModel;

/**
 * Created by Bhavin on 4/25/2018.
 */

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME = "books.db";
    private static final int DATABASE_VERSION=1;

    private Dao<CategoryListModel,Integer> booksCategoryDao;
    private ConnectionSource connectionSource;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        this.connectionSource = connectionSource;
        try {
            TableUtils.createTable(connectionSource, CategoryListModel.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i1) {

    }

    public Dao<CategoryListModel,Integer> getBooksCategoryDao() throws SQLException{
        if (booksCategoryDao == null) {
            booksCategoryDao = getDao(CategoryListModel.class);
        }
        return booksCategoryDao;
    }

    public void deleteCategoryListTable() throws SQLException {
        TableUtils.clearTable(connectionSource, CategoryListModel.class);
    }


}
