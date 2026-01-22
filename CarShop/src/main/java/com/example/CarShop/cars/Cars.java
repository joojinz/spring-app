package com.example.CarShop.cars;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cars")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Cars {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public  Long id;

    @Column(name = "carname")
    public String carName;

    @Column(name = "caryear")
    public Integer carYear;

    @Column(name = "carvalue")
    public Integer carValue;

    @Column(name = "carcondition")
    public String carCondition;

    @Column(name = "email")
    public String email;



    
}
