@txn
Feature: See Messages

  Scenario: See another user's messages
    Given il questionario e compilato, combustibile: "GPL", m2: 150, litri/anno: 2300, sistema termoregolazione: true, piu di 10 anni: false
    And il questionario e inivato 
    When il questionario e visualizzato
    Then dovrei ottenere 4 soluzioni
