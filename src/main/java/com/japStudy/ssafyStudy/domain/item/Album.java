package com.japStudy.ssafyStudy.domain.item;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("A")
@Getter
public class Album extends Item {
    private String artist;
    private String ect;
}
