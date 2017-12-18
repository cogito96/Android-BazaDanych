package com.example.aa.recyclerviewdemo.view;

import com.example.aa.recyclerviewdemo.data.ListItem;

import java.util.List;

/**
 * Created by aa on 18.12.2017.
 */

public interface ViewInterface {
    void startDetailActivity(String dateAndTime , String message, int colorResource);

    void setUpAdapterAndView(List<ListItem> listOfData);

}

