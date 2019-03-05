# Linux I: Conhecendo e utilizando o terminal

## Aula 01 - Trabalhando com arquivos e diretórios

### Atividade 03 - Comandos de arquivos:

#### Comandos:

- pwd: mostra o diretório atual;
- ls: mostra/lista os arquivos e diretórios do diretório atual;
- echo 'args': mostra a mensagem 'args' (repete, eco);
- > arquivo.extensao: redireciona um comando para um arquivo
**Ex.:** echo "Hello World!" > helloworld.txt
- cat 'args': mostra o conteúdo do arquivo 'args';
- clear: limpa a tela;
- ls -l: mostra/lista informações extras dos arquivos do diretório atual. As informações são:
`-`: negação/não é/não possui permissão;
`d`: diretório;
`guilherme`: usuário dono do arquivo;
`guilherme`: grupo dono do arquivo;
`10`: tamanho (em kilobits) do arquivo;
`Jun 11 15:24`: data da última modificação do arquivo;
`bemvindo.txt`: nome do arquivo;
- ls -la: mostra/lista arquivos e diretórios ocultos;
- man 'args': mostra um manual sobre o comando 'args'. Pressione a letra 'q' para sair;

#### Teclas:

- Seta para cima: mostra o último comando executado;
- Tab/Duplo Tab: autocompleta o comando/arquivo, ou mostra os arquivos cujo nome possui relação ao texto digitado;

### Atividade 05 - O whoami:

#### Comandos:

- whoami: retorna o nome do usuário em uso;

### Atividade 11 - Manual do comando:

- cat -n 'args': mostra o conteúdo do arquivo 'args' e o parâmetro '-n' mostra as linhas;
