package hcmute.edu.vn.bai6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.recyclerview.widget.RecyclerView;
import androidx.databinding.DataBindingUtil;


import java.util.List;

import hcmute.edu.vn.bai6.databinding.ItemListUserBinding;

public class ListUserAdapter extends RecyclerView.Adapter<ListUserAdapter.MyViewHolder> {
    private final List<User> userList;
    private OnItemClickListener onItemClickListener;
    public ListUserAdapter(List<User> userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListUserBinding itemListUserBinding =
                DataBindingUtil.inflate(
                        LayoutInflater.from(parent.getContext()),
                        R.layout.item_list_user,
                        parent,
                        false);
        return new MyViewHolder(itemListUserBinding, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.setBinding(userList.get(position), position);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public interface OnItemClickListener {
        void itemClick(User user);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ObservableField<String> stt = new ObservableField<>();
        public ObservableField<String> firtName = new ObservableField<>();
        public ObservableField<String> lastName = new ObservableField<>();
        private final ItemListUserBinding itemListUserBinding;
        private final OnItemClickListener onItemClickListener;
        private User user;

        public MyViewHolder(@NonNull ItemListUserBinding itemView, OnItemClickListener onItemClickListener) {
            super(itemView.getRoot());
            this.itemListUserBinding = itemView;
            this.onItemClickListener = onItemClickListener;
            itemView.getRoot().setOnClickListener(this);
        }

        public void setBinding(User user, int position) {
            if (itemListUserBinding.getViewHolder() == null) {
                itemListUserBinding.setViewHolder(this);
            }
            stt.set(String.valueOf(position));
            firtName.set(user.getFirstName());
            lastName.set(user.getLastName());
        }

        @Override
        public void onClick(View view) {

            this.onItemClickListener.itemClick(user);
        }
    }

}

