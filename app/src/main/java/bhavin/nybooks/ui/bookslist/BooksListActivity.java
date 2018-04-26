package bhavin.nybooks.ui.bookslist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import bhavin.nybooks.R;
import bhavin.nybooks.model.BooksListByNameResponse;
import bhavin.nybooks.ui.base.BaseActivity;
import bhavin.nybooks.util.IntentConstant;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Bhavin on 4/24/2018.
 */

public class BooksListActivity extends BaseActivity implements BooksListContract.IBooksListView {

    private static final String TAG = "BooksListActivity";

    @BindView(R.id.recycler_view)  RecyclerView recyclerView;
    @BindView(R.id.toolbar)  Toolbar toolbar;
    @BindString(R.string.title_books_categories) String strBookCategories;

    private String strSelectedCategoryEncode;
    BooksListAdapter adapter;

    private BooksListContract.IBooksListPresenter presenter;
    private RequestOptions requesOptions;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        if (getIntent().hasExtra(IntentConstant.KEY_TITLE_ENCODE)) {
            strSelectedCategoryEncode = getIntent().getStringExtra(IntentConstant.KEY_TITLE_ENCODE);
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.title_books_list);

        presenter = new BooksListPresenter(this);
        presenter.getBooksListFromAPI(strSelectedCategoryEncode);

        requesOptions = new RequestOptions().placeholder(R.drawable.placeholder).error(R.drawable.error);

    }

    @Override
    public void addBooksListToRecyclerAdapter(ArrayList<BooksListByNameResponse.Book> books) {
        adapter = new BooksListAdapter(books,this,requesOptions);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onViewActive(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.onViewInactive();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
