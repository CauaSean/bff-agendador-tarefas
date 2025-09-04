package com.caua.bffagendadortarefas.controller;


import com.caua.bffagendadortarefas.business.TarefasService;
import com.caua.bffagendadortarefas.business.dto.TarefasDTO;
import com.caua.bffagendadortarefas.business.enums.StatusNotificacaoEnum;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/tarefas")
@RequiredArgsConstructor
@Tag(name = "Tarefas", description = "Cadastra tarefas de usuários")
public class TarefasController {

    private final TarefasService tarefasService;

    @PostMapping
    @Operation(summary = "Salvar Tarefa de Usuários", description = "Cria uma nova tarefa")
    @ApiResponse(responseCode =  "200", description = "Tarefa salva com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<TarefasDTO> gravarTarefas(@RequestBody TarefasDTO dto,
                                                    @RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(tarefasService.gravarTarefas(dto, token));
    }

    @GetMapping("/eventos")
    @Operation(summary = "Buscar Tarefas por Período", description = "Busca tarefas cadastradas por período")
    @ApiResponse(responseCode =  "200", description = "Tarefas encontradas")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<List<TarefasDTO>> buscaListaDeTarefasPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFinal,
            @RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(tarefasService.buscarTarefasAgendadasPorPeriodo(dataInicial, dataFinal, token));
    }

    @GetMapping
    @Operation(summary = "Buscar Lista de Tarefas por Email de Usuário", description = "Busca tarefas cadastradas por usuário")
    @ApiResponse(responseCode =  "200", description = "Tarefas encontradas")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<List<TarefasDTO>> buscaTarefasPorEmail(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(tarefasService.buscarTarefasPorEmail(token));
    }

    @DeleteMapping
    @Operation(summary = "Deletar Tarefas por Id", description = "Deleta tarefas cadastradas por Id")
    @ApiResponse(responseCode =  "200", description = "Tarefas deletadas")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<Void> deletarTarefasPorId(@RequestParam("id") String id,
                                                    @RequestHeader("Authorization") String token) {
        tarefasService.deletarTarefasPorId(id, token);

        return ResponseEntity.ok().build();
    }

    @PatchMapping
    @Operation(summary = "Alterar Status de Tarefas", description = "Altera status das tarefas cadastradas")
    @ApiResponse(responseCode =  "200", description = "Status da tarefa alterado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<TarefasDTO> alteraStatusNotificacao(@RequestParam("status") StatusNotificacaoEnum status,
                                                              @RequestParam("id") String id, @RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(tarefasService.alteraStatus(status, id, token));
    }

    @PutMapping
    @Operation(summary = "Alterar Dados de Tarefas", description = "Altera dados das tarefas cadastradas")
    @ApiResponse(responseCode =  "200", description = "Tarefas alteradas")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<TarefasDTO> updateTarefas(@RequestBody TarefasDTO dto,
                                                    @RequestParam("id") String id, @RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(tarefasService.updateTarefas(dto, id, token));
    }
}
