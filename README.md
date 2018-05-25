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

**Login:**
* Zaženi server.
* Lociraj datoteko jboss-cli.bat, ki se nahaja v wildfly-11.0.0.Final\bin.
* Zaženi jboss-cli.bat (ne škodi, če se zažene z administrativnimi pravicami)
* poženi naslednje:

`/subsystem=elytron/jdbc-realm=KEKS:add(principal-query=[{data-source=baza, sql="SELECT vloga, geslo FROM Oseba WHERE uporabniskoIme = ?", attribute-mapping=[{index=1, to=groups}] clear-password-mapper={password-index=2}}])`

`/subsystem=elytron/security-domain=KEKS-domain:add(realms=[{realm=KEKS,role-decoder=groups-to-roles}],default-realm=KEKS,permission-mapper=default-permission-mapper)`

`/subsystem=elytron/http-authentication-factory=KEKS-auth:add(http-server-mechanism-factory=global,security-domain=KEKS-domain,mechanism-configurations=[{mechanism-name=FORM,mechanism-realm-configurations=[{realm-name=KEKS}]}])`

`/subsystem=undertow/application-security-domain=KEKSApplicationDomain:add(http-authentication-factory=KEKS-auth)`

`/subsystem=ejb3/application-security-domain=KEKSApplicationDomain:add(security-domain=KEKS-domain)`

* Ustvari uporabnike v bazi za dostop do strani, potrebno je nastaviti vsaj geslo in uporabnisko ime. Nastavi željene vloge (brez/"kadrovska"/"zaposleni")


## GSON
Open Windows >preferences in the Eclipse menu, and navigate to the Java >Build path > User Libraries tab. Click new and enter a new User Library name: like “gson_lib” and hit ok. With “gson_lib” selected press Add External JARs and find the gson-2.6.2.jar you downloaded. Apply and Close. Nato pa Wellness -> properties -> Java Build Path -> add Library -> User library
-> gson_lib -> apply and close.
