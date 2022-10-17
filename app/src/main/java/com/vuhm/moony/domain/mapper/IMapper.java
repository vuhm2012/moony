package com.vuhm.moony.domain.mapper;

public interface IMapper<Entity, Model> {

    Model mapFromEntity(Entity entity);

    Entity mapToEntity(Model model);

}
