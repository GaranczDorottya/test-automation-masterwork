## A masterwork projekem témája témája
A projektmunkám alapjaként egy WorldPress motorral futó blogot választottam.
A weboldalon lehetőség van regisztrálni, blogposztokat olvaasni és kommnteket írni. 

A webalkalmaás az alábbi linkre kattintva elérhető: [Greenfox test-automation-blog](http://test-automation-blog.greenfox.academy/)
***
## Manuális tesztestek
A manuális teszteseteim leírása megtekinthető az alábbi linkre kattintva\
[Manual test cases - Google Spreadsheets](https://docs.google.com/spreadsheets/d/1iuAAzr0N7xzElvqXV-cDUVTxn1tbk-pf_NY88QUWSG8/edit?usp=sharing)
***
## Információ az automata tesztekről
A csomagban található tesztek JAVA nyelven íródtak, IntelliJ IDEA fejlesztői környezetben, Gradle projekt struktúra és Selenium WebDriver használatával.

Az elkészült tesztek kompatibilisek az alábbi böngészőkkel:
* Google Chrome
* Mozilla Firefox
* Microsoft Edge

### Tesztelt featurek:
* Regisztráció
* Bejelentkezés
* Adat listázás
* Felhasználó adatok kezelése
* Kommentelés
* Adat kinyerés
* Kijelentkezés

***
## A tesztek futtatsnak módszere
Az automata tesztek futtatsához szükségünk van IntelliJ IDEA-ra JAVA SE 15-tel, a fent listázott böngészők egyikére és a blog_input_data.csv filera.

### Az automata tesztek futtatása:
1. Klónozd ezt a repositoryt a számítógépedre
2. Nyisd meg a klónozott `automated-tests` Gradle projectet IntelliJ IDEA használatával
3. Nyisd meg a terminált a kijelző alján\
(Az esetek többségében ez egy PowerShell terminált fog megnyitni.)
4. Írd be a következőt a terminálba: `.\gradlew clean test`
5. Nyomd meg az `Enter` gombot

Amennyiben a csomagot másik böngészővel szeretnénk futtatni, kövessük az alábbi lépéseket:

1. Nyisd meg az `automated-tests` Gradle projectet IntelliJ IDEA-val
2. Keresd meg és nyisd meg a `test.properties` filet a `resources` mappában
3. Helyettesítsd a `chrome` szövegrészt `firefox`-ra vagy `edge`-re
4. Zárd be a `test.properties` filet
5. Futtasd a teszteket követve `Az automata tesztek futtatása` részt a 3. ponttól kezdve
***
## Reportálási módszer és a reportok elérése
A teszt eredmények reportálásához Alluret használok. Az Allure egy nyílt forrású program váz, amely arra lett tervezve, hogy a teszt reportok mindenki számára egyértelmúek lehessenek.

Eza kész projekt már tartalmazza az alluret, így nem szükséges külön letöltenünk.
Amennyiben valamilyen oknál fogva az allure mappák hiányoznak a projektből, a következő lépésekkel pótolhatjuk azokat (feltételezve, hogy az IntelliJ már meg van nyiva).

1. Nyisd meg a terminált a képernyő alján
2. Írd be a következőt a terminálba`.\gradlew downloadAllure`\
(Ez a parancs letölti az alluret a jelenleg megnyitott projektbe)
3. Nyomd meg az `Enter` billentyűt

Hogy megkapjuk az Allure teszt reportokat, futtassuk a tesztkeinket a `A tesztek futtatásának módszere` alapján. Amikor a tesztek lefutottak, kövessük az alábbi lépéseket.

1. Nyisd meg a terminált a képernyő alján
2. Írd be a következőt a terminálba`.\gradlew allureServe`
3. Nyomd meg az `Enter` billentyűt

A fentieket követően az Allure megnyit egy, a reportokat tartalmazó böngésző ablakot.
Itt megtlálhatók  a tesztesetek részletezve. Lehetőségv van egyesével megnyitni a reportokat, ahol láthatjuk az esetlegesen csatolt fileokat. A csatolt fileok a teszteset leírása alatt találhatók.
Amikor végeztük a report olvasásával, egyszerűen csak zárjuk be a böngésző ablakot.

### Fontos információ a tesztek futtatásához és a reportáláshoz
Néha az IntelliJ IDEA más terminált használ, mint a PowerShell.
Amennyiben a fenti terminál parancsok nem működnek, próbáljuk meg őkeet `.\` nélkül futtatni.