package hcmute.edu.vn.bai5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter  extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private List<Object> mObjects;
    public static final int TEXT = 0;
    public static final int IMAGE = 1;
    public static final int USER = 2;

    public UserAdapter(Context context, List<Object> objects) {
        mContext = context;
        mObjects = objects;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(this.mContext);
        switch(viewType) {
            case TEXT:
                View viewText = li.inflate(R.layout.row_text, parent, false);
                return new TextViewHolder(viewText);
            case IMAGE:
                View viewImage = li.inflate(R.layout.row_image, parent, false);
                return new ImageViewHolder(viewImage);
            case USER:
                View viewUser = li.inflate(R.layout.row_user, parent, false);
                return new UserViewHolder(viewUser);
            default:
                break;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case TEXT:
                TextViewHolder textViewHolder = (TextViewHolder) holder;
                textViewHolder.tvText.setText(mObjects.get(position).toString());
                break;
            case IMAGE:
                ImageViewHolder imageViewHolder = (ImageViewHolder) holder;
                imageViewHolder.imvImage.setImageResource((int) mObjects.get(position));
                break;
            case USER:
                UserViewHolder userViewHolder = (UserViewHolder) holder;
                UserModel userModel = (UserModel) mObjects.get(position);
                userViewHolder.tvName.setText(userModel.getName());
                userViewHolder.tvAddress.setText(userModel.getAddress());
                break;
            default:
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mObjects.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (mObjects.get(position) instanceof String) {
            return TEXT;
        } else if (mObjects.get(position) instanceof Integer) {
            return IMAGE;
        } else if (mObjects.get(position) instanceof UserModel) {
            return USER;
        }
        return -1;
    }

    public class TextViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvText;

        public TextViewHolder(View itemView) {
            super(itemView);
            tvText = itemView.findViewById(R.id.tv_text);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, mObjects.get(getAdapterPosition()).toString(), Toast.LENGTH_SHORT).show();
                }
            });

        }
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imvImage;

        public ImageViewHolder(View itemView) {
            super(itemView);
            imvImage = itemView.findViewById(R.id.imv_image);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, mObjects.get(getAdapterPosition()).toString(), Toast.LENGTH_SHORT).show();
                }
            });

        }
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvName;
        private final TextView tvAddress;

        public UserViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvAddress = itemView.findViewById(R.id.tv_address);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    UserModel user = (UserModel) mObjects.get(getAdapterPosition());
                    Toast.makeText(mContext, user.getName() + ", " + user.getAddress(), Toast.LENGTH_SHORT).show();
                }
            });

        }
    }
}
