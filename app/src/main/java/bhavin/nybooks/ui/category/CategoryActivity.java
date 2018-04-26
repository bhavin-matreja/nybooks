package bhavin.nybooks.ui.category;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.bumptech.glide.request.RequestOptions;

import bhavin.nybooks.R;
import bhavin.nybooks.domain.AppUseCase;
import bhavin.nybooks.model.bookcategory.BooksCategoriesResponse;
import bhavin.nybooks.ui.base.BaseActivity;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Bhavin on 4/24/2018.
 */

public class CategoryActivity extends BaseActivity implements CategoryContract.ICategoryView {

    private CategoryContract.ICategoryPresenter presenter;
    private static final String TAG = "MainActivity";
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindString(R.string.title_books_categories) String strBookCategories;
    private BooksCategoryAdapter adapter;
    private AppUseCase useCase;
    private RequestOptions requesOptions;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(strBookCategories);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        presenter = new CategoryPresenter(this);
        presenter.getCategoriesFromAPI();
        requesOptions = new RequestOptions().placeholder(R.drawable.placeholder).error(R.drawable.error);
    }

    @Override
    public void addCategoriesToRecyclerView(BooksCategoriesResponse categoryResponse) {
        adapter = new BooksCategoryAdapter(categoryResponse.getResults(), this,requesOptions);
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


}
