/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dt.project.server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Arlaxad
 */
public class IniciaServer {
    public static void main(String[] args) {
        try {
            System.out.println("Iniciando o servidor!");
            Registry registry = LocateRegistry.createRegistry(1010);
            //HelloImpl obj = new HelloImpl();
            registry.bind("Lista", new ServerRmi());
            //Naming.rebind("ServidorMat_1", new ServerRmi());
        } catch (Exception e) {
            System.out.println("Ocorreu um erro na iniciação do servidor!\n"+e.toString());
        }
    }
}
