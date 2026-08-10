package com.javanauta.marcos.agendador_tarefas.infrastructure.repository;

import com.javanauta.marcos.agendador_tarefas.infrastructure.entity.TarefaEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends MongoRepository<TarefaEntity, String> {
}
