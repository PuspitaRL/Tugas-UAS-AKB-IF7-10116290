package com.uas.pushpu.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.uas.pushpu.R;
import com.uas.pushpu.presenter.AboutPresenter;
import com.uas.pushpu.view.AboutView;



public class AboutFragment extends Fragment implements AboutView {

    int tab;
    LinearLayout lytApp, lytCreator;
    AboutPresenter presenter;

    public AboutFragment() {
        // Required empty public constructor
    }

    public static AboutFragment newInstance(int tab) {
        AboutFragment fragment = new AboutFragment();
        Bundle args = new Bundle();
        args.putInt("tab", tab);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        lytApp = view.findViewById(R.id.lytApp);
        lytCreator = view.findViewById(R.id.lytCreator);

        presenter = new AboutPresenter(this);

        if (getArguments() != null) {
            tab = getArguments().getInt("tab");
            presenter.selectionView(tab);
        }
        return view;
    }

    @Override
    public void showApp() {
        lytApp.setVisibility(View.VISIBLE);
        lytCreator.setVisibility(View.GONE);
    }

    @Override
    public void showCreator() {
        lytApp.setVisibility(View.GONE);
        lytCreator.setVisibility(View.VISIBLE);
    }
}
