package com.ecommerce.sb_ecom.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// This will the request object
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CategoryDTO {
    private Long categoryId;
    private String categoryName;
}
