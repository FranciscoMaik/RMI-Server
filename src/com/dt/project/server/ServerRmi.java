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
    
    public ServerRmi() throws RemoteException{
        System.out.println("Novo Servidor Intanciado!");
    }
    
    @Override
    public double soma(double a, double b) throws RemoteException {
        return a+b;
    }
    
}
