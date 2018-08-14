package com.ray.useroomsample.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ray.useroomsample.R;
import com.ray.useroomsample.entity.Word;

import java.util.List;

/***
 *  Author : ryu18356@gmail.com
 *  Create at 2018-08-14 10:02
 *  description : 
 */
public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    private final LayoutInflater mLayoutInflater;
    private List<Word> mWords;

    public WordListAdapter(Context context) {
        mLayoutInflater = LayoutInflater.from(context);
    }

    public void setWords(List<Word> words){
        mWords = words;
        notifyDataSetChanged();
    }

    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new WordViewHolder(mLayoutInflater.inflate(R.layout.recyclerview_item, parent, false));
    }

    @Override
    public void onBindViewHolder(WordViewHolder holder, int position) {
        if (mWords != null) {
            holder.wordItemView.setText(mWords.get(position).getWord());
        } else {
            holder.wordItemView.setText("No Word");
        }
    }

    @Override
    public int getItemCount() {
        return mWords == null ? 0 : mWords.size();
    }

    static class WordViewHolder extends RecyclerView.ViewHolder{

        private final TextView wordItemView;

        public WordViewHolder(View itemView) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.textView);
        }
    }

}
