package by.demo.klimov.task3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;
import com.opencsv.bean.CsvNumber;
import com.opencsv.bean.CsvRecurse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "posting")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Posting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "mat_doc", nullable = false)
    @CsvBindByName(column = "Mat. Doc.")
    private String matDoc;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "item_id", nullable = false)
    @CsvRecurse
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Item item;

    @Column(name = "doc_date", nullable = false)
    @CsvBindByName(column = "Doc. Date")
    @CsvDate("dd.MM.yyyy")
    private Date docDate;

    @Column(name = "pstng_date", nullable = false)
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

    @Override
    public String toString() {
        return "Posting: " +
                "id:" + id +
                ", matDoc: " + matDoc +
                ", item: " + item +
                ", docDate: " + docDate +
                ", pstngDate: " + pstngDate +
                ", materialDescription: " + materialDescription +
                ", quantity: " + quantity +
                ", bun: " + bun +
                ", amountLC: " + amountLC +
                ", crcy: " + crcy +
                ", userName: " + userName +
                ", authorizedDelivery: " + authorizedDelivery +
                '}';
    }
}
