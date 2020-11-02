package edu.njmsd.stonksmonkey.data.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "expenses")
public class ExpenseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long userId;
    @ManyToOne
    private ExpenseCategoryEntity category;
    private double amount;
    private LocalDate date;

    protected ExpenseEntity() {
    }

    public ExpenseEntity(long id, long userId, ExpenseCategoryEntity category, double amount, LocalDate date) {
        this.id = id;
        this.userId = userId;
        this.category = category;
        this.amount = amount;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public long getUserId() {
        return userId;
    }

    public ExpenseCategoryEntity getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }
}
