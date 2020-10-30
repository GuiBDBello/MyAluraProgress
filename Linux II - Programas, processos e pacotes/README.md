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
