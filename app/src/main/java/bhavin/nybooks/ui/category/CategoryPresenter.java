package bhavin.nybooks.ui.category;

import android.util.Log;

import com.google.gson.Gson;

import bhavin.nybooks.domain.AppUseCase;
import bhavin.nybooks.model.bookcategory.BooksCategoriesResponse;
import bhavin.nybooks.ui.base.BasePresenter;
import bhavin.nybooks.util.Utility;
import io.reactivex.observers.DisposableMaybeObserver;

/**
 * Created by Bhavin on 4/25/2018.
 */

public class CategoryPresenter extends BasePresenter<CategoryContract.ICategoryView>
        implements CategoryContract.ICategoryPresenter {

    AppUseCase useCase;
    private BooksCategoriesResponse categoryResponse;

    public CategoryPresenter(CategoryContract.ICategoryView view) {
        this.view = view;
        this.useCase = new AppUseCase();
    }

    @Override
    public void getCategoriesFromAPI() {
        useCase.getBooksCategories().subscribe(new CategoryObserver());
    }

    private void onCategoryAPIResponseError(Throwable e) {

        if (view != null) {
            view.showToastMessage(Utility.getErrorMessage(e));
        }
    }

    private void onCategoryAPIResponseSuccess(BooksCategoriesResponse categoryResponse) {
        this.categoryResponse = categoryResponse;
        if (view != null) {
            view.addCategoriesToRecyclerView(categoryResponse);
        }
    }

    @Override
    public void onViewActive(CategoryContract.ICategoryView view) {
        super.onViewActive(view);
        if (categoryResponse != null) {
            onCategoryAPIResponseSuccess(categoryResponse);
        }
    }

    public class CategoryObserver extends DisposableMaybeObserver<BooksCategoriesResponse> {


        @Override
        public void onSuccess(BooksCategoriesResponse categoryResponse) {
            Log.d("RESPONSE", new Gson().toJson(categoryResponse));
            onCategoryAPIResponseSuccess(categoryResponse);
        }

        @Override
        public void onError(Throwable e) {
            onCategoryAPIResponseError(e);
        }

        @Override
        public void onComplete() {

        }
    }

/*    private class CategoryObserver extends DisposableSingleObserver<CategoryResponse> {

        @Override
        public void onSuccess(CategoryResponse categoryResponse) {
            Log.d("RESPONSE", new Gson().toJson(categoryResponse));
            onCategoryAPIResponseSuccess(categoryResponse);
        }

        @Override
        public void onError(Throwable e) {
            onCategoryAPIResponseError(e);
        }
    }*/
}
