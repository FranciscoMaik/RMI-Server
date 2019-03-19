/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dt.project.server;

import com.dt.project.rmi.InterfaceRMI;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Arlaxad
 */
public class ServerRmi extends UnicastRemoteObject implements InterfaceRMI{
    int[] vetor = new int[10];
    int[] vetor2 = new int[10];
    int total=0;
    public ServerRmi() throws RemoteException{
        System.out.println("Novo Servidor Intanciado!");
    }

    @Override
    public int[] vetores(int[] vet) throws RemoteException {
        for(int i = 0; i < 10; i ++){
        vetor[i] = vet[i]; 
        total = total+vet[i];
    }
        vetor2 = quickSort(vetor,0,vetor.length-1);
        
        return vetor2;
    }
    
    private static int[] quickSort(int[] vetor, int inicio, int fim) {
             if (inicio < fim) {
                    int posicaoPivo = separar(vetor, inicio, fim);
                    quickSort(vetor, inicio, posicaoPivo - 1);
                    quickSort(vetor, posicaoPivo + 1, fim);
             }
             return vetor;
       }
  
       private static int separar(int[] vetor, int inicio, int fim) {
             int pivo = vetor[inicio];
             int i = inicio + 1, f = fim;
             while (i <= f) {
                    if (vetor[i] <= pivo)
                           i++;
                    else if (pivo < vetor[f])
                           f--;
                    else {
                           int troca = vetor[i];
                           vetor[i] = vetor[f];
                           vetor[f] = troca;
                           i++;
                           f--;
                    }
             }
             vetor[inicio] = vetor[f];
             vetor[f] = pivo;
             return f;
       }
    
}
