package com.example.aa.recyclerviewdemo.logic;

import com.example.aa.recyclerviewdemo.data.DataSourceInterface;
import com.example.aa.recyclerviewdemo.data.ListItem;
import com.example.aa.recyclerviewdemo.view.ViewInterface;

/**
 * Created by aa on 18.12.2017.
 */

public class Controller {
    private ViewInterface viewInterface;
    private DataSourceInterface dataSource;

    public Controller(ViewInterface viewInterface, DataSourceInterface dataSource) {
        this.viewInterface = viewInterface;
        this.dataSource = dataSource;

        getListFromDataSource();
    }

    public void getListFromDataSource() {
    viewInterface.setUpAdapterAndView(
            dataSource.getListOfData()
    );

    }

    public void onListItemClick(ListItem testItem) {
        viewInterface.startDetailActivity(
                testItem.getDateAndTime(),
                testItem.getMessage(),
                testItem.getColorResource()
        );
    }
}
