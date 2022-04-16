package by.demo.klimov.task3.model;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "login")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "application", nullable = false)
    @CsvBindByName(column = "Application")
    private String application;

    @Column(name = "app_account_name", nullable = false)
    @CsvBindByName(column = "AppAccountName")
    private String appAccountName;

    @Column(name = "is_active", nullable = false)
    @CsvBindByName(column = "IsActive")
    private boolean isActive;

    @Column(name = "job_title")
    @CsvBindByName(column = "JobTitle")
    private String jobTitle;

    @Column(name = "department")
    @CsvBindByName(column = "Department")
    private String department;
}
