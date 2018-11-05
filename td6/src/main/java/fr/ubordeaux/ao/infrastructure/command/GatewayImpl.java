package fr.ubordeaux.ao.infrastructure.command;

import fr.ubordeaux.ao.application.command.Command;
import fr.ubordeaux.ao.application.command.Gateway;
import java.util.List;
import java.util.ArrayList;

public class GatewayImpl implements Gateway{
    List<Command> CommandList;

    public GatewayImpl(){
        CommandList = new ArrayList<Command>();
    }
    
    public void add(Command c){
        CommandList.add(c);
    }

    public void storeAndExecute(Command command){
        CommandList.add(command);
        command.execute();
    }
}