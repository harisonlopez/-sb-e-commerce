package com.ecommerce.sb_ecom.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    private Long categoryId;
    @NotBlank(message = "Category name is required")
    @Size(min = 3, message = "Category name must have at least 3 characters")
    private String categoryName;
}
