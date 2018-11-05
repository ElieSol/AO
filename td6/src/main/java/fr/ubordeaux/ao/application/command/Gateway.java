package fr.ubordeaux.ao.application.command;

import java.util.List;

public interface Gateway{
    public void add(Command c);
    public void storeAndExecute(Command command);
}