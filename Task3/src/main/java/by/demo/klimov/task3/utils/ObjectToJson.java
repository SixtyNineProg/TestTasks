package by.demo.klimov.task3.utils;

import by.demo.klimov.task3.constants.Constants;
import by.demo.klimov.task3.model.Item;
import by.demo.klimov.task3.model.Posting;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class ObjectToJson {
    private static final Gson gson = new GsonBuilder().setDateFormat(Constants.DATE_FORMAT).create();

    public static synchronized String toJson(Object o) {
        return gson.toJson(o);
    }

    public static synchronized String postingToJson(Posting posting) {
        Posting unProxyPosting = EntityUnProxy.initializeAndUnProxy(posting);
        List<Item> unProxyListItem = EntityUnProxy.initializeAndUnProxy(posting.getItem());
        unProxyPosting.setItem(unProxyListItem);
        return gson.toJson(unProxyPosting);
    }
}
