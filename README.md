Task Management App

📖 Descrição

Este projeto é um aplicativo de gerenciamento de tarefas (TODO) desenvolvido em Kotlin para Android, utilizando arquitetura simples e banco de dados SQLite.

Funcionalidades principais

Criar tarefa: tela para adicionar nome, data, hora e descrição.

Listar tarefas: lista paginada de todas as tarefas salvas.

Atualizar tarefa: editar dados de uma tarefa existente.

Excluir tarefa: remover tarefas com confirmação.

Onboarding: telas iniciais de boas-vindas antes de entrar no app.

Navegação: navegação simples entre telas (Home, Adicionar, Configurações, Lista).

📝 Padrões de Nomenclatura e Boas Práticas

Activities: sufixo Activity (ex.: AddTaskActivity).

Layouts: activity_<nome>. Ex.: activity_add_task.xml.

IDs de Views: em camelCase iniciando com tipo: btnSaveTask, rvTaskList.

Classes de dados: data class Task(...).

Banco SQLite: helper TasksDatabase com constantes em UPPER_SNAKE_CASE.