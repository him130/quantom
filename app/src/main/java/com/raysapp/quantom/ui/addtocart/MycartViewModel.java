package com.raysapp.quantom.ui.addtocart;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MycartViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public MycartViewModel() {
        mText = new MutableLiveData<>();
        /*mText.setValue("This is slideshow fragment");*/
    }

    public LiveData<String> getText() {
        return mText;
    }
}