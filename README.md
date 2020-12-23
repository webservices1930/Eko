# EKO

## ENGLISH

This project was made for the Web Services' subject of the Pontificia Universidad Javeriana. To run this project you'll need to install:

### Mongo DB
[Download Mongo DB](https://www.mongodb.com/download-center/community)
- Download and install Mongo DB.
- On the instalation, we mark we want to install `Mongo DB Compass Community`.
- At the end of the instalation open `Mongo DB Compass Community`.
- Click on `CONNECT`.
- Click on `CREATE DATABASE`, in **Database Name** write `EkoDB` and in **Collection Name** write `productos`.

### Eclipse
[Download Eclipse IDE](https://www.eclipse.org/downloads/download.php?file=/oomph/epp/2019-09/R/eclipse-inst-win64.exe)

- Download and install `Eclipse IDE`.
- Open `Eclipse`. Click on `File > import > Maven > Existing Maven Projects`.
- On the root directory click on `Browse` and search the folder **EkoSertver**.
- Wait for the Maven importing process ends and execute the project from the file `EkoPublisher.java` on the package `co.edu.javeriana.eko`.

### NODE JS
[Download Node JS](https://nodejs.org/es/)

- Download and install `Node JS`.
- Open the console on Windows (CMD, Powershell) or the console of your own operating system.
- Execute the command `npm --version` to verify if npm and node were correctly installed.
- Execute the commands `npm install -g npm` and `npm install -g @angular/cli` to install Angular on your computer.
- Execute the command `ng --version` to verify if Angular Version was correctly installed.

For this project we'll use **Yarn** as our NODE package manager:

- [Download Yarn](https://yarnpkg.com/lang/en/docs/install/#windows-stable) and install it.
- Open the console on Windows (CMD, Powershell) or the console of your own operating system.
- EjecuExecute the commandar  `yarn -v` to verify if yarn was correctly installed.


We also recommend to [Download Visual Studio Code](https://code.visualstudio.com/download) to open the client and edit it.

- Once Visual Studio Code was installed, open it.
- Click on `File > Open Folder` and open the folder **EkoClient**.
- On Visual Studio Code go to the `Terminal` tab and click on `New Terminal`.
- Execute the command  `ng config -g cli.packageManager yarn`
- Then Execute the command  `yarn install` to install the node_modules.
- Execute the command  `yarn start` to start the client.
- Go to your favorite browser to the [http://localhost:4200](http://localhost:4200/).

---
## ESPAÑOL

Este proyecto está hecho para la clase de Web Services de la Pontificia Univerisdad Javeriana. Para correr este proyecto es necesario instalar:
### Mongo DB
[Descargar Mongo DB](https://www.mongodb.com/download-center/community)
- Descargar e instalar Mongo DB.
- En la instalación dar que sí queremos instalar `Mongo DB Compass Community`.
- Al terminar la instalación abrir `Mongo DB Compass Community`.
- Dar click en `CONNECT`.
- Dar click en `CREATE DATABASE` y en **Database Name** poner `EkoDB` y en **Collection Name** ´poner `productos`.

### Eclipse
[Descargar Eclipse IDE](https://www.eclipse.org/downloads/download.php?file=/oomph/epp/2019-09/R/eclipse-inst-win64.exe)

- Descargar e instalar el IDE.
- Abrir. Dar click en `File > import > Maven > Existing Maven Projects`.
- En Root Directory dar click en `Browse` y buscar la carpeta de **EkoSertver**.
- Esperar a que termine la importació de maven y ejecutar el proyecto desde el archivo `EkoPublisher.java` en el paquete `co.edu.javeriana.eko`.

### NODE JS
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
