package fr.ubordeaux.ao.application.command;

import fr.ubordeaux.ao.domain.model.Catalog;
import fr.ubordeaux.ao.domain.type.CatalogName;
import fr.ubordeaux.ao.domain.exception.*;

public class AddSubCatalog implements Command{
    private Catalog rootCatalog;
    private CatalogName name;
    private CatalogName parentName;

    /*
    public AddSubCatalog(CatalogName name, CatalogName parentName) {
        this.setCatalogName(name);
        this.setParentCatalogName(parentName);
    }
    */


    public AddSubCatalog(String id, Catalog rootCatalog, CatalogName name, CatalogName parentName) {
        //super(id);
        this.setRootCatalog(rootCatalog);
        this.setCatalogName(name);
        this.setParentCatalogName(parentName);
    }


    private void setRootCatalog(Catalog rootCatalog) {
        if (rootCatalog == null) throw new ReferenceManagementException("Product (AddReferenceToCatalog) cannot be null");
        this.rootCatalog = rootCatalog;
    }

    private void setCatalogName(CatalogName name) {
        if (name == null) throw new ReferenceManagementException("cannot create catalog with null as name");
        this.name = name;
    }

    private void setParentCatalogName(CatalogName parentName) {
        if (parentName == null) throw new ReferenceManagementException("cannot create catalog with null as name");
        this.parentName = name;
    }

    //@Override
    public void execute() {
        //execute_local(Catalog rootCatalog);
    }

    public void execute_local(Catalog rootCatalog) {
        //Catalog parentCatalog = rootCatalog.getSubCatalogByName(parentName);
        //parentCatalog.AddSubCatalog(name);
    }
}