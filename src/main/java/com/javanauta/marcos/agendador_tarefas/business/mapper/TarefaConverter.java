package com.javanauta.marcos.agendador_tarefas.business.mapper;

import com.javanauta.marcos.agendador_tarefas.business.dto.TarefasDTO;
import com.javanauta.marcos.agendador_tarefas.infrastructure.entity.TarefaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TarefaConverter {
    TarefaEntity paraTarefaEntity (TarefasDTO dto);
    TarefasDTO paraTarefaDTO (TarefaEntity entity);
}
