package by.demo.klimov.task3.model;

import com.opencsv.bean.CsvBindAndSplitByName;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;
import com.opencsv.bean.CsvNumber;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "posting")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Posting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "mat_doc", nullable = false)
    @CsvBindByName(column = "Mat. Doc.")
    private String matDoc;

    @OneToMany(mappedBy = "posting", fetch = FetchType.EAGER)
    @CsvBindAndSplitByName(elementType = Item.class, splitOn = "\\|", converter = TextToItem.class)
    private List<Item> item;

    @Column(name = "doc_date", nullable = false)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @CsvBindByName(column = "Doc. Date")
    @CsvDate("dd.MM.yyyy")
    private Date docDate;

    @Column(name = "pstng_date", nullable = false)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @CsvBindByName(column = "Pstng Date")
    @CsvDate("dd.MM.yyyy")
    private Date pstngDate;

    @Column(name = "material_description")
    @CsvBindByName(column = "Material Description")
    private String materialDescription;

    @Column(name = "quantity")
    @CsvBindByName(column = "Quantity")
    private int quantity;

    @Column(name = "bun")
    @CsvBindByName(column = "BUn")
    private String bun;

    @Column(name = "amountLC")
    @CsvBindByName(column = "Amount LC")
    @CsvNumber(value = "#0,00")
    private float amountLC;

    @Column(name = "crcy")
    @CsvBindByName(column = "Crcy")
    private String crcy;

    @Column(name = "user_name")
    @CsvBindByName(column = "User Name")
    private String userName;

    @Column(name = "authorized_delivery")
    private Boolean authorizedDelivery;
}
