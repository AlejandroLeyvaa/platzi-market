package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.Category;
import com.platzi.market.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    // Aquí hacemos la conversion, indicamos de donde traeremos el objeto a convertir (source) y a qué lo queremos convertir (target)
    // El source viene de la clase Categoria
    @Mappings({
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "descripcion", target = "category"),
            @Mapping(source = "estado", target = "active"),
    })

    Category toCategory(Categoria categoria);

    /*
    * En Categoria tenemos la variable productos, pero en Category no
    * Debemos de indicarlo
    * Lo hacemos con @Mapping
    */
    @InheritInverseConfiguration
    @Mapping(target = "productos", ignore = true)
    Categoria toCategoria(Category category);
}
