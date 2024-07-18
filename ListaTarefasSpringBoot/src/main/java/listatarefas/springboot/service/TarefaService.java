package listatarefas.springboot.service;

import listatarefas.springboot.model.Tarefa;

public interface TarefaService {
	// Aplicando o padrão "Strategy";
	Iterable<Tarefa> buscarTodasAsTarefas();

	Tarefa buscarPorId(Long id);

	void inserirNovaTarefa(Tarefa tarefa);

	void atualizarTarefa(Long id, Tarefa tarefa);
	
	void deletarTarefa(Long id);
}
