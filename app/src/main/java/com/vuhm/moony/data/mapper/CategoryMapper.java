package com.vuhm.moony.data.mapper;

import com.vuhm.moony.data.entity.CategoryEntity;
import com.vuhm.moony.domain.mapper.IMapper;
import com.vuhm.moony.domain.model.Category;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

public class CategoryMapper implements IMapper<CategoryEntity, Category> {


    @Override
    public Category mapFromEntity(CategoryEntity category) {
        return new Category(
                category.getId(),
                category.getTitle(),
                category.getIconResId(),
                category.isIncome(),
                category.getCreatedDate(),
                category.getUpdatedDate()
        );
    }

    @Override
    public CategoryEntity mapToEntity(Category category) {
        return new CategoryEntity(
                category.getId(),
                category.getTitle(),
                category.getIconResId(),
                category.isIncome(),
                category.getCreatedDate(),
                category.getUpdatedDate()
        );
    }

    public Observable<List<Category>> mapFromEntityList(Observable<List<CategoryEntity>> categoryEntity) {
        return categoryEntity.map(entities -> {
            List<Category> list = new ArrayList<>();
            for (int i = 0; i < entities.size(); i++) {
                list.add(mapFromEntity(entities.get(i)));
            }
            return list;
        });
    }

    public Observable<List<CategoryEntity>> mapToEntityList(Observable<List<Category>> category) {
        return category.map(model -> {
            List<CategoryEntity> list = new ArrayList<>();
            for (int i = 0; i < model.size(); i++) {
                list.add(mapToEntity(model.get(i)));
            }
            return list;
        });
    }
}
