package bhavin.nybooks.ui.category;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import bhavin.nybooks.R;
import bhavin.nybooks.model.bookcategory.CategoryListModel;
import bhavin.nybooks.util.IntentConstant;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Bhavin on 4/20/2018.
 */

public class BooksCategoryAdapter extends RecyclerView.Adapter<BooksCategoryAdapter.ViewHolder> {


    private ArrayList<CategoryListModel> categoriesList;
    private Context context;
    private RequestOptions requesOptions;

    public BooksCategoryAdapter(ArrayList<CategoryListModel> results, Context context, RequestOptions requesOptions) {
        this.categoriesList = results;
        this.context = context;
        this.requesOptions = requesOptions;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book_category, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvBookCategoryName.setText(categoriesList.get(position).getDisplayName());
        Glide.with(context)
                .load(R.drawable.bookcategory)
                .apply(requesOptions)
                .into(holder.ivBookImage);
    }


    @Override
    public int getItemCount() {
        return categoriesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.iv_category_image) ImageView ivBookImage;
        @BindView(R.id.tv_category_name) TextView tvBookCategoryName;
        @BindView(R.id.rel_lay_category_container) RelativeLayout categoryContainer;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.rel_lay_category_container)
        public void OnCategoryContainerClicked() {
            CategoryListModel selectedCategory = categoriesList.get(getAdapterPosition());
            Intent intent = new Intent(context, bhavin.nybooks.ui.bookslist.BooksListActivity.class);
            intent.putExtra(IntentConstant.KEY_TITLE_ENCODE, selectedCategory.getListNameEncoded());
            context.startActivity(intent);
        }
    }
}
