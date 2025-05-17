package com.giza.senai.Controller;


import com.giza.senai.Model.Aluno;
import com.giza.senai.Service.AlunoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService){
        this.alunoService = alunoService;
    }

    @GetMapping
    public List<Aluno> listaDeAlunos(){
        return alunoService.buscarAlunos();
    }

    @PostMapping
    public Aluno criarAluno(@RequestBody Aluno aluno){
        return alunoService.salvarAluno(aluno);
    }

    @DeleteMapping("/{id}")
        public void deletarAluno(@PathVariable Long id){
        alunoService.excluirAluno(id);
    }

    @PutMapping("/{id}")
    public Aluno atualizar(@PathVariable Long id, @RequestBody Aluno aluno){
        Aluno verificaAluno = alunoService.buscarAlunoId(id);
        if(verificaAluno == null) return null;

        verificaAluno.setNomeAluno(aluno.getNomeAluno());
        verificaAluno.setEmailAluno(aluno.getEmailAluno());
        verificaAluno.setTelefoneAluno(aluno.getTelefoneAluno());
        verificaAluno.setId(aluno.getId());

        return alunoService.salvarAluno(verificaAluno);
    }

}

