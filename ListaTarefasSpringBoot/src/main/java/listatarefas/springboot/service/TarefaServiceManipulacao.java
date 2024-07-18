package listatarefas.springboot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import listatarefas.springboot.model.Tarefa;
import listatarefas.springboot.model.TarefaRepository;

@Service
public class TarefaServiceManipulacao implements TarefaService {

	@Autowired
	private TarefaRepository tarefaRepository;
	@Autowired

	public Iterable<Tarefa> buscarTodasAsTarefas() {
		return tarefaRepository.findAll();
	}

	@Override
	public Tarefa buscarPorId(Long id) {
		Optional<Tarefa> tarefa = tarefaRepository.findById(id);
		return tarefa.get();
	}

	@Override
	public void inserirNovaTarefa(Tarefa tarefa) {
		if (tarefa.getNome().isEmpty() == false) {
			tarefa.setNome("Teste");
			tarefa.setDescricao("Estou testando");
			tarefaRepository.save(tarefa);
		}
	}

	@Override
	public void atualizarTarefa(Long id, Tarefa tarefa) {
		Optional<Tarefa> tarefas = tarefaRepository.findById(id);
		
		if(tarefas.isPresent()) {
			tarefa.setNome("Teste 2");
			tarefa.setDescricao("Novamento testando!");
			tarefaRepository.save(tarefa);
		} 
	}

	@Override
	public void deletarTarefa(Long id) {
		tarefaRepository.deleteById(id);
	}
}
