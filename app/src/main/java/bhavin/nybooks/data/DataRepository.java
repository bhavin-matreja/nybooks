package bhavin.nybooks.data;

import bhavin.nybooks.model.bookcategory.BooksCategoriesResponse;
import bhavin.nybooks.model.BooksListByNameResponse;
import io.reactivex.Maybe;


/**
 * Created by Bhavin on 4/9/2018.
 */

public abstract class DataRepository {

       public abstract Maybe<BooksCategoriesResponse> getBooksCategories();

       public abstract Maybe<BooksListByNameResponse> getBooksListFromCategory(String categoryName);
}