
# Projeto de Serviço CRUD com Princípios SOLID

## Sumário
1. [Introdução](#introdução)
2. [Princípios SOLID](#princípios-solid)
3. [Padrão Strategy](#padrão-strategy)
4. [Estrutura do Projeto](#estrutura-do-projeto)
5. [Implementação](#implementação)
    - [Definição da Interface de Persistência](#definição-da-interface-de-persistência)
    - [Implementação das Estratégias de Persistência](#implementação-das-estratégias-de-persistência)
    - [Classe BaseCrudService](#classe-basecrudservice)
    - [Serviço Específico CatService](#serviço-específico-catservice)
    - [Uso no Cliente](#uso-no-cliente)
6. [Execução do Projeto](#execução-do-projeto)
7. [Conclusão](#conclusão)

## Introdução

Este projeto demonstra a implementação de um serviço CRUD genérico utilizando os princípios SOLID, com foco no Princípio Aberto/Fechado (OCP). A abordagem utilizada permite a extensão de funcionalidades sem modificar o código existente, facilitando a manutenção e escalabilidade do sistema.

## Princípios SOLID

- **S - Single Responsibility Principle (Princípio da Responsabilidade Única)**: Cada classe tem uma única responsabilidade.
- **O - Open/Closed Principle (Princípio Aberto/Fechado)**: O código é aberto para extensão, mas fechado para modificação.
- **L - Liskov Substitution Principle (Princípio da Substituição de Liskov)**: As subclasses devem ser substituíveis por suas classes base.
- **I - Interface Segregation Principle (Princípio da Segregação de Interfaces)**: Múltiplas interfaces específicas são melhores que uma interface única geral.
- **D - Dependency Inversion Principle (Princípio da Inversão de Dependência)**: Dependa de abstrações, não de concretizações.

## Padrão Strategy

O padrão Strategy é um padrão de design comportamental que permite que um algoritmo seja selecionado em tempo de execução. Esse padrão define uma família de algoritmos, encapsula cada um deles e os torna intercambiáveis. O padrão Strategy permite que o algoritmo varie independentemente dos clientes que o utilizam.

Neste projeto, o padrão Strategy é utilizado para implementar diferentes estratégias de persistência, como persistência em memória (lista) e persistência em banco de dados. Isso permite que novas estratégias de persistência sejam adicionadas sem modificar o código existente, atendendo ao Princípio Aberto/Fechado (OCP).

## Estrutura do Projeto

```plaintext
src/
├── domain/
│   ├── CrudService.java
│   ├── BaseCrudService.java
│   ├── PersistenceOperation.java
│   ├── ListPersistenceOperation.java
│   ├── DatabasePersistenceOperation.java
│   └── DataRepository.java
├── cat/
│   ├── Cat.java
│   ├── CatService.java
├── Client.java
└── README.md
```
## Implementação

### Definição da Interface de Persistência

  
    package domain;
    
    import java.util.List;
    
    public interface PersistenceOperation<T> {
        T create(T entity);
        List<T> getAll();
    }

### Implementação das Estratégias de Persistência

#### Estratégia de Persistência em Lista


    package domain;
    
    import java.util.ArrayList;
    import java.util.List;
    
    public class ListPersistenceOperation<T> implements PersistenceOperation<T> {
        private final List<T> data = new ArrayList<>();
    
        @Override
        public T create(T entity) {
            data.add(entity);
            return entity;
        }
    
        @Override
        public List<T> getAll() {
            return new ArrayList<>(data);
        }
    }

#### Estratégia de Persistência em Banco de Dados

    package domain;
    
    import java.util.List;
    
    public class DatabasePersistenceOperation<T> implements PersistenceOperation<T> {
        @Override
        public T create(T entity) {
            // Implemente a lógica para persistir a entidade em um banco de dados
            return entity;
        }
    
        @Override
        public List<T> getAll() {
            // Implemente a lógica para recuperar todas as entidades do banco de dados
            return null; // Apenas um exemplo, substitua pela implementação real
        }
    }

### Classe BaseCrudService
   

     
    package domain;
    
    import java.util.List;
    
    public class BaseCrudService<T, ID> {
        private final PersistenceOperation<T> persistenceOperation;
    
        public BaseCrudService(PersistenceOperation<T> persistenceOperation) {
            this.persistenceOperation = persistenceOperation;
        }
    
        public T create(T entity) {
            return persistenceOperation.create(entity);
        }
    
        public List<T> getAll() {
            return persistenceOperation.getAll();
        }
    }

## Serviço Específico CatService

 

      package cat;
    
    import domain.BaseCrudService;
    import domain.PersistenceOperation;
    
    public class CatService extends BaseCrudService<Cat, String> {
        public CatService(PersistenceOperation<Cat> persistenceOperation) {
            super(persistenceOperation);
        }
    }

### Uso no Cliente

    public class Client {
        public static void main(String[] args) {
            PersistenceOperation<Cat> listPersistenceOperation = new ListPersistenceOperation<>();
            CatService catService = new CatService(listPersistenceOperation);
    
            Cat cat1 = new Cat(1, "Fluffy", 3, 0.5);
            Cat cat2 = new Cat(2, "Whiskers", 3, 0.5);
    
            catService.create(cat1);
            catService.create(cat2);
    
            List<Cat> allCats = catService.getAll();
            System.out.println(allCats);
        }
    }

## Execução do Projeto

Para executar o projeto, compile e execute a classe `Client`. Certifique-se de que todas as dependências estão corretamente configuradas em seu ambiente de desenvolvimento.

## Conclusão

Este projeto demonstra como aplicar os princípios SOLID para criar um serviço CRUD genérico e extensível. O uso de estratégias de persistência permite que o sistema seja facilmente estendido para suportar diferentes mecanismos de armazenamento sem modificar o código existente, atendendo ao Princípio Aberto/Fechado (OCP).

