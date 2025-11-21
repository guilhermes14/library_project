# library_project
Projeto de Bloco de Engenharia de Softwares Escaláveis

O projeto consiste em dois microsserviços para catalogar quais livros estão disponíveis em cada biblioteca. O serviço de Book adiciona, lista, edita e remove livros de seu banco de dados, e o serviço de Library cria, remove e adiciona livros na  biblioteca, consumindo o serviço de Book que disponibiliza quais livros ele pode adicionar.

<img width="439" height="490" alt="image" src="https://github.com/user-attachments/assets/9872d611-a4e8-40bf-a885-cffaab5b9d68" />

Como rodar o sistema:
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

