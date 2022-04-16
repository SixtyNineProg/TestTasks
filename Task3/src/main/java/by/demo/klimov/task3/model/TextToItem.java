package by.demo.klimov.task3.model;

import com.opencsv.bean.AbstractCsvConverter;

public class TextToItem extends AbstractCsvConverter {
    @Override
    public Object convertToRead(String value) {
        Item item = new Item();
        item.setId(Long.parseLong(value));
        return item;
    }
}
