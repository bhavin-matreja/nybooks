package bhavin.nybooks.domain;

import bhavin.nybooks.data.local.LocalRepository;
import bhavin.nybooks.data.remote.RemoteRepository;
import bhavin.nybooks.model.bookcategory.BooksCategoriesResponse;
import bhavin.nybooks.model.BooksListByNameResponse;
import bhavin.nybooks.data.remote.RetrofitFactory;
import bhavin.nybooks.util.NetworkHelper;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;


/**
 * Created by Bhavin on 4/9/2018.
 */

public class AppUseCase {

    private CompositeDisposable compositeDisposable;
    private LocalRepository localRepository;
    private RemoteRepository remoteRepository;
    private NetworkHelper networkHelper;

    public AppUseCase() {
        this.networkHelper = NetworkHelper.getInstance();
        this.compositeDisposable = new CompositeDisposable();
        this.localRepository = LocalRepository.getInstance();
        this.remoteRepository = new RemoteRepository(RetrofitFactory.getAdapter());
    }

    public MaybeSource<BooksCategoriesResponse> getBooksCategories() {
        if (networkHelper.isNetworkAvailable()) {
            return remoteRepository.getBooksCategories();
        }else {
            return localRepository.getBooksCategories();
        }
    }

    public MaybeSource<BooksListByNameResponse> getBooksListFromCategory(String categoryName) {
        if (networkHelper.isNetworkAvailable()) {
            return remoteRepository.getBooksListFromCategory(categoryName);
        }else {
            return remoteRepository.getBooksListFromCategory(categoryName);
        }
    }



    public void addToCompositeDisposable(Disposable disposable) {
        compositeDisposable.add(disposable);
    }

    public void DisposeCompositeDisposable() {
        if(compositeDisposable!=null && !compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
    }
}
