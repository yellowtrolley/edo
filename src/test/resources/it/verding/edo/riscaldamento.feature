# The @txn tag enables a Transaction open-rollback around each Scenario,
# Preventing persisted data from leaking between Scenarios.
@txn
Feature: Risultato formulario riscaldamento
 
	Scenario: Dopo compilare ed inviare il formulario, vengono calcolati le migliori soluzioni 
		Given Il formulario e compilato ed inviato
		When si fanno i calcoli per ottenere le migliori soluzioni
		Then costo acquisto + istallazione: 2140, nuovo consumo: 2029.412
