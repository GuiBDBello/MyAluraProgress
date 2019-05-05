# Unity parte 3: Criando um chefão e refinando o jogo

## Aula 01 - Kit Médico

### Atividade 06 - Zumbi gerar Kit Médico:

- `Random.value`: retorna um número decimal entre 0 e 1;
- `if (Random.value <= porcentagem) { }`: verifica se o valor aleatório é válido, em que 'porcentagem' deve ser um número decimal de ponto flutuante entre 0 e 1;
- `Destroy(objeto, tempo);`: método que destrói um Objeto 'objeto' após passar 'tempo' segundos;

#### Unity IDE:

- Na Unity, é possível 'travar' uma janela, para que ela não seja alterada ao selecionar outros Objetos, clicando no ícone de "Cadeado" no topo dessa janela;


## Aula 02 - Interface

### Atividade 01 - Quantidade de Zumbis Mortos:

- `GameObject.FindObjectOfType(typeof(Script)) as Script;`: retorna um 'Script' do tipo 'GameObject', e converte esse Objeto em 'Script';

### Atividade 04 - Texto e Cursos do Mouse:

- 'File > Build Settings... > Player Settings... > Default Cursor': define uma textura/sprite para substituir o cursor do mouse;
- 'File > Build Settings... > Player Settings... > Cursor hotspot': define um 'offset' que altera a posição do "clique" do cursor;


## Aula 03 - Polimento no Gerador

### Atividade 04 - Balanceando Quantidade de Zumbis:

#### Vincular novo Objeto:

- `Script script = Instantiate(objeto, posicao, rotacao).GetComponent<Script>();`: obtém a referência do Script de nome 'Script' utilizado no Objeto instanciado;
- `script.objetoScript = this;`: atribui à propriedade 'objetoScript' o Script em que esse código é executado. Nesse caso, o `this` retorna um Objeto do tipo Script;
- `if(Time.timeSinceLevelLoad > tempoProximoEvento) { tempoProximoEvento = Time.timeSinceLevelLoad + tempoDeCadaEvento; }`: realiza uma verificação para rodar um evento a cada 'tempoProximoEvento' segundos, onde 'tempoDeCadaEvento' é o tempo de espera entre os eventos;


## Aula 04 - Polimento no Zumbi

### Atividade 03 - Animação de Morrer:

#### Animator:

- Recorte a animação de morte;
- Adicione-a ao Animator;
- Crie uma transição de 'Any State' à animação de morte;
- Crie um parâmetro do tipo 'Trigger' nessa transição;
- Selecione a animação recortada e altere 'Root Transform Position (Y)' para 'Center of Mass';

#### Remover inimigo morto:

Para remover o inimigo do cenário, deve-se seguir os seguintes passos:
- Desabilitar colisão do inimigo, para removê-lo atravessando o chão;
- Remover seu "Freeze Position" no eixo Y;
- Zerar a velocidade de seu Rigidbody;
- (Opcional) Destruir o Objeto após alguns segundos, para liberar memória;

#### Script (AnimacaoPersonagem):

- `public void Morrer() { Animator.SetTrigger("Parametro"); }`: dispara a animação de morte;

#### Script (MovimentoPersonagem):

Dentro do método `Morrer()`:
- `Rigidbody.constraints = RigidbodyConstraints.None;`: remove todos 'Freeze Positions';
- `Rigidbody.velocity = Vector3.zero;`: remove a velocidade do Objeto, para apenas a gravidade puxar ele para baixo;
- `GetComponent<Collider>().enabled = false;`: desabilita a Colisão do Objeto, para ele atravessar o chão;

#### Script (ControlaInimigo):

- `Destroy(gameObject, 2)`: destrói o Objeto após 2 segundos;
- `AnimacaoPersonagem.Morrer();`: executa a animação;
- `MovimentoPersonagem.Morrer();`: executa a remoção do inimigo do cenário;
- `this.enabled = false;`: desabilita o Script 'ControlaInimigo' após a morte;

## Aula 05 - Chefe de Fase

### Atividade 03 - Nav Mesh Agent:

- Selecione os Objetos do cenário e, no 'Inspector', clique em 'Static' e selecione 'Navigation Static';

#### Navigation:

- 'Window > AI > Navigation': abre a janela 'Navigation' da Unity;

##### Bake:

- Selecione 'Bake' para criar a 'Nav Mesh';
- Altere as propriedades 'Agent Radius' e 'Agent Height' para as mesmas do Colisor do Objeto que utilizará a 'Nav Mesh';

##### Agents:

- Altere as propriedades 'Name', 'Radius' e 'Height' para as mesmas do Colisor do Objeto que utilizará a 'Nav Mesh';

#### No Objeto (GameObject):

- Adicionar novo Componente 'Nav Mesh Agent';
- Em 'Obstacle Avoidance', alterar as propriedades 'Radius' e 'Height' para as mesmas do Colisor do Objeto;

#### Script:

- `private Transform objeto;`: posição 'objeto' que o Objeto que contém esse Script irá seguir;
- `private NavMeshAgent navMeshAgent;`: componente 'Nav Mesh Agent' que contém a 'Nav Mesh' criada. Obs.: deve importar `using UnityEngine.AI;`;
- `navMeshAgent.SetDestination(objeto.position);`: define um destino ('objeto.position') para o Objeto seguir;

## Aula 06 - Ataque do Chefe

### Atividade 01 - Animações no Chefe:

- `NavMeshAgent.remainingDistance <= NavMeshAgent.stoppingDistance;`: retorna um bool que verifica se o Objeto está perto do "ObjetoPerseguido";
- É preciso definir a 'stoppingDistance' no Componente 'Nav Mesh Agent' do Objeto;
- `NavMeshAgent.hasPath;`: retorna um bool que informa se o Objeto possui um destino;
- Marcar 'Is Kinematic' no Rigidbody do Objeto, para retirar o controle de movimentação e rotação do Rigidbody, permitindo que o 'Nav Mesh Agent' faça esse controle;

### Atividade 04 - Ataques no Chefe:

- `NavMeshAgent.enabled = false;`: desabilita o 'Nav Mesh Agent' ao matar o Chefe;
- `Rigidbody.isKinematic = false;`: desabilita o 'Is Kinematic' do Rigidbody para o Chefe sofrer o efeito da gravidade e desaparecer pelo chão do cenário;
