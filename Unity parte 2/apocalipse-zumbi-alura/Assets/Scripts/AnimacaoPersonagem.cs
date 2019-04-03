using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class AnimacaoPersonagem : MonoBehaviour
{
    private Animator meuAnimator;

    private void Awake()
    {
        meuAnimator = GetComponent<Animator>();
    }

    public void Atacar(bool estado)
    {
        meuAnimator.SetBool("Atacando", estado);
    }
}
