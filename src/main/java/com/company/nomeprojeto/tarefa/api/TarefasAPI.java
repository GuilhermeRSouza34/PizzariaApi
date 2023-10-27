package com.company.nomeprojeto.tarefa.api;

import com.company.nomeprojeto.tarefa.dto.TarefaDTO;
import com.company.nomeprojeto.tarefa.facade.TarefaFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/tarefas", produces = MediaType.APPLICATION_JSON_VALUE)
public class TarefasAPI {
    @Autowired
    private TarefaFacade tarefaFacade;

    @PostMapping
    @ResponseBody
    public TarefaDTO criar(@RequestBody TarefaDTO tarefaDTO) {
        return tarefaFacade.criar(tarefaDTO);
    }

    @PutMapping("/{tarefaId}")
    @ResponseBody
    public TarefaDTO atualizar(@PathVariable("tarefaId") Long tarefaId,
                               @RequestBody TarefaDTO tarefaDTO) {
        return tarefaFacade.atualizar(tarefaDTO, tarefaId);
    }

    @GetMapping
    @ResponseBody
    public List<TarefaDTO> getAll() {
        return tarefaFacade.getAll();
    }

    @DeleteMapping("/{tarefaId}")
    @ResponseBody
    public String delete(@PathVariable("tarefaId") Long tarefaId) {
        return tarefaFacade.delete(tarefaId);
    }
}
