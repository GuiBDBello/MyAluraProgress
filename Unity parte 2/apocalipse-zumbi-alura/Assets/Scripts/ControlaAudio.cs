using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ControlaAudio : MonoBehaviour
{

    public static AudioSource instancia;

    private AudioSource meuAudioSource;

    // Start is called before the first frame update
    void Start()
    {
        meuAudioSource = GetComponent<AudioSource>();
        instancia = meuAudioSource;
    }

    // Update is called once per frame
    void Update()
    {
        
    }
}
