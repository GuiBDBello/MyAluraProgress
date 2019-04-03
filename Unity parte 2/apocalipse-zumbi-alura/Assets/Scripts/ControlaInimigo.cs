using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ControlaInimigo : MonoBehaviour {

    public GameObject Jogador;
    public float Velocidade = 5;
    
    private Animator animatorInimigo;
    private MovimentoPersonagem movimentaInimigo;
    private AnimacaoPersonagem animacaoInimigo;

	// Use this for initialization
	void Start () {
        Jogador = GameObject.FindWithTag("Jogador");
        movimentaInimigo = GetComponent<MovimentoPersonagem>();
        animacaoInimigo = GetComponent<AnimacaoPersonagem>();
        AleatorizarZumbi();
    }

    void FixedUpdate()
    {
        float distancia = Vector3.Distance(transform.position, Jogador.transform.position);

        Vector3 direcao = Jogador.transform.position - transform.position;

        movimentaInimigo.Rotacionar(direcao);

        if (distancia > 2.5)
        {
            movimentaInimigo.Movimentar(direcao, Velocidade);
            animacaoInimigo.Atacar(false);

        }
        else
        {
            animacaoInimigo.Atacar(true);
        }
    }

    void AtacaJogador ()
    {
        int dano = Random.Range(20, 30);
        Jogador.GetComponent<ControlaJogador>().TomarDano(30);
    }

    void AleatorizarZumbi ()
    {
        int geraTipoZumbi = Random.Range(1, 28);
        transform.GetChild(geraTipoZumbi).gameObject.SetActive(true);
    }
}
