package com.xworkz.inventory.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class DairyDto {

    private Integer id;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @NotBlank
    @Size(min = 5, max = 20, message = "dairyName should be between 5 and 20 characters")
    private String dairyName;

    @NotBlank
    @Size(min = 3, max = 20, message = "ownerName should be between 3 and 20 characters")
    private String ownerName;

    private String location;

    @NotBlank
    @Pattern(regexp = "^[0-9]{10}$", message = "phoneNumber should be 10 digits")
    private String phoneNumber;
}
