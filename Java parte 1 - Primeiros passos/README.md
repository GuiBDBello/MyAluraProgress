# Java parte 1: Primeiros passos

## Aula 01 - O que é Java?

### Atividade 02 - A plataforma Java:

- Portável (diversos OS)
- Fácil
- Segura
- Onipresente (lugares onde está, perde apenas para o Javascript)

#### JVM:

- Problema: Cada aparelho tinha uma linguagem própria (não existia padronização).
- Solução: Escrever um único código-fonte (Java), gerando um "executável" (bytecode/.class), que seria processado por uma "máquina virtual", traduzindo-o para diversas plataformas (hardware/OS).

#### Plataforma JAVA:
  
- Máquina Virtual - JVM
- Bibliotecas - API
- Linguagens (várias linguagens geram bytecode Java)


## Aula 02 - Instalação e o primeiro programa

### Atividade 02 - Instalação do JDK no Windows:

- Instalar JDK pelo site da Oracle
- Configurar variável de ambiente (adicionar à PATH a pasta bin do diretório de instalação do JDK)

### Atividade 05 - Compile e rode seu primeiro programa Java:

- Todo programa Java deve possuir, no mínimo, uma classe e um método (main)
01. Crie um programa com a extensão .java
02. Compile-o pelo prompt/terminal, utilizando o comando `javac 'NomeDoPrograma.java'`
03. Execute-o pelo prompt/terminal, utilizando o comando `java 'NomeDoPrograma'`


## Aula 03 - Começando com Eclipse

### Atividade 01 - Instalando o Eclipse:

- Download: https://www.eclipse.org/downloads/

#### Eclipse IDE:

- Workspace: Diretório que contém vários projetos do mesmo 'interesse'
- View: 'Janela' com diversas ferramentas
- Perspectiva: Conjunto de Views

### Atividade 05 - Nosso programa rodando no Eclipse:

- Criar um novo projeto Java de nome sintaxe-basica
- Criar classe Programa dentro de src
- javaw não abre o prompt/terminal

#### Navigator:

- View Navigator: Mostra o 'File System' do projeto (similar ao Explorer do Windows)
- O Eclipse salva os arquivos .class dentro da pasta do projeto, no diretório bin\


## Aula 04 - Tipos e variáveis

### Atividade 01 - Tipo inteiro: int:

- Criar um novo projeto Java de nome sintaxe-variaveis-e-fluxo
- Criar nova classe TestaVariaveis dentro de src

#### Convenções de código:

- Classe: UpperCamelCase (Ex.: NomeDaMinhaClasse)
- Variável: 'tipo' lowerCamelCase (Ex.: int nomeDaMinhaVariavel)

### Atividade 04 - Tipo flutuante: double:

- Utiliza-se a palavra-chave 'double' para declarar o tipo 'Ponto Flutuante' (decimal)
- Em Java, os números decimais devem ser separados por ponto, nunca por vírgula (Ex.: 2.2, 5.55)
- O Java é fortemente tipado, ou seja, você precisa declarar as variáveis e seus tipos para utilizá-las