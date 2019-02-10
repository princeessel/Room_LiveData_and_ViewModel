package com.example.roomwordssample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.ViewHolder> {

private final LayoutInflater mInflater;
private List<Word> mWords;

public WordListAdapter(Context context){
    mInflater=LayoutInflater.from(context);
}

    @Override
    public WordListAdapter.ViewHolder onCreateViewHolder( ViewGroup viewGroup, int i) {
    View itemView=mInflater.inflate(R.layout.recyclerview_item,viewGroup,false);

    return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
    if(mWords!=null){
        Word current=mWords.get(i);
        viewHolder.wordItemView.setText(current.getWord());
    }
else{
    viewHolder.wordItemView.setText("No Word");
    }
    }

    void setmWords(List<Word> words){
    mWords=words;
    notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
    if(mWords!=null)
        return mWords.size();
    else return 0;

    }

    public class ViewHolder extends RecyclerView.ViewHolder{
    private final TextView wordItemView;
        public ViewHolder( View itemView) {
            super(itemView);
            wordItemView=itemView.findViewById(R.id.textView);
        }
    }
}
