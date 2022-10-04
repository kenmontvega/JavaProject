package com.nlxa.java.domain;

import com.nlxa.java.dto.level.AddLevelRequest;
import com.nlxa.java.dto.level.DeleteLevelRequest;
import com.nlxa.java.dto.level.UpdateLevelRequest;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "level") //nombre de la tabla en la base de datos
public class Level implements Serializable {

    //<editor-fold desc="Attributes">
    @Id
    @Column(name = "level_id") //nombre de la columna de la base de datos
    @GeneratedValue(generator = "ID")
    @GenericGenerator(
            name = "ID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String level_id;

    @Column(name = "description")
    private String description;

    //</editor-fold>

    //<editor-fold desc="Constructor">

    public Level() {}

    public Level(AddLevelRequest request) {
        this.level_id = "";
        this.description = request.getDescription();
    }

    public Level(DeleteLevelRequest request) {
        this.level_id = request.getId();
    }

    public Level(UpdateLevelRequest request) {
        this.level_id = request.getId();
        this.description = request.getDescription();
    }

    //</editor-fold>
}
