package com.example.aa.recyclerviewdemo;

import com.example.aa.recyclerviewdemo.data.DataSourceInterface;
import com.example.aa.recyclerviewdemo.data.ListItem;
import com.example.aa.recyclerviewdemo.logic.Controller;
import com.example.aa.recyclerviewdemo.view.ViewInterface;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(MockitoJUnitRunner.class)
public class ControllerUnitTest {
    /**
     * Test Double:
     * Specifically a "Mock"
     */
    @Mock
    DataSourceInterface dataSourceInterface;

    @Mock
    ViewInterface viewInterface;

    Controller controller;
    private static final ListItem testItem = new ListItem(
            "6:30AM 01/03/2034",
            "asddqwqeqwdaxzca",
            R.color.RED
    );

    @Before
    public void setUpTest () {
        MockitoAnnotations.initMocks(this);
        controller = new Controller(viewInterface,dataSourceInterface);
    }

    @Test
    public void onGetListDataSuccessful() {
        ArrayList<ListItem>listOfData = new ArrayList<>();
        listOfData.add(testItem);

        Mockito.when(dataSourceInterface.getListOfData())
                .thenReturn(listOfData);

        controller.getListFromDataSource();

        Mockito.verify(viewInterface).setUpAdapterAndView(listOfData);
    }

    @Test
    public void onListItemClicked(){
        controller.onListItemClick(testItem);

        Mockito.verify(viewInterface).startDetailActivity(
                testItem.getDateAndTime(),
                testItem.getMessage(),
                testItem.getColorResource());
    }
}