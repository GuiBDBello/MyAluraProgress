using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class GeradorChefe : MonoBehaviour
{
    public GameObject ChefePrefab;

    private float tempoParaProximaGeracao = 0;
    public float tempoEntreGeracoes = 30;

    private void Start()
    {
        tempoParaProximaGeracao = tempoEntreGeracoes;
    }

    private void Update()
    {
        if (Time.timeSinceLevelLoad > tempoParaProximaGeracao)
        {
            Instantiate(ChefePrefab, transform.position, Quaternion.identity);
            tempoParaProximaGeracao = Time.timeSinceLevelLoad + tempoEntreGeracoes;
        }
    }
}