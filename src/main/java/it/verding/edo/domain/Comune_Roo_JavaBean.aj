// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package it.verding.edo.domain;

import it.verding.edo.domain.Comune;
import it.verding.edo.domain.ZonaClimatica;

privileged aspect Comune_Roo_JavaBean {
    
    public String Comune.getNome() {
        return this.nome;
    }
    
    public void Comune.setNome(String nome) {
        this.nome = nome;
    }
    
    public Integer Comune.getAltSLM() {
        return this.altSLM;
    }
    
    public void Comune.setAltSLM(Integer altSLM) {
        this.altSLM = altSLM;
    }
    
    public Integer Comune.getGradiGiorno() {
        return this.gradiGiorno;
    }
    
    public void Comune.setGradiGiorno(Integer gradiGiorno) {
        this.gradiGiorno = gradiGiorno;
    }
    
    public ZonaClimatica Comune.getZonaClimatica() {
        return this.zonaClimatica;
    }
    
    public void Comune.setZonaClimatica(ZonaClimatica zonaClimatica) {
        this.zonaClimatica = zonaClimatica;
    }
    
}