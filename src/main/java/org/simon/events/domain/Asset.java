package org.simon.events.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Asset extends PanacheEntity {

    // @formatter:off
    @Column public String name;
    @Column public LocalDate date;
    // @formatter:on


    Asset() {
    }

    public Asset(String name, LocalDate date) {
        this.name = name;
        this.date = date;
    }
}
