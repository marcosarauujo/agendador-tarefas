package com.javanauta.marcos.agendador_tarefas.business;

import com.javanauta.marcos.agendador_tarefas.business.dto.TarefasDTO;
import com.javanauta.marcos.agendador_tarefas.business.mapper.TarefaConverter;
import com.javanauta.marcos.agendador_tarefas.infrastructure.entity.TarefaEntity;
import com.javanauta.marcos.agendador_tarefas.infrastructure.enums.StatusNotificacaoEnum;
import com.javanauta.marcos.agendador_tarefas.infrastructure.repository.TarefaRepository;
import com.javanauta.marcos.agendador_tarefas.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefaService {

    private final TarefaRepository tarefasRepository;
    private final TarefaConverter tarefaConverter;
    private final JwtUtil jwtUtil;

    public TarefasDTO gravarTarefas(String token, TarefasDTO dto) {
        String email = jwtUtil.extrairEmailToken(token.substring(7));//identifica o cliente atraves do email
        dto.setEmailUsuario(email);
        dto.setDataCriacao(LocalDateTime.now());
        dto.setStatusNotificacaoEnum(StatusNotificacaoEnum.PENDENTE);
        TarefaEntity entity = tarefaConverter.paraTarefaEntity(dto);
        return tarefaConverter.paraTarefaDTO(
                tarefasRepository.save(entity)
        );
    }

    public List<TarefasDTO> buscaTarefaAgendadasPorPeriodo(LocalDateTime dataInicial, LocalDateTime dataFinal) {
        return tarefaConverter.paraListaTarefaDTO(
                tarefasRepository.findByDataEventoBetween(dataInicial, dataFinal));
    }

    public List<TarefasDTO> buscaTarefaPorEmail(String token) {
        String email = jwtUtil.extrairEmailToken(token.substring(7));
        List<TarefaEntity> listaTarefas = tarefasRepository.findByEmailUsuario(email);
        return tarefaConverter.paraListaTarefaDTO(listaTarefas);
    }

}
