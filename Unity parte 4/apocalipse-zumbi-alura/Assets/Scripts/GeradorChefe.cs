using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class GeradorChefe : MonoBehaviour
{
    public float tempoEntreGeracoes = 60;
    public GameObject ChefePrefab;
    public Transform[] PosicoesPossiveisDeGeracao;

    private float tempoParaProximaGeracao = 0;
    private ControlaInterface scriptControlaInterface;
    private Transform jogador;

    private void Start()
    {
        tempoParaProximaGeracao = tempoEntreGeracoes;
        scriptControlaInterface = GameObject.FindObjectOfType(typeof(ControlaInterface)) as ControlaInterface;
        jogador = GameObject.FindWithTag("Jogador").transform;
    }

    private void Update()
    {
        if (Time.timeSinceLevelLoad > tempoParaProximaGeracao)
        {
            Vector3 posicaoDeCriacao = CalcularPosicaoMaisDistanteDoJogador();
            Instantiate(ChefePrefab, posicaoDeCriacao, Quaternion.identity);
            scriptControlaInterface.AparecerTextoChefeCriado();
            tempoParaProximaGeracao = Time.timeSinceLevelLoad + tempoEntreGeracoes;
        }
    }

    Vector3 CalcularPosicaoMaisDistanteDoJogador()
    {
        Vector3 posicaoDeMaiorDistancia = Vector3.zero;
        float maiorDistancia = 0;

        foreach(Transform posicao in PosicoesPossiveisDeGeracao)
        {
            float distanciaEntreOJogador = Vector3.Distance(posicao.position, jogador.position);
            if (distanciaEntreOJogador > maiorDistancia)
            {
                maiorDistancia = distanciaEntreOJogador;
                posicaoDeMaiorDistancia = posicao.position;
            }
        }

        return posicaoDeMaiorDistancia;
    }
}