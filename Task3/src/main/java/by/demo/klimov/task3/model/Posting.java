package by.demo.klimov.task3.model;

import constants.Constants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "postings")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Posting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "mat_doc", nullable = false)
    private String matDoc;

    @Column(name = "item", nullable = false)
    private int item;

    @Column(name = "doc_date", nullable = false)
    @DateTimeFormat(pattern = Constants.DATE_FORMAT)
    private Date docDate;

    @Column(name = "pstng_date", nullable = false)
    @DateTimeFormat(pattern = Constants.DATE_FORMAT)
    private Date pstngDate;

    @Column(name = "material_description")
    private String materialDescription;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "bun")
    private String bun;

    @Column(name = "amountLC")
    private BigDecimal amountLC;

    @Column(name = "crcy")
    private String crcy;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "authorized_delivery")
    private Boolean authorizedDelivery;
}
