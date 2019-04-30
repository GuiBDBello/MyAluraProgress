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
    public Text TextoTempoDeSobrevivencia;
    public Text TextoPontuacaoMaxima;

    private float tempoPontuacaoSalvo;

    private ControlaJogador scriptControlaJogador;

    // Start is called before the first frame update
    void Start()
    {
        scriptControlaJogador = GameObject.FindWithTag(Tags.Jogador).GetComponent<ControlaJogador>();
        AtualizarSliderVidaJogador();
        Time.timeScale = 1;

        tempoPontuacaoSalvo = PlayerPrefs.GetFloat("PontuacaoMaxima");
    }

    public void Reiniciar()
    {
        SceneManager.LoadScene("game");
    }

    public void AtualizarSliderVidaJogador()
    {
        SliderVidaJogador.value = scriptControlaJogador.statusJogador.Vida;
    }

    public void GameOver()
    {
        PainelDeGameOver.SetActive(true);
        Time.timeScale = 0;

        int minutos = (int) (Time.timeSinceLevelLoad / 60);
        int segundos = (int) (Time.timeSinceLevelLoad % 60);
        TextoTempoDeSobrevivencia.text = "Você sobreviveu por " + minutos + " minutos e " + segundos + " segundos.";

        AjustarPontuacaoMaxima(minutos, segundos);
    }

    void AjustarPontuacaoMaxima(int minutos, int segundos)
    {
        if (Time.timeSinceLevelLoad > tempoPontuacaoSalvo)
        {
            tempoPontuacaoSalvo = Time.timeSinceLevelLoad;
            TextoPontuacaoMaxima.text = string.Format("Seu melhor tempo é {0} minutos e {1} segundos.", minutos, segundos);
            PlayerPrefs.SetFloat("PontuacaoMaxima", tempoPontuacaoSalvo);
        }
        if (TextoPontuacaoMaxima.text == "")
        {
            minutos = (int) (tempoPontuacaoSalvo / 60);
            segundos = (int) (tempoPontuacaoSalvo % 60);
            TextoPontuacaoMaxima.text = string.Format("Seu melhor tempo é {0} minutos e {1} segundos.", minutos, segundos);
        }
    }
}