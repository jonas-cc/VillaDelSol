package com.example.villadelsol.ui.admin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.villadelsol.databinding.FragmentAdminBinding;
import com.example.villadelsol.databinding.FragmentCitasBinding;
import com.example.villadelsol.databinding.FragmentGalleryBinding;
import com.example.villadelsol.databinding.FragmentRoom1Binding;

public class AdminFragment extends Fragment {

    private FragmentAdminBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        AdminViewModel AdminViewModel =
                new ViewModelProvider(this).get(AdminViewModel.class);

        binding = FragmentAdminBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textView23;
        AdminViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void dashboard(View view) {
    }
}
