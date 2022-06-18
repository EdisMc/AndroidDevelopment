package bg.tu.varna.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FruitsAdapter extends RecyclerView.Adapter<FruitsAdapter.FruitsHolder> {
    private ArrayList<Fruits> fruitsList;
    private Context context;
    private OnItemClickListener listener;

    public FruitsAdapter(ArrayList<Fruits> fruitsList, Context context) {
        this.fruitsList = fruitsList;
        this.context = context;
    }

    @NonNull
    @Override
    public FruitsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.fruits_item, parent, false);
        return new FruitsHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FruitsHolder holder, int position) {
        Fruits fruits = fruitsList.get(position);
        holder.setData(fruits);

    }

    @Override
    public int getItemCount() {
        return fruitsList.size();
    }

    class FruitsHolder extends RecyclerView.ViewHolder {
        TextView fruitName, fruitCalories;

        public FruitsHolder(@NonNull View itemView) {
            super(itemView);
            fruitName = (TextView)itemView.findViewById(R.id.fruits_item_textViewFruitName);
            fruitCalories = (TextView)itemView.findViewById(R.id.fruits_item_textViewFruitCalories);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(fruitsList.get(position), position);
                    }
                }
            });
        }

        public void setData(Fruits fruits) {
            this.fruitName.setText(fruits.getName());
            this.fruitCalories.setText(String.valueOf(fruits.getCalories()));
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Fruits fruits, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
