package com.example.aa.recyclerviewdemo.data;

import android.widget.ListView;

import com.example.aa.recyclerviewdemo.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by aa on 18.12.2017.
 */

public class FakeDataSource implements DataSourceInterface {
    private  static final int SIZE_OF_COLLECTION = 6;

    private final String[] datesAndTime = {
            "11:11AM 09/23/1234",
            "03:11AM 06/23/1221",
            "23:15AM 01/23/1234",
    };

    private final String[] message = {
            "dsadsadasdasdasdasdasdasdasd",
            "dsaadjidjgfnhfjoifjgidfjiwogjifsdfsd",
            "daasdasdasdsadahkyuklyukg",
    };

    private final int colors[] = {
            R.color.RED,
            R.color.BLUE,
            R.color.YELLOW,
    };

    public FakeDataSource() {
    }

    @Override
    public List<ListItem> getListOfData() {
        ArrayList<ListItem> listOfData = new ArrayList<>();

        Random random = new Random();
        for (int i = 0; i < SIZE_OF_COLLECTION; i++) {
            int randOne = random.nextInt(3);
            int randTwo = random.nextInt(3);
            int randThree = random.nextInt(3);

            ListItem listItem = new ListItem(
                    datesAndTime[randOne],
                    message[randTwo],
                    colors[randThree]
            );
            listOfData.add(listItem);
        }

        return listOfData;
    }
}
