Processo de instalação e configuração da aplicação

1. Pré-requisitos
Sistema Operacional: Windows.
Dependências: Java JDK 17, Spring 4.0.0, Node.js, Banco de dados H2 em memória.

2. Download da Aplicação
BackEnd em https://github.com/GuiBarrinha/estagioStefanini
FrontEnd em https://github.com/GuiBarrinha/estagioStefaniniFrontEnd

3. Instalação
Não contém executável.
Obs: BackEnd foi construído na IDE Eclipse, e FrontEnd no VS Code.

4. Configuração
Arquivos de Configuração: Não possui.
Variáveis de Ambiente: Não possui.
Banco de Dados: H2 em memória. 

5. Execução da Aplicação

BackEnd: 
Passo 1: Fazer o Download ZIP do estagioStefanini no GitHub(https://github.com/GuiBarrinha/estagioStefanini).
Passo 2: Fazer o Unzip na pasta desejada.
Passo 3: Fazer o import Maven do projeto estagioStefanini.
Passo 4: Executar o programa (src/main/java/com/example/ApiTarefa/ApiTarefaApplication.java).
Passo 5: No navegador executar o Swagger (http://localhost:8080/swagger-ui.html).
Passo 6: Testar todos os endpoints.

FrontEnd (Obs: Note.js deve estar instalado):
Passo 1: Fazer o Download ZIP do estagioStefaniniFrontEnd no GitHub (https://github.com/GuiBarrinha/estagioStefaniniFrontEnd).
Passo 2: Fazer o Unzip na pasta desejada.
Passo 3: Abrir tarefa-app no terminal.
Passo 4: Executar npm install (Instala todas as bibliotecas necessárias).
Passo 5: Executar npm start.
Passo 6: Testar a API.


6. Testes Pós-Instalação
Pelo Postman (localhost:8080), teste os endpoints GET, POST, PUT e DELETE.
Pelo Swagger (http://localhost:8080/swagger-ui.html), teste os endpoints GET, POST, PUT e DELETE.
Pelo FrontEnd (http://localhost:3000), testar o aplicativo.
