package by.demo.klimov.task3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "logins")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "application", nullable = false)
    private String application;

    @Column(name = "app_account_name", nullable = false)
    private String appAccountName;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "department")
    private String department;
}
