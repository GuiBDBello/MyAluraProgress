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


## Aula 02 - Mais sobre redirecionamento e caracteres coringa no bash

### Atividade 01 - Redirecionamento e diretórios:

#### Comandos:

- cd 'args': change directory. Muda o diretório acessado para 'args';
- echo 'args' >> arquivo.extensao: redireciona um comando para um arquivo, concatenando o conteúdo ao arquivo;
- cd ..: retorna ao diretório anterior (diretório pai);
- cd .: muda o diretório atual para diretório atual (sim, isso mesmo). O diretório '.' (ponto) é o diretório atual;
- mkdir 'args': make directory. Cria um novo diretório de nome 'args';
- cd: muda o diretório para seu diretório base;

- Diretório '/': diretório raiz do HD. Ele possui diversos diretórios úteis do Linux;
- Diretório '/home': possui os diretórios com os usuários da máquina;


### Atividade 02 - Caracteres coringas no bash:

#### Comandos:

- rmdir 'args': remove directory. Remove o diretório 'args';
- rm 'args': remove. Remove o arquivo 'args';
- rm -r 'args': remove recursive. Remove o arquivo/diretório 'args' e todo o conteúdo dentro dele;

#### Coringas:

Em um diretório:
```
- arquivo10.txt
- arquivo1.txt
- arquivo2.txt
```
- cat arquivo?.txt: mostra o conteúdo dos arquivos com um caracter no lugar do '?';
- cat arquivo*.txt: mostra o conteúdo dos arquivos com qualquer conteúdo entre 'arquivo' e '.txt';
- cat *.txt: mostra o conteúdo de todos os arquivos com extensão .txt no diretório atual;


## Aula 03 - Manipulando, compactando e descompactando arquivos.

### Atividade 01 - Copiando, movendo e renomeando:

#### Comandos: 

- cp 'args1' 'args2': copy. Copia o arquivo 'args1' para 'args2';
- mv 'args1' 'args2': move. Move/Renomeia o arquivo 'args1' para 'args2';
- ls arquivo*: mostra todos os arquivos que iniciam com o nome 'arquivo';
- ls *: mostra todos os arquivos da pasta atual, e de todas as pastas filhas;

#### Dicas:

- Ao mover um arquivo com o comando 'mv', quando se deseja preservar o nome do arquivo, é necessário passar como parâmetro apenas o diretório;
- Para copiar um diretório, deve-se utilizar o parâmetro -r (recursive);

### Atividade 02 - Criando e abrindo ZIP:

#### Comandos:

- zip 'args1'.zip 'args2': cria o arquivo 'args1'.zip, compactando o arquivo 'args2';
- zip -r 'args1'.zip 'args2': cria o arquivo 'args1'.zip, compactando o diretório 'args2';
- unzip -l 'args': mostra o conteúdo do arquivo 'args';
- unzip 'args1': descompacta o arquivo 'args1' no diretório atual;
- unzip -q 'args1': quiet. Descompacta o arquivo 'args1' no diretório atual, com menos verbosidade;

### Atividade 05 - Comando ls:

#### Comandos:

- 'ls' ou 'ls .': lista todos os arquivos do diretório atual;
- ls *: lista todos os diretórios dentro do diretório atual, e os arquivos dentro desses diretórios;


## Aula 04 - Mais sobre compactação e descompactação e comandos do terminal

### Atividade 01 - Compactação e descompactação tar:

#### Comandos:

- tar -cz 'args1' > 'args2'.tar.gz: create zip. Compacta o arquivo/diretório 'args1' (Por padrão, o tar já é recursivo) com o nome 'args2'.tar.gz;
- tar -xz < 'args1'.tar.gz: extract zip. Descompacta o arquivo compactado 'args1'.tar.gz;
- tar -czf 'args1'.tar.gz 'args2': create zip file. Cria o arquivo 'args1'.tar.gz compactando o arquivo/diretório 'args2';
- tar -xzf 'args1'.tar.gz: extract zip file. Descompacta o arquivo 'args1'.tar.gz;
- tar -vxzf 'args1'.tar.gz: verbose extract zip file. Descompacta verbosamente o arquivo 'args1'.tar.gz;

### Atividade 04 - Para saber mais: bzip2:

- 'tar' não compacta, apenas empacota os arquivos. Pode-se compactar no formato .gz pelo compactador gzip;
- Além do gzip, pode-se utilizar o .bzip2 para compactar os arquivos. Ele é mais eficiente na compactação, e cria arquivos menores, porém leva mais tempo para compactá-lo;

#### Comandos:

- tar -cjf 'args1'.tar.bz2 'args2': create bzip2 file. Cria o arquivo 'args1'.tar.bz2 compactando o arquivo 'args2';

### Atividade 05 - touch, data da última modificação e data do sistema:

- touch 'args': "Encosta" no arquivo 'args', alterando sua data da última modificação;

### Atividade 06 - Para saber mais: obtendo ajuda e formatando datas:

#### Comandos:

- --help: parâmetro suportado por alguns comandos que serve para obter informações sobre o comando;
- help 'args': comando interno do 'bash' que, quando executado sem parâmetros, retorna uma lista com todos os demais comandos internos do shell 'bash'. Quando executado com parâmetro, retorna a sintaxe de utilização e uma descrição do comando interno 'args' (opcional);
- date "+%d/%m/%Y": imprime a data no formato `dia/mes/ano`;

### Atividade 08 - Less, head, tail:

#### Comandos:

- head 'args': retorna as primeiras 10 linhas do arquivo 'args';
- head -n 'linhas' 'args': retorna as primeiras 'linhas' linhas do arquivo 'args';
- tail 'args': retorna as 10 últimas linhas do arquivo 'args';
- less 'args': abre o arquivo 'args', e pode-se utilizar as setas para navegar nesse arquivo;
