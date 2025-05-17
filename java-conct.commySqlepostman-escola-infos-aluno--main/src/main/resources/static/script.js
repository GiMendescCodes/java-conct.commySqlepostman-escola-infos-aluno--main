document.addEventListener('DOMContentLoaded', () => {
  fetch('http://localhost:8080/alunos.html')
    .then(response => response.json())
    .then(data => {
      const tbody = document.getElementById('aluno-tbody');
      data.forEach(aluno => {
        const tr = document.createElement('tr');

        tr.innerHTML = `
          <td>${aluno.nomeAluno}</td>
          <td>${aluno.emailAluno}</td>
          <td>${aluno.telefoneAluno}</td>
        `;

        tbody.appendChild(tr);
      });
    })
    .catch(error => {
      console.error('Erro ao buscar alunos:', error);
      alert('Erro ao carregar a lista de alunos.');
    });
});

document.addEventListener('DOMContentLoaded', () => {
  fetch('http://localhost:8080/professores')
    .then(response => response.json())
    .then(data => {
      const tbody = document.getElementById('professor-tbody');
      data.forEach(professor => {
        const tr = document.createElement('tr');

        tr.innerHTML = `
          <td>${professor.nomeProfessor}</td>
          <td>${professor.emailProfessor}</td>
          <td>${professor.telefoneProfessor}</td>
        `;

        tbody.appendChild(tr);
      });
    })
    .catch(error => {
      console.error('Erro ao buscar professores:', error);
      alert('Erro ao carregar a lista de professores.');
    });
});