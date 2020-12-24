package edu.njmsd.stonksmonkey.data.entities;

import edu.njmsd.stonksmonkey.domain.models.OperationCategory;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "expense_categories")
public class ExpenseCategoryEntity extends OperationCategory {
}
