package com.smartbuyhub.catalog.mapper;

import com.smartbuyhub.domain.Product;
import com.smartbuyhub.catalog.model.ProductDTO;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDTO toDTO(Product product);
    Product toEntity(ProductDTO productDTO);

    List<ProductDTO> toDTOList(List<Product> products);
    List<Product> toEntityList(List<ProductDTO> productDTOs);
}
