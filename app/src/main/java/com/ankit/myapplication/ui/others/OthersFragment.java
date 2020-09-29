package com.ankit.myapplication.ui.others;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.ankit.myapplication.PageNotFoundActivity;
import com.ankit.myapplication.R;

public class OthersFragment extends Fragment {

    private OthersViewModel othersViewModel;
    private CardView aboutUs;
    private CardView help;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        othersViewModel = ViewModelProviders.of(this).get(OthersViewModel.class);
        View root = inflater.inflate(R.layout.fragment_others, container, false);

        initializeUI(root);

        initializeOnClickListener();

        return root;
    }

    private void initializeUI(View root) {
        aboutUs = root.findViewById(R.id.about_us);
        help = root.findViewById(R.id.help);
    }

    private void initializeOnClickListener() {
        aboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PageNotFoundActivity.class);
                startActivity(intent);
            }
        });

        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PageNotFoundActivity.class);
                startActivity(intent);
            }
        });
    }

}