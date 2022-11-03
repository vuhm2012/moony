package com.vuhm.moony.data.mapper;

import com.vuhm.moony.data.entity.SavingEntity;
import com.vuhm.moony.domain.mapper.IMapper;
import com.vuhm.moony.domain.model.Saving;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

public class SavingMapper implements IMapper<SavingEntity, Saving> {
    @Override
    public Saving mapFromEntity(SavingEntity savingEntity) {
        return new Saving(
                savingEntity.getSavingId(),
                savingEntity.getTitle(),
                savingEntity.getDescription(),
                savingEntity.getGoal(),
                savingEntity.getCreatedAt(),
                savingEntity.getUpdatedAt()
        );
    }

    @Override
    public SavingEntity mapToEntity(Saving saving) {
        return new SavingEntity(
                saving.getId(),
                saving.getTitle(),
                saving.getDescription(),
                saving.getGoal(),
                saving.getCreatedAt(),
                saving.getUpdatedAt()
        );
    }

    public Observable<List<Saving>> mapFromEntityList(Observable<List<SavingEntity>> savingEntity) {
        return savingEntity.map(entities -> {
            List<Saving> list = new ArrayList<>();
            for (int i = 0; i < entities.size(); i++) {
                list.add(mapFromEntity(entities.get(i)));
            }
            return list;
        });
    }

    public Observable<List<SavingEntity>> mapToEntityList(Observable<List<Saving>> saving) {
        return saving.map(model -> {
            List<SavingEntity> list = new ArrayList<>();
            for (int i = 0; i < model.size(); i++) {
                list.add(mapToEntity(model.get(i)));
            }
            return list;
        });
    }
}
