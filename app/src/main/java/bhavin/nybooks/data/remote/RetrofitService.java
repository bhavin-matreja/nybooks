package bhavin.nybooks.data.remote;

import bhavin.nybooks.model.bookcategory.BooksCategoriesResponse;
import bhavin.nybooks.model.BooksListByNameResponse;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


/**
 * Created by Bhavin on 4/9/2018.
 */

public interface RetrofitService {

       @GET("lists/names.json")
       Single<BooksCategoriesResponse> getBooksCategories(@Query("api-key") String apiKey);

       @GET("lists//{list}.json")
       Single<BooksListByNameResponse> getBooksListByCategoryName(@Path("list") String listName,
                                                                  @Query("api-key") String apiKey);
}
