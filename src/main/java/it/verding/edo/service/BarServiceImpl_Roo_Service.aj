// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package it.verding.edo.service;

import it.verding.edo.model.Bar;
import it.verding.edo.repositories.BarRepository;
import it.verding.edo.service.BarServiceImpl;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

privileged aspect BarServiceImpl_Roo_Service {
    
    declare @type: BarServiceImpl: @Service;
    
    declare @type: BarServiceImpl: @Transactional;
    
    @Autowired
    BarRepository BarServiceImpl.barRepository;
    
    public long BarServiceImpl.countAllBars() {
        return barRepository.count();
    }
    
    public void BarServiceImpl.deleteBar(Bar bar) {
        barRepository.delete(bar);
    }
    
    public Bar BarServiceImpl.findBar(ObjectId id) {
        return barRepository.findOne(id);
    }
    
    public List<Bar> BarServiceImpl.findAllBars() {
        return barRepository.findAll();
    }
    
    public List<Bar> BarServiceImpl.findBarEntries(int firstResult, int maxResults) {
        return barRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }
    
    public void BarServiceImpl.saveBar(Bar bar) {
        barRepository.save(bar);
    }
    
    public Bar BarServiceImpl.updateBar(Bar bar) {
        return barRepository.save(bar);
    }
    
}
