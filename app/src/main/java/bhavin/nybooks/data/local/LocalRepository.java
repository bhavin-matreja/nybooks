package bhavin.nybooks.data.local;

import android.util.Log;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import bhavin.nybooks.App;
import bhavin.nybooks.data.DataRepository;
import bhavin.nybooks.model.bookcategory.BooksCategoriesResponse;
import bhavin.nybooks.model.BooksListByNameResponse;
import bhavin.nybooks.model.bookcategory.CategoryListModel;
import io.reactivex.Maybe;
import io.reactivex.MaybeEmitter;
import io.reactivex.MaybeOnSubscribe;

/**
 * Created by Bhavin on 4/25/2018.
 */

public class LocalRepository extends DataRepository {

    private static LocalRepository instance;
    private DatabaseHelper databaseHelper = null;

    public static LocalRepository getInstance() {

        synchronized (LocalRepository.class) {
            if (instance == null) {
                instance = new LocalRepository();
            }

            return instance;
        }
    }

    public void createBooksCategory(ArrayList<CategoryListModel> result) {
        try {
            //Log.d("createBooksCategory", "LIST SIZE " + result.size());
            Dao<CategoryListModel, Integer> booksCategoryDao = getHelper().getBooksCategoryDao();

            DeleteBuilder<CategoryListModel, Integer> deleteBuilder = booksCategoryDao.deleteBuilder();
            deleteBuilder.delete();
            /*ArrayList<CategoryListModel> categoryList = (ArrayList<CategoryListModel>) booksCategoryDao.queryForAll();
            Log.d("CategoryList Size===", "" + categoryList.size());*/

            int insertedRows = booksCategoryDao.create(result);
            Log.d("LocalRepository", "insertedRows" + insertedRows);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private DatabaseHelper getHelper() {
        if (databaseHelper == null) {
            databaseHelper = OpenHelperManager.getHelper(App.getInstance().getApplicationContext(), DatabaseHelper.class);
        }
        return databaseHelper;
    }

    @Override
    public Maybe<BooksCategoriesResponse> getBooksCategories() {
        try {
            Dao<CategoryListModel, Integer> dao = getHelper().getBooksCategoryDao();
            ArrayList<CategoryListModel> categoryList = (ArrayList<CategoryListModel>) dao.queryForAll();
            Iterator<CategoryListModel> iterable = categoryList.iterator();
            Log.d("Local Repo", "List Size" + categoryList.size());
            while (iterable.hasNext()) {
                CategoryListModel value = iterable.next();
                Log.d("LocalRepo", "Title" + value.getListName());
            }
            final BooksCategoriesResponse booksCategoriesResponse = new BooksCategoriesResponse("OK", "", categoryList.size(), categoryList);
            return Maybe.create(new MaybeOnSubscribe<BooksCategoriesResponse>() {

                @Override
                public void subscribe(MaybeEmitter<BooksCategoriesResponse> e) throws Exception {
                    e.onSuccess(booksCategoriesResponse);
                }
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Maybe<BooksListByNameResponse> getBooksListFromCategory(String categoryName) {
        return null;
    }
}
