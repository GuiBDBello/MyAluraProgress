using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class KitMedico : MonoBehaviour
{
    private int quantidadeDeCura = 15;

    private void OnTriggerEnter(Collider objetoDeColisao)
    {
        if (objetoDeColisao.tag == "Jogador")
        {
            //quantidadeDeCura = Random.Range(15, 25);
            objetoDeColisao.GetComponent<ControlaJogador>().CurarVida(quantidadeDeCura);
            Destroy(gameObject);
        }
    }
}