package ca.agoldfish.tdforeclosurefinalproject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import ca.agoldfish.tdforeclosurefinalproject.property_information.property_information;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private  static final String TAG = "RecyclerViewAdapter";

    private ArrayList<PropertyPackage> mProperties;

    //context
    private Context context;

    public RecyclerViewAdapter(Context context,ArrayList<PropertyPackage> properties) {
        mProperties = properties;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_listitem,viewGroup,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, @SuppressLint("RecyclerView") final int i) {
        Log.d(TAG, "onBindViewHolder: called.");

        Glide.with(context)
                .asBitmap()
                .load(mProperties.get(i).getPicture())
                .into(viewHolder.houseIV);

        if(""==mProperties.get(i).getBedrooms())
            viewHolder.bedIV.setVisibility(View.INVISIBLE);
        else
            viewHolder.bedIV.setVisibility(View.VISIBLE);

        if(""==mProperties.get(i).getBathrooms())
            viewHolder.bathIV.setVisibility(View.INVISIBLE);
        else
            viewHolder.bathIV.setVisibility(View.VISIBLE);

        viewHolder.addressTV.setText(mProperties.get(i).getAddress());
        viewHolder.locationTV.setText(mProperties.get(i).getLocation() );
        viewHolder.priceTV.setText(mProperties.get(i).getPrice());
        viewHolder.realtorTV.setText(mProperties.get(i).getRealtor());
        viewHolder.bedTV.setText(mProperties.get(i).getBedrooms());
        viewHolder.bathTV.setText(mProperties.get(i).getBathrooms());
        viewHolder.sizeTV.setText(mProperties.get(i).getSize());

        //seticon
        switch (mProperties.get(i).getType()){
            case "home":
                //seticon
                Glide.with(context)
                        .asBitmap()
                        .load(R.drawable.houseicon)
                        .into(viewHolder.typeIV);
                break;
            case "retail":
                Glide.with(context)
                        .asBitmap()
                        .load(R.drawable.shopicon)
                        .into(viewHolder.typeIV);
                break;
            case "land":
                Glide.with(context)
                        .asBitmap()
                        .load(R.drawable.landicon)
                        .into(viewHolder.typeIV);
                break;
            case "office":
                Glide.with(context)
                        .asBitmap()
                        .load(R.drawable.buildingicon)
                        .into(viewHolder.typeIV);
                break;
            case "storage":
                Glide.with(context)
                        .asBitmap()
                        .load(R.drawable.storageicon)
                        .into(viewHolder.typeIV);
                break;
        }

        viewHolder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClicked: clicked on: " + mProperties.get(i).getRealtor());
//                Toast.makeText(context, mProperties.get(i).getAddress(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(context, property_information.class);
                intent.putExtra("parcel_data", mProperties.get(i));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mProperties.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView houseIV;
        ImageView bedIV;
        ImageView bathIV;
        ImageView typeIV;


        TextView addressTV;
        TextView locationTV;
        TextView priceTV;
        TextView realtorTV;
        TextView bedTV;
        TextView bathTV;
        TextView sizeTV;

        ConstraintLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            houseIV = itemView.findViewById(R.id.propertyImg);
            bedIV = itemView.findViewById(R.id.bedImg);
            bathIV = itemView.findViewById(R.id.bathImg);
            typeIV = itemView.findViewById(R.id.typeImg);

            addressTV = itemView.findViewById(R.id.addressTxt);
            locationTV = itemView.findViewById(R.id.locationTxt);
            priceTV = itemView.findViewById(R.id.priceTxt);
            realtorTV = itemView.findViewById(R.id.realtorTxt);
            bedTV = itemView.findViewById(R.id.bedTxt);
            bathTV = itemView.findViewById(R.id.bathTxt);
            sizeTV = itemView.findViewById(R.id.sizeTxt);

            parentLayout = itemView.findViewById(R.id.parent_layout);

        }
    }
}
