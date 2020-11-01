# Linux II: Programas, processos e pacotes

## Aula 01 - Kill, ps e grep

### Atividade 01 - Kill, ps e grep:

- `ps`: lista os comandos executados no bash (terminal) atual.
- `ps -e`: lista todos os processos do Linux.
- `kill 'ps_id'`: envia um sinal para encerrar o processo de ID `ps_id`. Quando não há parâmetros, o sinal padrão é o `TERM`, ou seja, tenta fechar o programa normalmente, sem forçar.
- `kill -9 'ps_id`: mata o processo de ID `ps_id`. O parâmetro `-9` significa `KILL`, ou seja, encerra o programa à força.
- `ps -ef`: lista todos os processos do Linux e diversas informações dos processos.
- `ps -ef | grep firefox`: o `|` significa "redirecione a saída para outro programa, e o `grep` é um programa que filtra linhas de texto.

## Aula 02 - Killall, top

### Atividade 01 - Killall e top:

- `top`: mostra a situação dos processos, processador, memória e muitas outras informações na mesma tela.
- `killall 'ps_name'`: envia um sinal para encerrar todos os processos do mesmo programa pelo nome `ps_name`. Assim como o `kill`, também aceita diversos sinais, como o `-9`.

### Atividade 04 - Para saber mais: outras opções do top:

- `top -u 'user_name'`: mostra os processos em execução pelo usuário `user_name`.
- `top -p 'ps_id'`: mostra as informações de um processo específico de ID `ps_id`.
- Por padrão, o `top` atualiza a tela com novas informações sobre os processos a cada 3 segundos. Para alterar esse tempo basta pressionar `d` enquanto estiver rodando o `top`, inserir o valor desejado e pressionar a tecla `Enter`.

## Aula 03 - Jobs, bg, fg, pstree, &

### Atividade 01 - Jobs, bg, fg, pstree, &:

- `gedit`: abre o programa `gedit` em seu `bash`, no `foreground`.
- Ao executar um processo no `bash` (terminal), o processo será executado "dentro" do terminal, como um processo filho.
- `pstree`: mostra os processos em execução em formato de árvore.
- No terminal que está rodando um processo, o atalho `Ctrl + z` pausa a execução do processo.
- `jobs`: mostra os `jobs`.
- `bg 1`: joga o `job 1` para `background`. Se executar `bg` sem parâmetros, joga o primeiro `job` da pilha (o último inserido).
- `fg 1`: retorna o `job 1` para `foreground`, ou seja, no `bash`. Se executar `fg` sem parâmetros, pega o primeiro `job` da pilha (o último inserido).
- Na tela dos `jobs`, se há um `&` após o nome do `job` quer dizer que ele está sendo executado em `background`.
- `gedit &`: abre o programa `gedit` em seu `bash` no `background`.

## Aula 04 - Scripts e permissões de execução: sh e chmod

### Atividade 01 - sh e chmod:

- `gedit dorme &`: abre o arquivo `dorme` no `gedit` em `background`.
- O conteúdo do arquivo `dorme` será:
```
echo "Vou dormir"
sleep 5
echo "Terminei de dormir"
```
- `sh dorme`: executa o script `dorme` pelo `bash`.

#### Permissões:

- Os arquivos no Linux podem ter permissões de leitura (`r`), escrita (`w`) e execução (`x`).
- Existe um caracter que marca os diretórios (`d`).
- Todo arquivo no Linux tem um dono.
- As permissões podem estar atribuídas à um dono, um grupo ou outros usuários (que não sejam o dono ou pertencente ao grupo).
- O dono, o grupo e outros usuários possuem permissões separadas para cada arquivo.
- `chmod +x 'file'`: adiciona a permissão de execução para qualquer usuário ao arquivo `file`.
- **Ex.:**
```
$ ls -l dorme
-rw-rw-r-- 1 guilherme guilherme 52 Jun 12 10:48 dorme
$ chmod +x dorme
$ ls -l dorme
-rwxrwxr-x 1 guilherme guilherme 52 Jun 12 10:48 dorme
```
- Para executar um script, é necessário chamá-lo com o programa `sh` ou especificar onde ele está.
- **Ex.:** `./dorme`
- Também é possível remover uma permissão, com o operador `-`.
- **Ex.:** `chmod -x dorme`

## Aula 05 - Procurando arquivos: locate e updatedb

### Atividade 01 - locate e updatedb:

- `locate firefox`: procura, em todo o HD, o programa `firefox`. O `locate` é rápido pois ele busca no banco de dados interno no Linux.
- `updatedb`: atualiza o banco de dados interno do Linux. Essa atualização ocorre periodicamente, de forma automática.
- `sudo`: significa "execute como superusuário". Utiliza o usuário `root` para executar o programa.

## Aula 06 - Trocando de usuários: sudo e su

### Atividade 01 - Trocando de usuários:

- `which firefox`: retorna o local onde o programa `firefox` está instalado, à partir do diretório onde o comando foi executado.
- `passwd`: altera a senha do usuário atual.
- `sudo passwd`: altera a senha do usuário `root`.
- `su root` (ou somente `su`): loga com o usuário `root`.
- `exit`: desloga com o usuário atual.

## Aula 07 - Novos usuários e controle de acesso: adduser e chmod

### Atividade 01 - Controle de usuários:

- `sudo adduser jose`: adiciona o usuário `jose` ao sistema. Após rodar o comando, é requisitado uma senha e alguns dados. É necessário o superusuário (`sudo`) para adicionar um novo usuário.
- `chmod u-rx 'ps_name'`: remove a permissão de usuário para leitura e execução do programa `ps_name`.
- `chmod g-rx 'ps_name'`: remove a permissão de grupo para leitura e execução do programa `ps_name`.
- `chmod o-rx 'ps_name'`: remove a permissão de outros para leitura e execução do programa `ps_name`.

## Aula 08 - Variáveis de Ambiente e o Path

### Atividade 01 - Variáveis de ambiente e PATH:

- `PATH`: local onde o `bash` procura os programas para executá-los.
- `env`: mostra todas as variáveis de ambiente. `PATH` é uma variável de ambiente.
- `PATH=$PATH:/home/guilherme/workspace`: adiciona o diretório `/home/guilherme/workspace` ao `PATH`. Agora, o `bash` procura os programas dentro desse diretório para executá-los.
- Porém, ao abrir outro `bash`, o `PATH` não persiste, ou seja, volta ao valor anterior.
- `.bashrc`: arquivo carregado quando um `bash` é aberto. Adicione a linha `PATH=$PATH:/home/guilherme/workspace` nesse arquivo para que o seu `PATH` modificado seja carregado toda vez que abrir um `bash`.

### Atividade 03 - Adicionando um diretório nas variáveis de ambiente:

- `wc`: conta o número de palavras. O parâmetro `-w` indica que desejamos contar apenas o número de palavras que existem no arquivo.
- **Ex.:**
```
$ wc -w *.txt
6 projetos_java.txt
10 projetos_php.txt
16 total
```
- **Ex.2:** `wc -w *.txt | grep total`

### Atividade 04 - Obtendo o número de processos:

- `wc -c`: conta o número de caracteres.
- `wc -l`: conta o número de linhas.
- `ps -e | wc -l`: conta a quantidade de processos existentes no sistema.

### Atividade 05 - Alterando a configuração do prompt:

- A variável de ambiente `$PS1` determina as informações mostradas no terminal (normalmente essa variável mostra `'usuario'@'grupo':'pwd'$`).
- `PS1="alura:"`: altera o valor da informação mostrada no terminal para `alura:`.
