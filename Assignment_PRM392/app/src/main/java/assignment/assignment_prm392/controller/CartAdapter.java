package assignment.assignment_prm392.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import assignment.assignment_prm392.R;
import assignment.assignment_prm392.model.dto.CartDTO;

import java.util.List;

public class CartAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<CartDTO> listCart;

    public CartAdapter() {
    }

    public CartAdapter(Context context, int layout, List<CartDTO> listCart) {
        this.context = context;
        this.layout = layout;
        this.listCart = listCart;
    }

    @Override
    public int getCount() {
        return listCart.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    static class ViewHolder {
        ImageView img;
        TextView tvHeader, tvDesc;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        CartAdapter.ViewHolder holder;

        if(view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, viewGroup, false);
            holder = new ViewHolder();
            holder.img = view.findViewById(R.id.imageView);
            holder.tvHeader = view.findViewById(R.id.tvProductHeader);
            holder.tvDesc = view.findViewById(R.id.tvProductDesc);
            view.setTag(holder);
        }
        else {
            holder = (CartAdapter.ViewHolder) view.getTag();
        }
//        holder.btnEdit.setFocusable(false);
//        holder.btnEdit.setFocusableInTouchMode(false);

        CartDTO cartDTO = listCart.get(i);
        holder.img.setImageResource(R.mipmap.ic_launcher_round);
//        holder.tvHeader.setText(cartDTO.getName());
//        holder.tvDesc.setText(cartDTO.getDescription());
//        holder.btnEdit.setOnClickListener(click ->
//                context.DialogEdit(trainee));

        return view;
    }
}
