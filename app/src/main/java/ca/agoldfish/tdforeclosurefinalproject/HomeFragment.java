package ca.agoldfish.tdforeclosurefinalproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.navigation.NavigationView;


public class HomeFragment extends Fragment {

    View view;
    Button filterButton;
    Button listButton;
    Button mapButton;
    Button mixButton;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_home, container, false);


        filterButton = view.findViewById(R.id.filterBtn);
        listButton = view.findViewById(R.id.listBtn);
        mapButton = view.findViewById(R.id.mapBtn);
        mixButton = view.findViewById(R.id.mixBtn);

        NavigationView navigationView = getActivity().findViewById(R.id.nav_view);
        navigationView.getMenu().getItem(0).setChecked(true);
        navigationView.getMenu().getItem(4).getSubMenu().getItem(0).setChecked(false);

        //set up listeners
        setUpBtnListeners();

        // Inflate the layout for this fragment
        return view;
    }

    private void setUpBtnListeners() {
        final FragmentChangeListener fc=(FragmentChangeListener)getActivity();

        filterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //fc.replaceFragment(new FilterFragment());
            }
        });

        listButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //fc.replaceFragment(new ListFragment());
            }
        });

        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //fc.replaceFragment(new MapFragment());
            }
        });

        mixButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //fc.replaceFragment(new MixFragment());
            }
        });
    }
}