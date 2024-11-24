package com.conectavip_hp.conectavip_hp.core.domain.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class EscortDTO {

    @NotNull
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;

    @NotNull
    @Pattern(regexp = "^\\+?[1-9]\\d{1,14}$", message = "Phone number must be valid")
    private String phone;

    @Pattern(regexp = "^\\+?[1-9]\\d{1,14}$", message = "WhatsApp number must be valid")
    private String whatsapp;

    @Pattern(regexp = "^\\+?[1-9]\\d{1,14}$", message = "Telegram number must be valid")
    private String telegram;

    @Size(max = 255, message = "Address cannot exceed 255 characters")
    private String address;

    @Size(max = 500, message = "Description cannot exceed 500 characters")
    private String description;

    @Size(max = 500, message = "Services information cannot exceed 500 characters")
    private String services;

    @Size(max = 255, message = "Services prices information cannot exceed 255 characters")
    private String servicesPrices;

    @Size(max = 100, message = "Availability information cannot exceed 100 characters")
    private String availability;

    @Size(max = 500, message = "Photos URLs cannot exceed 500 characters")
    private String photos;

    @NotNull
    private String gender;

    @NotNull
    @Min(value = 0, message = "Age must be a positive number")
    private Integer age;  // Alterado para Integer, pois "age" parece ser um valor numérico
}
