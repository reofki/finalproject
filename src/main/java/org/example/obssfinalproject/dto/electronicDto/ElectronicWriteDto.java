package org.example.obssfinalproject.dto.electronicDto;

import lombok.Data;
import org.example.obssfinalproject.model.products.Discount;

import java.util.Set;

@Data
public class ElectronicWriteDto {
    private String title;
    private String explanation;
    private String imageUrl;
    private double price;
    private int amount;
    private Set<Discount> discountTag;
    private String category;
    private String brand;
    private double storage;
    private int ram;
}

