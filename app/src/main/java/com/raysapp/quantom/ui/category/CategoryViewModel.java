package com.raysapp.quantom.ui.category;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CategoryViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public CategoryViewModel() {
        mText = new MutableLiveData<>();
        /*mText.setValue("This is gallery fragment");*/
    }

    public LiveData<String> getText() {
        return mText;
    }
}