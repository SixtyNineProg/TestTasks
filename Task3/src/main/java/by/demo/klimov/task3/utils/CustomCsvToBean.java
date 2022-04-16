package by.demo.klimov.task3.utils;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.util.List;

public class CustomCsvToBean<T> {

    public List<T> beanBuilder(String fileName, Class<T> requireClass, char separator) throws Exception {

        String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\csv\\" + fileName;

        return new CsvToBeanBuilder<T>(new FileReader(filePath))
                .withType(requireClass)
                .withSeparator(separator)
                .build()
                .parse();
    }
}
