
hier der Coding Task (Backend+Frontend).
Bitte schicke das Ergebnis nach maximal 4 Stunden via Github.

Backend:
Bitte implementiere einen Service auf Basis folgender Technologien:
- Docker
- Java
- Spring Boot
  Der Service soll Währungskurse von folgender Webseite im CSV-Format herunterladen und solange im Speicher halten, wie kein Datumswechsel vorliegt:
  https://www.ecb.europa.eu/stats/eurofxref/eurofxref.zip

Es sollen zwei REST-Endpunkte zur Verfügung stehen:
- GET /currencies/ liefert alle Wechselkurse
- GET /currencies/SYMBOL liefert den Wechselkurs zur angegebenen Währung
  Die Parameter sollen validiert werden.
  Bitte liefere auch eine exportierte Postman-Konfiguration.


Frontend:
Bitte implementiere einen Web-Frontend zum Currencies-Server, um die Funktionalität eines Währungsumrechners zu erhalten.
Technologie: AngularJS, ReactJS, Elm oder Vanilla JavaScript
Das Frontend muss eine Seite mit einem Währungsumrechner anzeigen.
Der Währungsumrechner sollte folgende Features haben:
- mit Hilfe von 2 Dropdowns soll man die umzurechnenden Währungen auswählen können
- mit Hilfe von 2 Eingabefeldern soll man die Beträge der jeweils ausgewählten Währung eingeben können
- während der Eingabe in eines der Felder soll das jeweils andere Feld den umgerechneten Betrag anzeigen
- wenn das andere Feld bereits eine Eingabe enthält, soll sie überschrieben werden
- die berechneten Werte sollen auf 2 Nachkommastellen gerundet werden
- die Kurse, sowie die Währungen sollen vom Currencies-Server abgeholt werden

Optional (nur wenn Du Zeit übrig hast):
- die Seite sollte ihren Zustand in der URL abbilden, damit man sie mit Freunden teilen kann
- die Seite sollte responsive sein
- produktionsreifes Asset-Bundling 
