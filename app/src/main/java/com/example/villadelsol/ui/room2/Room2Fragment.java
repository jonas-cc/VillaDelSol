package com.example.villadelsol.ui.room2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.villadelsol.databinding.FragmentGalleryBinding;
import com.example.villadelsol.databinding.FragmentRoom1Binding;
import com.example.villadelsol.databinding.FragmentRoom2Binding;

public class Room2Fragment extends Fragment {

    private FragmentRoom2Binding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        Room2ViewModel room2ViewModel =
                new ViewModelProvider(this).get(Room2ViewModel.class);

        binding = FragmentRoom2Binding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textView20;
        room2ViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}