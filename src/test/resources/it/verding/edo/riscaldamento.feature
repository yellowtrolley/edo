Feature: Risultato formulario riscaldamento
 
	Scenario: Dopo compilare ed inviare il formulario, vengono calcolati le migliori soluzioni 
		Given Il formulario e compilato ed inviato con Utente: Cittadino, Comune: Roma, Combustibile: GPL, Terminali: Radiatori accaio, Consumo: 2300, m2: 150, Caldaia con piu' di 10 anni
		When si fanno i calcoli per ottenere le migliori soluzioni.
		Then costo acquisto + istallazione: 2140, nuovo consumo: 2029.412
