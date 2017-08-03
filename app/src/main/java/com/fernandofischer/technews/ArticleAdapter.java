package com.fernandofischer.technews;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by fernandofischer on 01/08/17.
 */

public class ArticleAdapter extends ArrayAdapter<Article> {


    public ArticleAdapter(Context context, List<Article> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolderItem viewHolder;

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);

            // well set up the ViewHolder
            viewHolder = new ViewHolderItem();
            viewHolder.thumbnail = (ImageView) listItemView.findViewById(R.id.thumbnail);
            viewHolder.section = (TextView) listItemView.findViewById(R.id.section);
            viewHolder.title = (TextView) listItemView.findViewById(R.id.title);
            viewHolder.trailText = (TextView) listItemView.findViewById(R.id.trailText);
            viewHolder.datetime = (TextView) listItemView.findViewById(R.id.datetime);

            // store the holder with the view.
            listItemView.setTag(viewHolder);
        } else {
            // we've just avoided calling findViewById() on resource everytime
            // just use the viewHolder
            viewHolder = (ViewHolderItem) listItemView.getTag();
        }

        final Article article = getItem(position);


        if (article.getBitmap()==null){
            viewHolder.thumbnail.setVisibility(View.GONE);
        } else {
            viewHolder.thumbnail.setVisibility(View.VISIBLE);
            viewHolder.thumbnail.setImageBitmap(article.getBitmap());
        }

        viewHolder.section.setText(article.getSection());
        viewHolder.title.setText(article.getTitle());
        viewHolder.trailText.setText(article.getTrailText());
        viewHolder.datetime.setText(getDateDiff(article.getDatetime()));

        return listItemView;
    }

    static class ViewHolderItem {
        ImageView thumbnail;
        TextView section;
        TextView title;
        TextView trailText;
        TextView datetime;
    }

    /**
     * Get a diff time from current date
     * @param date the old date
     * @return the diff value
     */
    public static String getDateDiff(Date date) {
        Date now = new Date();
        long diffInMillies = now.getTime() - date.getTime();

        TimeUnit timeUnit = TimeUnit.MINUTES;
        long min = timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);

        if (min < 60) {
            return Long.toString(min) + " m";
        } else {
            timeUnit = TimeUnit.HOURS;
            return Long.toString( timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS) ) + " h";
        }

    }
}
