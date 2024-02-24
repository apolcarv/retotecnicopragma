# Autor: Alejandro Polo Carvajal
#### https://www.linkedin.com/in/alejandro-polo-carvajal-790b79186/
##### ------------------------------------------------------------------------------------------------------
# Reto tecnico pragma E2E:
##### ------------------------------------------------------------------------------------------------------

#### Pagina automatizada: https://www.demoblaze.com/index.html
#### Funciones automatizadas: • Autenticarse  • Finalizar la compra hasta la confirmación: “Thank you for your purchase!”
#### Patron de diseño: Screenplay
#### Framework: gherkin, cucumber, Junit, SerenityBDD, selenium
#### Framework adicionales: librerias lombok, Faker, SonarLink, cucumber for java, json
#### Lenguaje programacion: Java
#### version gradle: gradle-8.4
#### OPEN_JDK Version 17.0.9
#### Driver: Edge version  121.0.2277.128 (Descarga remota)
#### ID: Intellij IDEA community Edition 2023.1
##### ------------------------------------------------------------------------------------------------------

### Todos los casos pruebas cumplen con cada criterio solicitado
### Todas las clases estan con auto-ident lines y reformat code
### El codigo no tiene ningun Bug o codeSmell
##### ------------------------------------------------------------------------------------------------------
# PASOS PARA LA EJECUCIÓN

### PASO A PASO PARA LA EJECUCIÓN POR CONSOLA

### Comando para ejecutar por feature
### EJEMPLOS
#### ./gradlew test --tests "co.com.pragma.project.runners.LoginRunner" --- un solo feature
#### ./gradlew test --tests "co.com.pragma.project.runners.CheckoutCompleteRunner" --- un solo feature
##### ------------------------------------------------------------------------------------------------------
#### ./gradlew test --tests "co.com.pragma.project.runners.*" --- TODOS LOS FEATURES

### Comando para limpiar la carpeta Target (Reportes)
#### ./gradlew clearReports

### Comando para generar reporte despues que haya terminado un test (Por consola arrojara la ruta .html )
#### ./gradlew reports


