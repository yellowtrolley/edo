// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package it.verding.edo.model;

import it.verding.edo.model.Comune;
import it.verding.edo.model.ComuneDataOnDemand;
import it.verding.edo.model.ZonaClimatica;
import it.verding.edo.repositories.ComuneRepository;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

privileged aspect ComuneDataOnDemand_Roo_DataOnDemand {
    
    declare @type: ComuneDataOnDemand: @Component;
    
    private Random ComuneDataOnDemand.rnd = new SecureRandom();
    
    private List<Comune> ComuneDataOnDemand.data;
    
    @Autowired
    ComuneRepository ComuneDataOnDemand.comuneRepository;
    
    public Comune ComuneDataOnDemand.getNewTransientComune(int index) {
        Comune obj = new Comune();
        setAltSLM(obj, index);
        setGradiGiorno(obj, index);
        setNome(obj, index);
        setZonaClimatica(obj, index);
        return obj;
    }
    
    public void ComuneDataOnDemand.setAltSLM(Comune obj, int index) {
        Integer altSLM = new Integer(index);
        obj.setAltSLM(altSLM);
    }
    
    public void ComuneDataOnDemand.setGradiGiorno(Comune obj, int index) {
        Integer gradiGiorno = new Integer(index);
        obj.setGradiGiorno(gradiGiorno);
    }
    
    public void ComuneDataOnDemand.setNome(Comune obj, int index) {
        String nome = "nome_" + index;
        obj.setNome(nome);
    }
    
    public void ComuneDataOnDemand.setZonaClimatica(Comune obj, int index) {
        ZonaClimatica zonaClimatica = null;
        obj.setZonaClimatica(zonaClimatica);
    }
    
    public Comune ComuneDataOnDemand.getSpecificComune(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        Comune obj = data.get(index);
        ObjectId id = obj.getId();
        return comuneRepository.findOne(id);
    }
    
    public Comune ComuneDataOnDemand.getRandomComune() {
        init();
        Comune obj = data.get(rnd.nextInt(data.size()));
        ObjectId id = obj.getId();
        return comuneRepository.findOne(id);
    }
    
    public boolean ComuneDataOnDemand.modifyComune(Comune obj) {
        return false;
    }
    
    public void ComuneDataOnDemand.init() {
        int from = 0;
        int to = 10;
        data = comuneRepository.findAll(new org.springframework.data.domain.PageRequest(from / to, to)).getContent();
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'Comune' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<Comune>();
        for (int i = 0; i < 10; i++) {
            Comune obj = getNewTransientComune(i);
            try {
                comuneRepository.save(obj);
            } catch (final ConstraintViolationException e) {
                final StringBuilder msg = new StringBuilder();
                for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                    final ConstraintViolation<?> cv = iter.next();
                    msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
                }
                throw new IllegalStateException(msg.toString(), e);
            }
            data.add(obj);
        }
    }
    
}
