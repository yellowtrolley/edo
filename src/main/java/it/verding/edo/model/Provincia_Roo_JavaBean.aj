// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package it.verding.edo.model;

import it.verding.edo.model.Comune;
import it.verding.edo.model.Provincia;
import java.util.Set;

privileged aspect Provincia_Roo_JavaBean {
    
    public String Provincia.getNome() {
        return this.nome;
    }
    
    public void Provincia.setNome(String nome) {
        this.nome = nome;
    }
    
    public Set<Comune> Provincia.getComuni() {
        return this.comuni;
    }
    
    public void Provincia.setComuni(Set<Comune> comuni) {
        this.comuni = comuni;
    }
    
}