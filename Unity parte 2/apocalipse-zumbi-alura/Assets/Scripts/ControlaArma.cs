﻿using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ControlaArma : MonoBehaviour {

    public GameObject Bala;
    public GameObject CanoDaArma;

	// Use this for initialization
	void Start () {
		
	}
	
	// Update is called once per frame
	void Update () {
		if(Input.GetButtonDown("Fire1"))
        {
            Instantiate(Bala, CanoDaArma.transform.position, CanoDaArma.transform.rotation);
        }
	}
}
