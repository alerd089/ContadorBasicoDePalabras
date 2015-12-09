# ContadorBasicoDePalabras
Contador Basico de palabras Java

Para la realización de este proyecto se emplearon tecnologias ccomo el leguaje java, el IDE Eclipse, corrido en un Sistema Operativo Windows 8.

Forma de uso:

El codigo fuente del programa esta denominado Counter.java
El codigo antes de utilizarse debe de ser compilado.
Una vez descargado desde Github el proyecto decomprimir en la ubicacion que prefiera.
Para compilar es necesario desde linea de comandos ubicarse en el directorio en el que se encuentre el archivo "Counter.java", y ejecutar el siguiente comando
    
    javac Counter.java
    
Una vez compilado le generara un archivo llamado Counter.class.
Para ejecutarlo es necesario contar con el archivo de texto (.txt) al cual desea contar el numero de palabras existente, asi como el archivo "pal.txt" proporcionado en el proyecto.
El archivo "pal.txt" debera estar en la misma ubicacion que el archivo Counter.class, mientras que el archivo a contar puede estar en cualquier otro directorio.
El comando para ejecutar el programas (despues de estar complado) es el siguiente:

    java Counter Nombre_del_archivo_a_contar
    
En Nombre_del_archivo_a_contar usted debera proporcionar la ruta(si no esta ubicado en el mismo directorio) del archivo, o si esta en el mismo directorio bastara con el nombre del archivo, tras la finalización la consola te agregara datos como:

    Numero de palabras con auxiliar.
    Numero de palabras sin auxiliar.
    10 palabras mas repetidas
    
Asimismo el programa te generara un archivo de texto llamado "mitexto.mireporte.txt" que estara en la misma ubicacion que el archivo Counter.class.

El archivo contara con:
    
    Numero de palabras con auxiliar.
    Numero de palabras sin auxiliar.
    10 palabras mas repetidas
    Todas las palabras con las veces que se repite incluyendo auxiliares
    
Ejemplo de una corrida:

Dentro del proyecto se tiene 2 archivos .txt uno llamado "data.txt" que es el que utilizaremos para la prueba y "pal.txt" que nos sirve como complemento en la ejecucion del programa.. 
De esta manera despues de descomprimir tendremos la carpeta "src" donde se encuentran los archivos:
    
    Counter.java
    pal.txt
    data.txt
    
Desde linea de comandos nos colocamos en la carpeta src de acuerdo a la ruta en que se ubico.

Ejecutamos:

    javac Counter.java

Generara un archivo llamado "Counter.class" y escribimos en consola:

    java Counter data.txt
    
Tras finalizar mostrara información antes mencionada en consola y en el archivo de texto "mitexto.mireporte.txt".
