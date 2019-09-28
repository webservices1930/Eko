# Proyecto EKO

Este proyecto está hecho para la clase de Web Services de la Pontificia Univerisdad Javeriana. Para correr este proyecto es necesario instalar:

## Mongo DB
[Descargar Mongo DB](https://www.mongodb.com/download-center/community)
- Descargar e instalar Mongo DB.
- En la instalación dar que sí queremos instalar `Mongo DB Compass Community`.
- Al terminar la instalación abrir `Mongo DB Compass Community`.
- Dar click en `CONNECT`.
- Dar click en `CREATE DATABASE` y en **Database Name** poner `EkoDB` y en **Collection Name** ´poner `productos`.

## Eclipse
[Descargar Eclipse IDE](https://www.eclipse.org/downloads/download.php?file=/oomph/epp/2019-09/R/eclipse-inst-win64.exe)

- Descargar e instalar el IDE.
- Abrir. Dar click en `File > import > Maven > Existing Maven Projects`.
- En Root Directory dar click en `Browse` y buscar la carpeta de **EkoSertver**.
- Esperar a que termine la importació de maven y ejecutar el proyecto desde el archivo `EkoPublisher.java` en el paquete `co.edu.javeriana.eko`.

## NODE JS
[Descargar Node JS](https://nodejs.org/es/)

- Descargar e instalar Node JS.
- Abrir una consola de windows (CMD, Powershell) o la consola del sistema operativo en la que se esté ejectuando.
- Ejecutar el comando `npm --version` para verificar la versión de NPM y saber si fue instalado correctamente.
- Ejecutar los comandos `npm install -g npm` y `npm install -g @angular/cli` para instalar Angular
- Ejecutar el comando `ng --version` para verificar la versión de Angular y saber si fue instalado correctamente.

Para este proyecto se utilizará **Yarn** como manejador de los paquetes de NODE, para ello:

- [Descargar Yarn](https://yarnpkg.com/lang/en/docs/install/#windows-stable) e instalarlo.
- Abrir una consola de windows (CMD, Powershell) o la consola del sistema operativo en la que se esté ejectuando.
- Ejecutar  `yarn -v` para verificar la versión de Yarn y saber si fue instalado correctamente.


También se recomienda [Descargar Visual Studio Code](https://code.visualstudio.com/download) para abrir el proyecto cliente.

- Una vez descargado e instalado Visual Studio Code, ejecutarlo.
- Dar click en `File > Open Folder` y abrir la carpeta **EkoClient**.
- En el IDE de Visual Studio Code ir a la pestaña `Terminal` y dar click en `New Terminal`.
- Ejecutar el comando `ng config -g cli.packageManager yarn`
- Luego ejecutar el comando `yarn install` para instalar los paquetes necesarios para el cliente.
- Ejecutar el comando `yarn start` para iniciar el Cliente.
- Ir al Navegador y entrar a [http://localhost:4200](http://localhost:4200/)
