package bhavin.nybooks.data.remote;

import bhavin.nybooks.data.DataRepository;
import bhavin.nybooks.data.local.LocalRepository;
import bhavin.nybooks.model.bookcategory.BooksCategoriesResponse;
import bhavin.nybooks.model.BooksListByNameResponse;
import io.reactivex.Maybe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Created by Bhavin on 4/25/2018.
 */

public class RemoteRepository extends DataRepository {

    RetrofitService service;
    private String apiKey="aeeddbeacaad46449993e0ff726e3d8b";

    public RemoteRepository(Retrofit retrofit) {
        this.service = retrofit.create(RetrofitService.class);
    }

    @Override
    public Maybe<BooksCategoriesResponse>  getBooksCategories() {
        return service.getBooksCategories(apiKey)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSuccess(new Consumer<BooksCategoriesResponse>() {
                    @Override
                    public void accept(BooksCategoriesResponse booksCategoriesResponse) throws Exception {
                        LocalRepository.getInstance().createBooksCategory(booksCategoriesResponse.getResults());
                    }
                })
                .toMaybe();
    }

    @Override
    public Maybe<BooksListByNameResponse> getBooksListFromCategory(String categoryName) {
        return service.getBooksListByCategoryName(categoryName,apiKey)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .toMaybe();
    }
}
