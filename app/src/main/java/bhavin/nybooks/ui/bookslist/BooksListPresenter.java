package bhavin.nybooks.ui.bookslist;

import android.util.Log;

import com.google.gson.Gson;

import bhavin.nybooks.domain.AppUseCase;
import bhavin.nybooks.model.BooksListByNameResponse;
import bhavin.nybooks.ui.base.BasePresenter;
import bhavin.nybooks.util.Utility;
import io.reactivex.observers.DisposableMaybeObserver;

/**
 * Created by Bhavin on 4/25/2018.
 */

public class BooksListPresenter extends BasePresenter<BooksListContract.IBooksListView> implements BooksListContract.IBooksListPresenter {

    private AppUseCase useCase;

    public BooksListPresenter(BooksListContract.IBooksListView view) {
        this.view = view;
        this.useCase = new AppUseCase();
    }

    @Override
    public void getBooksListFromAPI(String strBookCategoryEncode) {
        useCase.getBooksListFromCategory(strBookCategoryEncode).subscribe(new BooksListObserver());
    }

    private void onBooksListFetchFailure(Throwable e) {
        if(view!=null){
            view.showToastMessage(Utility.getErrorMessage(e));
        }
    }

    private void OnBooksListFetchSuccess(BooksListByNameResponse booksListResponse) {
        Log.d("BOOK LIST RESPONSE", new Gson().toJson(booksListResponse));
        if (view != null) {
            view.addBooksListToRecyclerAdapter(booksListResponse.getResults().getBooks());
        }
    }

    private class BooksListObserver extends DisposableMaybeObserver<BooksListByNameResponse>{

        @Override
        public void onSuccess(BooksListByNameResponse booksListByNameResponse) {
            OnBooksListFetchSuccess(booksListByNameResponse);

        }

        @Override
        public void onError(Throwable e) {
            onBooksListFetchFailure(e);
        }

        @Override
        public void onComplete() {

        }
    }


}
