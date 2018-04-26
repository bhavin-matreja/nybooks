package bhavin.nybooks.ui.category;

import bhavin.nybooks.model.bookcategory.BooksCategoriesResponse;
import bhavin.nybooks.ui.base.IBasePresenter;
import bhavin.nybooks.ui.base.IBaseView;

/**
 * Created by Bhavin on 4/24/2018.
 */

public interface CategoryContract {

    interface ICategoryView extends IBaseView {

        void addCategoriesToRecyclerView(BooksCategoriesResponse categoryResponse);
    }

    interface ICategoryPresenter extends IBasePresenter<ICategoryView> {

        void getCategoriesFromAPI();


    }
}
