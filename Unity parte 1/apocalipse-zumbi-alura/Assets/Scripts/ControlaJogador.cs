using UnityEngine;

public class ControlaJogador : MonoBehaviour
{
    public float Velocidade = 10;
    public LayerMask MascaraChao;

    Vector3 direcao;

    // Update is called once per frame
    void Update()
    {
        float eixoX = Input.GetAxis("Horizontal");
        float eixoZ = Input.GetAxis("Vertical");

        direcao = new Vector3(eixoX, 0, eixoZ);

        //transform.Translate(direcao * Velocidade * Time.deltaTime);
        //GetComponent<Rigidbody>().MovePosition(direcao * Velocidade * Time.deltaTime);

        // Verifica a variável "direcao" para alterar a Animação;
        if (direcao != Vector3.zero)
        {
            GetComponent<Animator>().SetBool("Movendo", true);
        }
        else
        {
            GetComponent<Animator>().SetBool("Movendo", false);
        }
    }

    void FixedUpdate()
    {
        GetComponent<Rigidbody>().MovePosition(GetComponent<Rigidbody>().position + (direcao * Velocidade * Time.deltaTime));

        // Cria um Ray;
        Ray raio = Camera.main.ScreenPointToRay(Input.mousePosition);
        // Desenha o Ray na Cena;
        Debug.DrawRay(raio.origin, raio.direction * 100, Color.red);

        // Cria um RaycastHit (impacto do Ray);
        RaycastHit impacto;

        // Testa se o Raio toca o chão;
        if (Physics.Raycast(raio, out impacto, 100, MascaraChao))
        {
            // Posição que o Jogador irá mirar;
            Vector3 posicaoMiraJogador = impacto.point - transform.position;

            // Anula a rotação no eixo Y;
            posicaoMiraJogador.y = transform.position.y;

            // Nova rotação, a partir da posição que o Jogador deve mirar;
            Quaternion novaRotacao = Quaternion.LookRotation(posicaoMiraJogador);

            // Altera a rotação do Jogador;
            GetComponent<Rigidbody>().MoveRotation(novaRotacao);
        }
    }
}