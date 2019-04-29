using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class ControlaInterface : MonoBehaviour
{
    public Slider SliderVidaJogador;
    public GameObject TextoGameOver;

    private ControlaJogador scriptControlaJogador;

    // Start is called before the first frame update
    void Start()
    {
        scriptControlaJogador = GameObject.FindWithTag(Tags.Jogador).GetComponent<ControlaJogador>();
        AtualizarSliderVidaJogador();
    }

    public void AtualizarSliderVidaJogador()
    {
        SliderVidaJogador.value = scriptControlaJogador.statusJogador.Vida;
    }

    public void GameOver()
    {
        Time.timeScale = 0;
        TextoGameOver.SetActive(true);
    }
}
