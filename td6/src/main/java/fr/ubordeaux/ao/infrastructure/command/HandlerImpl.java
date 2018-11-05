package fr.ubordeaux.ao.infrastructure.command;

import fr.ubordeaux.ao.application.command.Handler;
import fr.ubordeaux.ao.application.command.Gateway;

public class HandlerImpl implements Handler{
    private Gateway gate;

    public HandlerImpl(Gateway gat){
        this.gate = gat;
    }

    public void run(){
        while(true){
            // TODO CODE
            // Ajout d'un event pour signaler que l'evenement est fait
        }
    }
}