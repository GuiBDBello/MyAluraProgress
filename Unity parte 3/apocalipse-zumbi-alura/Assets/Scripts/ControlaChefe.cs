using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.AI;

public class ControlaChefe : MonoBehaviour
{
    private Transform jogador;
    private NavMeshAgent agente;

    private void Start()
    {
        jogador = GameObject.FindWithTag("Jogador").transform;
        agente = GetComponent<NavMeshAgent>();
    }

    private void Update()
    {
        agente.SetDestination(jogador.position);
    }
}