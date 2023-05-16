package com.raysapp.quantom.ui.addtocart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.raysapp.quantom.databinding.FragmentMycartBinding;

public class MycartFragment extends Fragment {

    private FragmentMycartBinding binding;
    private MycartViewModel mycartViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MycartViewModel mycartViewModel =
                new ViewModelProvider(this).get(MycartViewModel.class);

        binding = FragmentMycartBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        final TextView textView = binding.textaddtocart;
        mycartViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}