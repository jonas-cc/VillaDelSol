package com.example.villadelsol.ui.room2;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Room2ViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public Room2ViewModel() {
        mText = new MutableLiveData<>();
        //mText.setValue("SALLON 1");
    }

    public LiveData<String> getText() {
        return mText;
    }
}