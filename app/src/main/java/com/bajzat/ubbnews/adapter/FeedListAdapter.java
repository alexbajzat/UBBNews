package com.bajzat.ubbnews.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import com.bajzat.ubbnews.R;
import com.bajzat.ubbnews.model.FeedItem;
import com.bajzat.ubbnews.service.FeedService;
import com.bajzat.ubbnews.util.Observable;
import com.bajzat.ubbnews.util.Observer;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bjz on 3/25/2017.
 */

public class FeedListAdapter extends RecyclerView.Adapter<FeedListAdapter.ViewHolder> implements Observer{

    private ArrayList<FeedItem> dataSet;

    public FeedListAdapter(ArrayList<FeedItem> dataSet) {
        this.dataSet = dataSet;
    }

    //create new views invoked by layout manager
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView cardView = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.feed_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(cardView);
        return viewHolder;
    }

    //Replace the contents of a view (invoked by layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        FeedItem feedItem = dataSet.get(position);
        holder.feedDescription.setText(feedItem.getDescription());
        holder.feedAuthor.setText(feedItem.getAuthor());
        holder.feedDate.setText(feedItem.getPubDate());
        holder.feedCategory.setText(feedItem.getCategory());
        holder.feedTitle.setText(feedItem.getTitle());
        holder.feedContent.setText(Html.fromHtml(feedItem.getContent()));
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    @Override
    public void update(Observable observable) {
        FeedService service = (FeedService) observable;
        dataSet = (ArrayList<FeedItem>) service.getList();
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView feed;
        protected TextView feedTitle;
        protected TextView feedDate;
        protected TextView feedAuthor;
        protected TextView feedContent;
        protected TextView feedDescription;
        protected TextView feedCategory;

        public ViewHolder(View itemView) {
            super(itemView);
            feed = (CardView) itemView;
            feedTitle = (TextView) itemView.findViewById(R.id.feed_title);
            feedContent = (TextView) itemView.findViewById(R.id.feed_content);
            feedDate = (TextView) itemView.findViewById(R.id.feed_date);
            feedAuthor = (TextView) itemView.findViewById(R.id.feed_author);
            feedDescription = (TextView) itemView.findViewById(R.id.feed_description);
            feedCategory = (TextView) itemView.findViewById(R.id.feed_category);
        }
    }
}
