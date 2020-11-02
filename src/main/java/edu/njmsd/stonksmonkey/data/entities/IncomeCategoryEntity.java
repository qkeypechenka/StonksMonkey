package edu.njmsd.stonksmonkey.data.entities;

import edu.njmsd.stonksmonkey.domain.models.OperationCategory;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "income_categories")
public class IncomeCategoryEntity extends OperationCategory {
    public IncomeCategoryEntity(long id, long userId, String name) {
        super(id, userId, name);
    }

    protected IncomeCategoryEntity() {
    }
}
