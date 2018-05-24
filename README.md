# CORPORATE WELLNESS
***
Planiranje in izvajanje promocije zdravja na delovnem mestu.


## Bistvo

V vedno več podjetjih se zavedajo pomena zdravega in zadovoljnega osebja. Zato organizirajo razne dogodke, tekmovanja, promocije zdravja – in sicer na področju fizičnega in duševnega zdravja, zdrave prehrane, medicinskih nasvetov.



## Ekipa
* [Manica Abramenko](https://github.com/ManicaA)
* [Gregor Gorjanc](https://github.com/gregorjanc)
* [Haidi Zakelšek](https://github.com/Haidi11)

## ER
![](https://raw.githubusercontent.com/Haidi11/Wellness/master/ostalo/er.png)

## Namestitev
* Eclipse Java EE IDE for Web Developers.
(Version: Oxygen.3a Release )
* WildFly-11.0.0.Final
* MySql 

v Wildfly je potrebno ustavriti datasource java:jboss/datasources/baza in v MySql kreirati bazo "Wellness". V administrativni konzoli WildFly strežnika ustvarimo Non XA datasource, katermu nastavimo JNDI: java:jboss/datasources/baza in Connection URL: jdbc:mysql://localhost:3306/wellness. 
Uporabniki se dodajo s pomočjo CMD.

