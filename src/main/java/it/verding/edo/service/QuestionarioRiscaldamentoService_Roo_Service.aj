// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package it.verding.edo.service;

import it.verding.edo.domain.QuestionarioRiscaldamento;
import it.verding.edo.service.QuestionarioRiscaldamentoService;
import java.util.List;
import org.bson.types.ObjectId;

privileged aspect QuestionarioRiscaldamentoService_Roo_Service {
    
    public abstract long QuestionarioRiscaldamentoService.countAllQuestionarioRiscaldamentoes();    
    public abstract void QuestionarioRiscaldamentoService.deleteQuestionarioRiscaldamento(QuestionarioRiscaldamento questionarioRiscaldamento);    
    public abstract QuestionarioRiscaldamento QuestionarioRiscaldamentoService.findQuestionarioRiscaldamento(ObjectId id);    
    public abstract List<QuestionarioRiscaldamento> QuestionarioRiscaldamentoService.findAllQuestionarioRiscaldamentoes();    
    public abstract List<QuestionarioRiscaldamento> QuestionarioRiscaldamentoService.findQuestionarioRiscaldamentoEntries(int firstResult, int maxResults);    
    public abstract void QuestionarioRiscaldamentoService.saveQuestionarioRiscaldamento(QuestionarioRiscaldamento questionarioRiscaldamento);    
    public abstract QuestionarioRiscaldamento QuestionarioRiscaldamentoService.updateQuestionarioRiscaldamento(QuestionarioRiscaldamento questionarioRiscaldamento);    
}
