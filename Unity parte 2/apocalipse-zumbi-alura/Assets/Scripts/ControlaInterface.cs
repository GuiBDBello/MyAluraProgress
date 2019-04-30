using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using UnityEngine.SceneManagement;

public class ControlaInterface : MonoBehaviour
{
    public Slider SliderVidaJogador;
    public GameObject TextoGameOver;
    public GameObject PainelDeGameOver;

    private ControlaJogador scriptControlaJogador;

    // Start is called before the first frame update
    void Start()
    {
        scriptControlaJogador = GameObject.FindWithTag(Tags.Jogador).GetComponent<ControlaJogador>();
        AtualizarSliderVidaJogador();
        Time.timeScale = 1;
    }

    public void AtualizarSliderVidaJogador()
    {
        SliderVidaJogador.value = scriptControlaJogador.statusJogador.Vida;
    }

    public void GameOver()
    {
        PainelDeGameOver.SetActive(true);
        Time.timeScale = 0;
    }

    public void Reiniciar()
    {
        SceneManager.LoadScene("game");
    }
}
