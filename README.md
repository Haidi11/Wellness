# CORPORATE WELLNESS
***
Planiranje in izvajanje promocije zdravja na delovnem mestu.


## Bistvo

V vedno več podjetjih se zavedajo pomena zdravega in zadovoljnega osebja. Zato organizirajo razne dogodke, tekmovanja, promocije zdravja – in sicer na področju fizičnega in duševnega zdravja, zdrave prehrane, medicinskih nasvetov.
Bistvo vašega projekta bo v organizacijskem aspektu dogodkov za zdravo življenje –
razpisovanje in promocija dogodkov, potrjevanje udeležbe, zbiranje povratnih podatkov
udeležencev ipd. Prav tako boste zaposlene motivirali pri udeležbi na dogodkih preko
konceptov igrifikacije (zbiranje točk, nagrajevanje za najbolj aktivne, ugodnosti na podlagi
točk, objava nagrad »Zdravko« in »Srečko« meseca ipd.
Prav tako omogočite objavljanje nasvetov za izboljšanje zdravja na delovnem mestu –
odvisno od tipa podjetja, kamor vpeljujete rešitev

## Predvideni uporabniki

* Kadrovska služba (dodajanje uporabnika, dodajanje dogodkov + funkcionlnosti zaposlenega) 
* zaposleni (pregled dogodkov, pisanje nasvetov, pregled statistike, prijava na dogodke) 
* organizatorji dogodkov (dodajanje dogodkov + funkcionlnosti zaposlenega)

## Glavne funkcionalnosti
* Razpis dogodka
* Prijava na dogodek
* Objava nasveta
* Pregled prijav na dogodke
* Pregled statistik med in znotraj dogodka
* Razpis tekmovanj in nagrad
* Vnos uporabnikov in organizacijske strukture podjetja
* Prejem opomnika na dogodek

## ER
![](https://raw.githubusercontent.com/Haidi11/Wellness/master/ostalo/er.png)
***
## Namestitev
* Eclipse Java EE IDE for Web Developers.
(Version: Oxygen.3a Release )
* WildFly-11.0.0.Final
* MySql 

v Wildfly je potrebno ustavriti datasource java:jboss/datasources/baza in v MySql kreirati bazo "baza". V administrativni konzoli WildFly strežnika ustvarimo Non XA datasource, katermu nastavimo JNDI: java:jboss/datasources/baza in Connection URL: jdbc:mysql://localhost:3306/baza. 

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

`INSERT INTO oseba (EMSO, datumRojstva, datumZaposlitve, davcnaStevilka, email, geslo, ime, kadrovskaSluzba, oddelek, organizatorDogodkov, priimek, spol, telefonskaStevilka, tocke, uporabniskoIme, vloga) VALUES ('937459', '1996-02-02 01:00:00', '2018-05-30 02:00:00', '4f4fg', 'm.@g.c', 'geslo', 'Testni', 0, 'oddelek1', 0, 'Uporabnik', 'M', '0904304646', 0, 'geslo', 'kadrovska');
`

* uporabniško ime: geslo
* geslo: geslo


**Mail:**
* zaženi server
* Pojdi na konfiguracije strežnika 
* v Subsystem izberite Mail in add
* vnesite: name: gmail JNDI: java:/jboss/mail/gmail
* nato mu dodate novi tip ( opcij view in add)
* Socket-binding: mail-smtp - Type: smtp - Username: wellness.keks@gmail.com - Password: Lukapavlic - SSL: enable
* restartraj server
* v standalalone.xml je potrebno nastaviti port na 465 (na koncu datoteke) 

`<outbound-socket-binding name="mail-smtp">
            <remote-destination host="localhost" port="465"/>
        </outbound-socket-binding> `
* mail za testiranje: sduper587@gmail.com, geslo:Q75FvKN6Uz7y
* link za dajanje dovoljenja manj varnim aplikacijam: https://myaccount.google.com/lesssecureapps

standalone.xml:
  <outbound-socket-binding name="mail-smtp-gmail">
            <remote-destination host="smtp.gmail.com" port="465"/>
  </outbound-socket-binding>
  
   <subsystem xmlns="urn:jboss:domain:mail:3.0">
            <mail-session name="Gmail" debug="false" jndi-name="java:/jboss/mail/gmail">
                <smtp-server outbound-socket-binding-ref="mail-smtp-gmail" ssl="true" tls="false" username="wellness.keks@gmail.com" password="Lukapavlic"/>
            </mail-session>
   </subsystem>
        

**Maps**
API: AIzaSyD4JVT8B0kQ4tYLF7GvSvZBMCYlIXuYNA4

## GSON
Open Windows >preferences in the Eclipse menu, and navigate to the Java >Build path > User Libraries tab. Click new and enter a new User Library name: like “gson_lib” and hit ok. With “gson_lib” selected press Add External JARs and find the gson-2.6.2.jar you downloaded. Apply and Close. Nato pa Wellness -> properties -> Java Build Path -> add Library -> User library
-> gson_lib -> apply and close.
***
## Ekipa
* [Manica Abramenko](https://github.com/ManicaA)
* [Gregor Gorjanc](https://github.com/gregorjanc)
* [Haidi Zakelšek](https://github.com/Haidi11)


