package edu.njmsd.stonksmonkey.data.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "incomes")
public class IncomeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long userId;
    @ManyToOne
    private IncomeCategoryEntity category;
    private double amount;
    private LocalDate date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public IncomeCategoryEntity getCategory() {
        return category;
    }

    public void setCategory(IncomeCategoryEntity category) {
        this.category = category;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
