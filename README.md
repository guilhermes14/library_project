# library_project
Projeto de Bloco de Engenharia de Softwares Escaláveis

O projeto consiste em dois microsserviços para catalogar quais livros estão disponíveis em cada biblioteca. O serviço de Book adiciona, lista, edita e remove livros de seu banco de dados, e o serviço de Library cria, remove e adiciona livros na  biblioteca, consumindo o serviço de Book que disponibiliza quais livros ele pode adicionar. Todos os requisitos funcionais foram cumpridos. 


<img width="439" height="490" alt="image" src="https://github.com/user-attachments/assets/9872d611-a4e8-40bf-a885-cffaab5b9d68" />


COMO RODAR O SISTEMA:
- Redirecionar o banco de dados, para o banco local no application.yml;
- Para configurar as targets que serão utilizadas para o docker é necessário aplicar o comando no terminal de cada um dos serviços:
```
mvn clean package -DskipTests
```
-  Logo após, será necessário construir a imagem de cada serviço:
```
mvn spring-boot:build-image -DskipTests
```
-  Depois, com as imagens feitas, basta ir no terminal da pasta onde estão os microsserviços e rodar o docker:
```
docker compose up --build
```

EXEMPLOS DE REQUISIÇÃO COM O DOCKER FUNCIONANDO:
<img width="713" height="185" alt="image" src="https://github.com/user-attachments/assets/ed8a6b04-522a-4716-a1f2-d66ddbe784c9" />
<img width="488" height="117" alt="image" src="https://github.com/user-attachments/assets/4e7cce8a-b70e-40a5-ae94-87a420824c97" />


PROBLEMAS DO SISTEMA:
- Faltou ser implementado o config-server do projeto;
- Consertar no futuro a imagem do docker de library-service (erro no migration do FlyWay), apesar de funcionar perfeitamente rodando no IntelliJ;
<img width="1229" height="264" alt="image" src="https://github.com/user-attachments/assets/4b31da6e-215e-4c51-bb68-6fa21f3f8cd0" />

- Implementar mais testes unitários + Resilience4J, para obter mais respostas do sistema(Exemplo de fallback rodando no library-service);
<img width="937" height="93" alt="image" src="https://github.com/user-attachments/assets/381a8f0e-aae0-4534-9c2e-cf37d6dc927e" />

