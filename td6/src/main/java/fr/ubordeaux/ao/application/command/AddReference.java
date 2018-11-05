package fr.ubordeaux.ao.application.command;

import fr.ubordeaux.ao.domain.model.Catalog;
import fr.ubordeaux.ao.domain.model.Reference;
import fr.ubordeaux.ao.application.command.Command;

public class AddReference implements Command{
    private Catalog catalog;
    private Reference reference;
    // Constructeur
    public AddReference(Catalog cat, Reference ref){
        this.catalog = cat;
        this.reference = ref;
    }
    // Méthodes
    public void execute(){
        catalog.addReference(reference);
    }
}