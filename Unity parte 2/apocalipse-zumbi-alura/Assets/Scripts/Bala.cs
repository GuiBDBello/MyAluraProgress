using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Bala : MonoBehaviour {

    public float Velocidade = 20;
    public AudioClip SomDeMorte;

    private Rigidbody rigidbodyBala;
    private int danoDoTiro = 50;

    private void Start()
    {
        rigidbodyBala = GetComponent<Rigidbody>();
    }

    // Update is called once per frame
    void FixedUpdate () {
        rigidbodyBala.MovePosition
            (rigidbodyBala.position + 
            transform.forward * Velocidade * Time.deltaTime);
	}

    void OnTriggerEnter(Collider objetoDeColisao)
    {
        if(objetoDeColisao.tag == Tags.Inimigo)
        {
            objetoDeColisao.GetComponent<ControlaInimigo>().TomarDano(danoDoTiro);
        }

        Destroy(gameObject);
    }
}