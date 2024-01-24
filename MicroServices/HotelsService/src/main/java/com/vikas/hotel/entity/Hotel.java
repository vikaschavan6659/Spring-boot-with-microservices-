package com.vikas.hotel.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "hotels")
public class Hotel {

    @Id
    private int id ;

    private String hotelId;

    private String name;

    private String location;

    private String about;

}
