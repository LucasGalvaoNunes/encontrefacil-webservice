# **Encontre Fácil** #
WebService RESTFul Utilizando Hibernate.
## **Equipe:** ##
* **Lucas Galvão Nunes**
* **Rafael Valente dos Santos**

# **Configurando o projeto:** #
 Para que o projeto funcione corretamente é necessario fazer a instalação das seguintes extensões:

1. [Maven for Windows](http://www-us.apache.org/dist/maven/maven-3/3.3.9/binaries/apache-maven-3.3.9-bin.zip)
1. [TomCat Windows x86](http://www-eu.apache.org/dist/tomcat/tomcat-8/v8.5.13/bin/apache-tomcat-8.5.13-windows-x86.zip) /  [TomCat Windows x64](http://www-eu.apache.org/dist/tomcat/tomcat-8/v8.5.13/bin/apache-tomcat-8.5.13-windows-x64.zip)
1. [Java JDK  8](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
1. Instalar o Jboss no eclipse

### **Instalação do maven:** ###
Depois de baixado o maven, Extraia o arquivo para a pasta que quiser no meu caso foi C:\Dev\apache-maven-3.3.9 e siga os passos:

**1. Aperte as teclas WIN+Pause para abrir as propriedades do sistema e clique em Advance system settings:**

![explorer_2017-04-04_23-17-43.png](https://bitbucket.org/repo/4pKdGz4/images/39522753-explorer_2017-04-04_23-17-43.png)

**2. Na tela em que abrir clique em Environment Variables...**

![SystemPropertiesAdvanced_2017-04-04_23-18-23.png](https://bitbucket.org/repo/4pKdGz4/images/2036493051-SystemPropertiesAdvanced_2017-04-04_23-18-23.png)

**3. Clique em New e em Variable Name digite "M2_HOME" e coloque o caminho do arquivo maven que foi baixado e extraído anteriormente.**

![chrome_2017-04-04_23-21-22.png](https://bitbucket.org/repo/4pKdGz4/images/1069663670-chrome_2017-04-04_23-21-22.png)

**4. Fazendo o mesmo passo que o anterior agora adicione um novo com o nome "MAVEN_HOME" com o mesmo caminho que o anterior**

**5. Agora click em Path e em seguida click em Edit Text e adicione no final ;%MAVEN_HOME%\bin; como marcado na imagem abaixo ...**

![chrome_2017-04-04_23-26-19.png](https://bitbucket.org/repo/4pKdGz4/images/2104537354-chrome_2017-04-04_23-26-19.png)
![chrome_2017-04-04_23-27-51.png](https://bitbucket.org/repo/4pKdGz4/images/1294993512-chrome_2017-04-04_23-27-51.png)

**6. Feito todos os passo agora abra o CMD e digite a seguinte linha**
```
#!bash

mvn -version
```
Então devera aparecer as seguintes informações:

![cmd_2017-04-04_23-38-14.png](https://bitbucket.org/repo/4pKdGz4/images/3257709587-cmd_2017-04-04_23-38-14.png)

Caso Apareça algum erro de JAVA_HOME, faca os mesmos passo que fizemos para adicionar o "MAVEN_HOME", só que no nome agora vai ser "JAVA_HOME" e o caminho é a pasta onde esta o Jdk instalado na sua maquina por padrão é C:\Program Files\Java\jdk1.8.0_121, porém confira para ver se é realmente.

### **Instalação do Apache TomCat:** ###

Depois de baixado o maven, Extraia o arquivo para a pasta que quiser.No meu caso foi C:\Dev\apache-tomcat-8.5.13 e siga os passos:

**1. Aperte as teclas WIN+Pause para abrir as propriedades do sistema e clique em Advance system settings:**

![explorer_2017-04-04_23-17-43.png](https://bitbucket.org/repo/4pKdGz4/images/39522753-explorer_2017-04-04_23-17-43.png)

**2. Na tela em que abrir clique em Environment Variables...**

![SystemPropertiesAdvanced_2017-04-04_23-18-23.png](https://bitbucket.org/repo/4pKdGz4/images/2036493051-SystemPropertiesAdvanced_2017-04-04_23-18-23.png)

**3. Clique em New e em Variable Name digite "CATALINA_HOME" e coloque o caminho do Tomcat que foi baixado e extraído anteriormente.**

![chrome_2017-04-04_23-33-38.png](https://bitbucket.org/repo/4pKdGz4/images/3159450226-chrome_2017-04-04_23-33-38.png)

**4. Agora clique em Path e em seguida click em Edit Text e adcione no final ;%CATALINA_HOME%; como marcado na imagem abaixo ...**

![chrome_2017-04-04_23-26-19.png](https://bitbucket.org/repo/4pKdGz4/images/2104537354-chrome_2017-04-04_23-26-19.png)
![chrome_2017-04-04_23-34-56.png](https://bitbucket.org/repo/4pKdGz4/images/4206508212-chrome_2017-04-04_23-34-56.png)