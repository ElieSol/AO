package fr.ubordeaux.ao.infrastructure.inmemory;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import fr.ubordeaux.ao.domain.exception.ReferenceManagementException;
import fr.ubordeaux.ao.domain.model.Catalog;
import fr.ubordeaux.ao.domain.type.*;
import fr.ubordeaux.ao.domain.model.Reference;

public class CatalogImpl implements Catalog {
    private CatalogName cat_name;
    private Map<CatalogName, Catalog> subCatalogs; 
    private Map<String, Reference> references;

    // Constructeur
    public CatalogImpl(CatalogName catalog_name) {
        this.cat_name = catalog_name;
        subCatalogs = new HashMap<>();
        Map<String, Reference> references = new HashMap<String, Reference>();
    }


    // Getter
    public String getName(){
        String name = cat_name.getCatalogName();
        return name;
    }

    public int size() {
        return references.size();
    }

    public Set<Reference> getReferences() {
        Set<Reference> result = new HashSet<Reference>();
        result.addAll(references.values());
        return result;
    }


    // Methodes relatives aux references
    public Reference findReferenceById(String id) {
        if (!references.containsKey(id)) throw new ReferenceManagementException("cannot find Reference, id unknown !");
        return references.get(id);
    }

    public void addReference(Reference reference) {
        references.put(reference.getId(), reference);
    }

    public void removeReference(Reference reference) {
        references.remove(reference.getId());
    }
    
    
    // Methodes relatives aux sous catalogues
	public Set<Catalog> getSubCatalogs() {
        Set<Catalog> result = new HashSet<Catalog>();
        Catalog subCatalogs;
        result.addAll(this.subCatalogs.values());
        return result;
    }

    
    public Catalog getSubCatalogByName(CatalogName catalogName) {
        if (this.getName().equals(catalogName)) return this;

        for (Catalog sub : subCatalogs.values()) {
            try {
                Catalog catalog = sub.getSubCatalogByName(catalogName);
                return catalog;
            } catch (ReferenceManagementException ex) {

            }
        }
        throw new ReferenceManagementException("can't find catalog with name "+catalogName.toString());
    }
    
    
    public Catalog createSubCatalog(CatalogName subName) {
        for (Catalog subCatalog : this.getSubCatalogs()) {
            if (subCatalog.getName().equals(subName)) throw new ReferenceManagementException("cannot add sub catalog with same name");
        }
        Catalog subCatalog = new CatalogImpl(subName);
        this.subCatalogs.put(subName, subCatalog);
        return subCatalog;
    }    

}