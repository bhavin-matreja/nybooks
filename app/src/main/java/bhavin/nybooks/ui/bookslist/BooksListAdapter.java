package bhavin.nybooks.ui.bookslist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import bhavin.nybooks.R;
import bhavin.nybooks.model.BooksListByNameResponse;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Bhavin on 4/23/2018.
 */

public class BooksListAdapter extends RecyclerView.Adapter<BooksListAdapter.ViewHolder> {

    private ArrayList<BooksListByNameResponse.Book> bookList;
    private Context context;
    private RequestOptions requesOptions;

    public BooksListAdapter(ArrayList<BooksListByNameResponse.Book> books, Context context, RequestOptions requesOptions) {
        bookList = books;
        this.context = context;
        this.requesOptions = requesOptions;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book_list, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvBookTitle.setText(bookList.get(position).getTitle());
        holder.tvBookAuthor.setText(bookList.get(position).getAuthor());
        Glide.with(context)
                .load(bookList.get(position).getBookImage())
                .apply(requesOptions)
                .thumbnail(Glide.with(context).load(bookList.get(position).getBookImage()))
                .into(holder.ivBookImage);
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.iv_book_image) ImageView ivBookImage;
        @BindView(R.id.tv_book_title) TextView tvBookTitle;
        @BindView(R.id.tv_book_author) TextView tvBookAuthor;
        @BindView(R.id.card_view) CardView cardView;
        
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.card_view)
        public void OnBookItemClicked() {
            BooksListByNameResponse.Book book = bookList.get(getAdapterPosition());
            Log.d("BOOK NAME", book.getTitle());
        }
    }
}
