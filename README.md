
This is dojo / practicing

## Task

here the coding task (backend+frontend).
Please send the result after a maximum of 4 hours via Github.

backend:
Please implement a service based on the following technologies:
- Dockers
- Java
- Jump boat
  The service should download currency rates from the following website in CSV format and keep them in memory as long as there is no date change:
  https://www.ecb.europa.eu/stats/eurofxref/eurofxref.zip

Two REST endpoints should be available:
- GET /currencies/ returns all exchange rates
- GET /currencies/SYMBOL returns the exchange rate for the specified currency
  The parameters should be validated.
  Please also provide an exported Postman configuration.


front end:
Please implement a web frontend to the currencies server to get the functionality of a currency converter.
Technology: AngularJS, ReactJS, Elm or vanilla JavaScript
The frontend must display a page with a currency converter.
The currency converter should have the following features:
- With the help of 2 dropdowns you should be able to select the currencies to be converted
- with the help of 2 input fields you should be able to enter the amounts of the selected currency
- while typing in one of the fields, the other field should display the converted amount
- if the other field already contains an entry, it should be overwritten
- the calculated values should be rounded to 2 decimal places
- the courses and currencies should be fetched from the currencies server

Optional (only if you have time):
- the page should reflect its state in the URL so that it can be shared with friends
- the site should be responsive
- production-ready asset bundling

## Solution

Model can be represented as String for both currency and rate value.
In more advanced/real case 
currency would be own type for better search and comparison, guarantee of no duplicate
rate value would be numeric e.g. BigDecimal for server side calculations.