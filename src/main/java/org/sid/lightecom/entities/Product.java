package org.sid.lightecom.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Product implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String description;
    private double currentPrice;
    private boolean promotion;
    private boolean selected;
    private boolean available;
    private String photoName;
    // champs @Transient ne sera pas dans la bdd il est seulement envoyer au front en json (champs pas persistant, besoin seulement côté client)
    @Transient
    private int quantity = 1;
    @ManyToOne
    private Category category;

}
