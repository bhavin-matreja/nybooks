package bhavin.nybooks.ui.bookslist;

import java.util.ArrayList;

import bhavin.nybooks.model.BooksListByNameResponse;
import bhavin.nybooks.ui.base.IBasePresenter;
import bhavin.nybooks.ui.base.IBaseView;

/**
 * Created by Bhavin on 4/24/2018.
 */

public interface BooksListContract {

    interface IBooksListView extends IBaseView {

        void addBooksListToRecyclerAdapter(ArrayList<BooksListByNameResponse.Book> books);
    }

    interface IBooksListPresenter extends IBasePresenter<IBooksListView> {

        void getBooksListFromAPI(String strBookCategoryEncode);
    }
}
