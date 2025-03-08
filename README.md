# AutoFix – Sistema de Gestão de Oficinas

O AutoFix é um sistema web para gerenciamento de oficinas mecânicas. Ele permite que clientes agendem serviços, mecânicos acompanhem ordens de serviço e administradores controlem a operação da oficina.

Tecnologias a Utilizar:
	•	Backend: Spring Boot (Spring MVC, Spring Data JPA, Spring Security)
	•	Banco de Dados: PostgreSQL ou MySQL
	•	Frontend: Thymeleaf ou React/Angular
	•	Autenticação: Spring Security com JWT
	•	Persistência: JPA/Hibernate
	•	Ferramentas: Maven/Gradle, Git, Docker (opcional)

Funcionalidades Principais:
	1.	CRUD com Persistência:
	•	Cadastro e gerenciamento de clientes
	•	Cadastro e gerenciamento de veículos vinculados aos clientes
	•	Registro e atualização de ordens de serviço (consertos, revisões, trocas de peças)
	•	Controle de mecânicos e atribuição de serviços a eles
	2.	Dados Complexos:
	•	Histórico de serviços realizados em cada veículo
	•	Orçamentos detalhados para clientes antes da execução do serviço
	•	Controle de estoque de peças usadas nas ordens de serviço
	3.	Relacionamentos de Entidades:
	•	Cliente → Veículos (um para muitos)
	•	Veículo → Ordens de Serviço (um para muitos)
	•	Ordem de Serviço → Mecânico (muitos para um)
	•	Ordem de Serviço → Peças (muitos para muitos)
	4.	Autenticação:
	•	Login para clientes, mecânicos e administradores
	•	Clientes podem visualizar histórico de serviços e orçamentos
	•	Mecânicos acessam apenas suas ordens de serviço
	•	Administradores gerenciam usuários, serviços e estoque

Extras para Diferencial:
	•	Envio automático de e-mails para clientes sobre status das ordens de serviço
	•	Integração com API para calcular orçamentos de peças em tempo real
	•	Relatórios sobre desempenho da oficina e fluxo de serviços

Divisão do Trabalho para a Dupla:
	•	Pessoa 1 (Backend):
	•	Criar API REST com Spring Boot
	•	Implementar autenticação e segurança
	•	Modelar banco de dados com JPA
	•	Pessoa 2 (Frontend):
	•	Criar interface para agendamentos e ordens de serviço
	•	Conectar o frontend ao backend usando API REST
	•	Desenvolver telas de login e painel de controle