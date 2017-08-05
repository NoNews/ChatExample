package ru.alexbykov.chat.adapters.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 05.08.2017
 * Time: 12:12
 * Project: ChatExample
 *
 * @author Alex Bykov
 *         You can contact me at me@alexbykov.ru
 */
abstract public class BaseRecyclerViewAdapter<T, VH extends RecyclerView.ViewHolder>
        extends RecyclerView.Adapter<VH> {

    protected List<T> items;
    protected OnItemClickListener onItemClickListener;


    public BaseRecyclerViewAdapter() {
        items = new ArrayList<T>();
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public T getItem(int position) {
        return items.get(position);
    }

    public void add(T item, int position) {
        items.add(position, item);
        notifyItemInserted(position);
    }


    public void remove(int position) {
        notifyItemRemoved(position);
        items.remove(position);
    }

    public void clear() {
        items.clear();
        notifyDataSetChanged();
    }

    public void addItems(List<T> items) {
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    protected View inflate(ViewGroup viewGroup, int layoutID) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(layoutID, viewGroup, false);
    }


    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onClick(Object object);
    }


    protected void showView(View view) {
        if (view.getVisibility() == View.GONE || view.getVisibility() == View.INVISIBLE) {
            view.setVisibility(View.VISIBLE);
        }
    }


    protected void hideView(View view) {
        if (view.getVisibility() == View.VISIBLE) {
            view.setVisibility(View.GONE);
        }
    }

}