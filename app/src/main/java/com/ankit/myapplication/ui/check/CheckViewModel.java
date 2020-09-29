package com.ankit.myapplication.ui.check;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CheckViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public CheckViewModel() {
        mText = new MutableLiveData<>();
    }

    public LiveData<String> getText() {
        return mText;
    }
}