package com.javanauta.marcos.agendador_tarefas.business.mapper;

import com.javanauta.marcos.agendador_tarefas.business.dto.TarefasDTO;
import com.javanauta.marcos.agendador_tarefas.infrastructure.entity.TarefaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TarefaUpdateConverter {

    void updateTarefas(TarefasDTO dto, @MappingTarget TarefaEntity entity);
}
