package com.example.villadelsol.ui.citas;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CitasViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public CitasViewModel() {
        mText = new MutableLiveData<>();
        //mText.setValue("SALLON 1");
    }

    public LiveData<String> getText() {
        return mText;
    }
}