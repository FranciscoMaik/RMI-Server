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

import Conection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ServerRmi extends UnicastRemoteObject implements InterfaceRMI {

    public ServerRmi() throws RemoteException {
        System.out.println("Novo Servidor Intanciado!");
    }

    @Override
    public String vetores(int[] vet) throws RemoteException {
        String ordenado = " ";
        int[] vetor = new int[vet.length];
        int[] vetor2 = new int[vet.length];

        for (int i = 0; i < vet.length; i++) {
            vetor[i] = vet[i];
        }
        vetor2 = quickSort(vetor, 0, vetor.length - 1);

        for (int i = 0; i < vetor2.length; i++) {
            ordenado += " " + vetor2[i];
        }

        cadastrar_vetor(ordenado);

        return ordenado;
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
            if (vetor[i] <= pivo) {
                i++;
            } else if (pivo < vetor[f]) {
                f--;
            } else {
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

    public void cadastrar_vetor(String Valor) {
        System.out.println(Valor);
        Connection con = new ConnectionFactory().getConnection();
        PreparedStatement stat = null;

        try {
            stat = con.prepareStatement("INSERT INTO listas(numeros)VALUES(?);");
            stat.setString(1, Valor);
            stat.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Deu erro " + e);
        } finally {
            ConnectionFactory.closeConnection(con, stat);
        }
    }

}
