package com.yuda_alector.contactos;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


public class About extends Fragment {

    public About() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container, false);
        String id = this.getArguments().getString("id");

        Toast.makeText(view.getContext(), "Contacto[f]: " + id, Toast.LENGTH_LONG).show();
        return view;
    }

}
