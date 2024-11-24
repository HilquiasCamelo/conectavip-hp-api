package com.conectavip_hp.conectavip_hp.domain.core.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "escort")
@Getter
@Setter
@NoArgsConstructor
public class Escort {

 @Id
 @Column(name = "id")
 private Long id;

 @NotNull
 @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
 @Column(name = "name", nullable = false)
 private String name;

 @NotNull
 @Pattern(regexp = "^\\+?[1-9]\\d{1,14}$", message = "Phone number must be valid")
 @Column(name = "phone", nullable = false)
 private String phone;

 @Pattern(regexp = "^\\+?[1-9]\\d{1,14}$", message = "WhatsApp number must be valid")
 @Column(name = "whatsapp")
 private String whatsapp;

 @Pattern(regexp = "^\\+?[1-9]\\d{1,14}$", message = "Telegram number must be valid")
 @Column(name = "telegram")
 private String telegram;

 @Size(max = 255, message = "Address cannot exceed 255 characters")
 @Column(name = "address")
 private String address;

 @Size(max = 500, message = "Description cannot exceed 500 characters")
 @Column(name = "description")
 private String description;

 @Size(max = 500, message = "Services information cannot exceed 500 characters")
 @Column(name = "services")
 private String services;

 @Size(max = 255, message = "Services prices information cannot exceed 255 characters")
 @Column(name = "services_prices")
 private String servicesPrices;

 @Size(max = 100, message = "Availability information cannot exceed 100 characters")
 @Column(name = "availability")
 private String availability;

 @Size(max = 500, message = "Photos URLs cannot exceed 500 characters")
 @Column(name = "photos")
 private String photos;

 @NotNull
 @Column(name = "gender", nullable = false)
 private String gender;

 @NotNull
 @Column(name = "age", nullable = false)
 private String age;
}
