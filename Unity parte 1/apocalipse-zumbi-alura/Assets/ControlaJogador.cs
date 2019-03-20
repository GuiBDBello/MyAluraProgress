using UnityEngine;

public class ControlaJogador : MonoBehaviour
{
    public float Velocidade = 10;

    // Update is called once per frame
    void Update()
    {
        float eixoX = Input.GetAxis("Horizontal");
        float eixoZ = Input.GetAxis("Vertical");

        Vector3 direcao = new Vector3(eixoX, 0, eixoZ);

        // Verifica a variável "direcao" para alterar a Animação;
        if (direcao != Vector3.zero)
        {
            GetComponent<Animator>().SetBool("Movendo", true);
        }
        else
        {
            GetComponent<Animator>().SetBool("Movendo", false);
        }
        transform.Translate(direcao * Velocidade * Time.deltaTime);
    }
}