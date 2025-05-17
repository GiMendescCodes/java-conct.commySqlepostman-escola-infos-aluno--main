package com.giza.senai.Controller;

import com.giza.senai.Model.Professor;
import com.giza.senai.Service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    // Injeta automaticamente o service no controller
    @Autowired
    private ProfessorService professorService;

    // Retorna a lista de todos os professores
    @GetMapping
    public List<Professor> listaDeProfessores() {
        return professorService.buscarProfessores();
    }

    // Cria um novo professor
    @PostMapping
    public Professor criarProfessor(@RequestBody Professor professor) {
        return professorService.salvarProfessor(professor);
    }

    // Deleta um professor pelo ID
    @DeleteMapping("/{id}")
    public void deletarProfessor(@PathVariable Long id) {
        professorService.excluirProfessor(id);
    }

    // Atualiza um professor existente
    @PutMapping("/{id}")
    public Professor atualizar(@PathVariable Long id, @RequestBody Professor professor) {
        Professor verificaProfessor = professorService.buscarProfessorId(id);

        if (verificaProfessor == null) {
            throw new RuntimeException("Professor não encontrado!");
        }

        // Atualiza os dados do professor
        verificaProfessor.setNomeProfessor(professor.getNomeProfessor());
        verificaProfessor.setEmailProfessor(professor.getEmailProfessor());
        verificaProfessor.setTelefoneProfessor(professor.getTelefoneProfessor());

        return professorService.salvarProfessor(verificaProfessor);
    }
}
