package com.example.villadelsol.ui.admin;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AdminViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public AdminViewModel() {
        mText = new MutableLiveData<>();
        //mText.setValue("SALLON 1");
    }

    public LiveData<String> getText() {
        return mText;
    }
}