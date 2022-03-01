---
title: Gradle Introdução
author: wagner
layout: home
date: 2019-07-21
---
<div id="table-of-contents">
<h2>Table of Contents</h2>
<div id="text-table-of-contents">
<ul>
<li><a href="#orgfa9c1c3">1. Introdução</a></li>
<li><a href="#orgf807e48">2. Instalação do Gradle e Conf do Path</a></li>
<li><a href="#org814e400">3. Criação de um projeto java básico</a></li>
<li><a href="#org969848b">4. Conhecendo a estrutura do nosso projeto</a>
<ul>
<li><a href="#org64b2704">4.1. O arquivo build.gradle</a></li>
<li><a href="#org40224d6">4.2. O arquivo .gitignore</a></li>
<li><a href="#orga5599e6">4.3. O diretório .gradle</a></li>
<li><a href="#org6b15c62">4.4. O diretório  gradle</a></li>
<li><a href="#org6e0f0d7">4.5. O arquivo gradlew</a></li>
<li><a href="#orgc0c3d98">4.6. O arquivo gradlew.bat</a></li>
<li><a href="#org4e88212">4.7. settings.gradle</a></li>
<li><a href="#org2565014">4.8. src</a></li>
<li><a href="#org983c045">4.9. src/main/java/br/com/exemplo/App.java</a></li>
<li><a href="#org896bf64">4.10. src/test/java/br/com/exemplo/AppTest.java</a></li>
</ul>
</li>
<li><a href="#org734f38e">5. Buildando e Executando o projeto</a>
<ul>
<li><a href="#org29c80c9">5.1. Executando o nosso programa</a></li>
</ul>
</li>
<li><a href="#org7e8cf4a">6. Fluxo de trabalho dom o gradle</a></li>
<li><a href="#orgabe9ec2">7. Tasks do gradle</a></li>
<li><a href="#org62a13b2">8. Referencias</a></li>
</ul>
</div>
</div>

<div id="outline-container-orgfa9c1c3" class="outline-2">
<h2 id="orgfa9c1c3"><span class="section-number-2">1</span> Introdução</h2>
</div>


<div id="outline-container-orgf807e48" class="outline-2">
<h2 id="orgf807e48"><span class="section-number-2">2</span> Instalação do Gradle e Conf do Path</h2>
<div class="outline-text-2" id="text-2">
<p>
Faça o download do gradle em 
<a href="https://downloads.gradle.org/distributions/gradle-5.5-rc-4-bin.zip">https://downloads.gradle.org/distributions/gradle-5.5-rc-4-bin.zip</a>
</p>

<p>
Descompacte em o gradle em algum diretório, eu descompactei o meu em
</p>

<p>
/home/wagner/wagnerdocri@gmail.com3/fzlbpms/fzlStudio/integrated/build/gradle-5.1.1
</p>

<p>
Agora crie a variável de ambiente GRADLE<sub>HOME</sub> e configure o PATH da
sua máquina.
</p>

<div class="org-src-container">
<pre class="src src-shell" id="org25d18f7"><span style="color: #b0c4de;">export</span> <span style="color: #eedd82;">GRADLE_HOME</span>=/home/wagner/wagnerdocri@gmail.com3/fzlbpms/fzlStudio/integrated/build/gradle-5.1.1
<span style="color: #b0c4de;">export</span> <span style="color: #eedd82;">PATH</span>=$<span style="color: #eedd82;">PATH</span>:$<span style="color: #eedd82;">GRADLE_HOME</span>/bin     
gradle -v
</pre>
</div>

<pre class="example">

------------------------------------------------------------
Gradle 5.1.1
------------------------------------------------------------

Build time:   2019-01-10 23:05:02 UTC
Revision:     3c9abb645fb83932c44e8610642393ad62116807

Kotlin DSL:   1.1.1
Kotlin:       1.3.11
Groovy:       2.5.4
Ant:          Apache Ant(TM) version 1.9.13 compiled on July 10 2018
JVM:          1.8.0_191 (Oracle Corporation 25.191-b12)
OS:           Linux 5.1.18-200.fc29.x86_64 amd64

</pre>
</div>
</div>

<div id="outline-container-org814e400" class="outline-2">
<h2 id="org814e400"><span class="section-number-2">3</span> Criação de um projeto java básico</h2>
<div class="outline-text-2" id="text-3">
<p>
<a href="https://guides.gradle.org/building-java-applications/">https://guides.gradle.org/building-java-applications/</a>
</p>

<p>
Pra criar um projeto com gradle a gente cria uma pasta, entra nela e
dá o comando gradle init + parametros.
Esse "init" é um plugin do gradle[gradleCodsInitPlugin]
</p>

<div class="org-src-container">
<pre class="src src-shell" id="org3a58fe6"><span style="color: #ff7f24;">#</span><span style="color: #ff7f24;">starts code</span>
<span style="color: #b0c4de;">export</span> <span style="color: #eedd82;">GRADLE_PROJECTS_DIR</span>=/home/wagner/wagnerdocri@gmail.com3/envs/env-dev/sources/somewritings/gradle-introduction/projetos/                                 
mkdir -p $<span style="color: #eedd82;">GRADLE_PROJECTS_DIR</span>

<span style="color: #b0c4de;">cd</span> $<span style="color: #eedd82;">GRADLE_PROJECTS_DIR</span>
rm -rf demojavaproj
mkdir demojavaproj &amp;&amp; <span style="color: #b0c4de;">cd</span> demojavaproj
<span style="color: #b0c4de;">echo</span> 1 | gradle init --type java-application <span style="color: #ffa07a;">\</span>
            --project-name demojavaproject <span style="color: #ffa07a;">\</span>
            --package br.com.exemplo <span style="color: #ffa07a;">\</span>
            --test-framework junit <span style="color: #ff7f24;">#</span><span style="color: #ff7f24;">\</span>
            <span style="color: #ff7f24;">#</span><span style="color: #ff7f24;">-Dhttp.proxyHost=192.168.0.2 -Dhttp.proxyPort=3128 -Dhttp.proxyUser=cid2 -Dhttp.proxyPort=cid2                  </span>
<span style="color: #b0c4de;">pwd</span>
ls -la
</pre>
</div>

<pre class="example">

[wagner@Unknown demojavaproj]$ [wagner@Unknown demojavaproj]$ [wagner@Unknown demojavaproj]$ [wagner@Unknown projetos]$ [wagner@Unknown projetos]$ [wagner@Unknown demojavaproj]$ &gt; &gt; &gt; Starting a Gradle Daemon (subsequent builds will be faster)
Task :wrapper
Task :init

BUILD SUCCESSFUL in 3s
2 actionable tasks: 2 executed
[wagner@Unknown demojavaproj]$ /home/wagner/wagnerdocri@gmail.com3/envs/env-dev/sources/somewritings/gradle-introduction/projetos/demojavaproj
total 44
drwxrwxr-x. 5 wagner wagner 4096 jul 21 21:05 .
drwxrwxr-x. 4 wagner wagner 4096 jul 21 21:05 ..
-rw-rw-r--. 1 wagner wagner  949 jul 21 21:05 build.gradle
-rw-rw-r--. 1 wagner wagner  103 jul 21 21:05 .gitignore
drwxrwxr-x. 4 wagner wagner 4096 jul 21 21:05 .gradle
drwxrwxr-x. 3 wagner wagner 4096 jul 21 21:05 gradle
-rwxrwxr-x. 1 wagner wagner 5305 jul 21 21:05 gradlew
-rw-rw-r--. 1 wagner wagner 2269 jul 21 21:05 gradlew.bat
-rw-rw-r--. 1 wagner wagner  363 jul 21 21:05 settings.gradle
drwxrwxr-x. 4 wagner wagner 4096 jul 21 21:05 src
</pre>

<p>
Nos comandos acima, o mais importante foi gradle init que pode ser
dado também com o gradle &#x2013;task :init
</p>
</div>
</div>


<div id="outline-container-org969848b" class="outline-2">
<h2 id="org969848b"><span class="section-number-2">4</span> Conhecendo a estrutura do nosso projeto</h2>
<div class="outline-text-2" id="text-4">
<p>
Segue abaixo a estrutura do projeto. O importante é conhecer pra que
que serve cada um arquivo e diretório, o professor vai ler com vcs em sala de aula e
explicar cada um desses arquivos.
</p>
</div>


<div id="outline-container-org64b2704" class="outline-3">
<h3 id="org64b2704"><span class="section-number-3">4.1</span> O arquivo build.gradle</h3>
<div class="outline-text-3" id="text-4-1">
<div class="org-src-container">
<pre class="src src-groovy"> <span style="color: #ff7f24;">/*</span>
<span style="color: #ff7f24;"> * This file was generated by the Gradle 'init' task.</span>
<span style="color: #ff7f24;"> *</span>
<span style="color: #ff7f24;"> * This generated file contains a sample Java project to get you started.</span>
<span style="color: #ff7f24;"> * For more details take a look at the Java Quickstart chapter in the Gradle</span>
<span style="color: #ff7f24;"> * user guide available at https://docs.gradle.org/5.1.1/userguide/tutorial_java_projects.html</span>
<span style="color: #ff7f24;"> */</span>

plugins {
    <span style="color: #ff7f24;">// Apply the java plugin to add support for Java</span>
    id <span style="color: #ffa07a;">'java'</span>

    <span style="color: #ff7f24;">// Apply the application plugin to add support for building an application</span>
    id <span style="color: #ffa07a;">'application'</span>
}

repositories {
    <span style="color: #ff7f24;">// Use jcenter for resolving your dependencies.</span>
    <span style="color: #ff7f24;">// You can declare any Maven/Ivy/file repository here.</span>
    jcenter()
}

dependencies {
    <span style="color: #ff7f24;">// This dependency is found on compile classpath of this component and consumers.</span>
    implementation <span style="color: #ffa07a;">'com.google.guava:guava:26.0-jre'</span>

    <span style="color: #ff7f24;">// Use JUnit test framework</span>
    testImplementation <span style="color: #ffa07a;">'junit:junit:4.12'</span>
}

<span style="color: #ff7f24;">// Define the main class for the application</span>
mainClassName = <span style="color: #ffa07a;">'br.com.exemplo.App'</span>
</pre>
</div>
</div>
</div>


<div id="outline-container-org40224d6" class="outline-3">
<h3 id="org40224d6"><span class="section-number-3">4.2</span> O arquivo .gitignore</h3>
<div class="outline-text-3" id="text-4-2">
<p>
Se o seu projeto não tiver um, pode criar.
O professore vai explicar em sala sobre esse arquivo.
</p>
</div>
</div>



<div id="outline-container-orga5599e6" class="outline-3">
<h3 id="orga5599e6"><span class="section-number-3">4.3</span> O diretório .gradle</h3>
</div>


<div id="outline-container-org6b15c62" class="outline-3">
<h3 id="org6b15c62"><span class="section-number-3">4.4</span> O diretório  gradle</h3>
<div class="outline-text-3" id="text-4-4">
<p>
Diretório de cache do gradle
</p>
</div>
</div>


<div id="outline-container-org6e0f0d7" class="outline-3">
<h3 id="org6e0f0d7"><span class="section-number-3">4.5</span> O arquivo gradlew</h3>
<div class="outline-text-3" id="text-4-5">
<p>
Um shellscript pra usar o o comando gradlew (gradle wrapper) no
linux
</p>
</div>
</div>

<div id="outline-container-orgc0c3d98" class="outline-3">
<h3 id="orgc0c3d98"><span class="section-number-3">4.6</span> O arquivo gradlew.bat</h3>
<div class="outline-text-3" id="text-4-6">
<p>
Arquivo de lote pra usar o comando gradlew (gradle wrapper) no
windows
</p>
</div>
</div>


<div id="outline-container-org4e88212" class="outline-3">
<h3 id="org4e88212"><span class="section-number-3">4.7</span> settings.gradle</h3>
<div class="outline-text-3" id="text-4-7">
<p>
Esse é o arquivo que a gente mais vai utilizar durante as aulas
</p>
<div class="org-src-container">
<pre class="src src-groovy"><span style="color: #ff7f24;">/*</span>
<span style="color: #ff7f24;"> * This file was generated by the Gradle 'init' task.</span>
<span style="color: #ff7f24;"> *</span>
<span style="color: #ff7f24;"> * The settings file is used to specify which projects to include in your build.</span>
<span style="color: #ff7f24;"> *</span>
<span style="color: #ff7f24;"> * Detailed information about configuring a multi-project build in Gradle can be found</span>
<span style="color: #ff7f24;"> * in the user guide at https://docs.gradle.org/5.1.1/userguide/multi_project_builds.html</span>
<span style="color: #ff7f24;"> */</span>

rootProject.name = <span style="color: #ffa07a;">'demojavaproject'</span>
</pre>
</div>
</div>
</div>


<div id="outline-container-org2565014" class="outline-3">
<h3 id="org2565014"><span class="section-number-3">4.8</span> src</h3>
<div class="outline-text-3" id="text-4-8">
<p>
Diretório dos nossos códigos
</p>
</div>
</div>

<div id="outline-container-org983c045" class="outline-3">
<h3 id="org983c045"><span class="section-number-3">4.9</span> src/main/java/br/com/exemplo/App.java</h3>
<div class="outline-text-3" id="text-4-9">
<p>
codigo java (src/main/java/br/com/exemplo/App.java)
</p>

<div class="org-src-container">
<pre class="src src-java"><span style="color: #ff7f24;">/*</span>
<span style="color: #ff7f24;"> * This Java source file was generated by the Gradle 'init' task.</span>
<span style="color: #ff7f24;"> */</span>
<span style="color: #00ffff;">package</span> br.com.<span style="color: #7fffd4;">exemplo</span>;

<span style="color: #00ffff;">public</span> <span style="color: #00ffff;">class</span> <span style="color: #98fb98;">App</span> {
    <span style="color: #00ffff;">public</span> <span style="color: #98fb98;">String</span> <span style="color: #87cefa;">getGreeting</span>() {
        <span style="color: #00ffff;">return</span> <span style="color: #ffa07a;">"Hello world."</span>;
    }

    <span style="color: #00ffff;">public</span> <span style="color: #00ffff;">static</span> <span style="color: #98fb98;">void</span> <span style="color: #87cefa;">main</span>(<span style="color: #98fb98;">String</span>[] <span style="color: #eedd82;">args</span>) {
        System.out.println(<span style="color: #00ffff;">new</span> <span style="color: #98fb98;">App</span>().getGreeting());
    }
}
</pre>
</div>
</div>
</div>

<div id="outline-container-org896bf64" class="outline-3">
<h3 id="org896bf64"><span class="section-number-3">4.10</span> src/test/java/br/com/exemplo/AppTest.java</h3>
<div class="outline-text-3" id="text-4-10">
<p>
codigo java (src/test/java/br/com/exemplo/AppTest.java)
</p>
<div class="org-src-container">
<pre class="src src-java"><span style="color: #ff7f24;">/*</span>
<span style="color: #ff7f24;"> * This Java source file was generated by the Gradle 'init' task.</span>
<span style="color: #ff7f24;"> */</span>
<span style="color: #00ffff;">package</span> br.com.<span style="color: #7fffd4;">exemplo</span>;

<span style="color: #00ffff;">import</span> <span style="color: #7fffd4;">org</span>.<span style="color: #7fffd4;">junit</span>.<span style="color: #98fb98;">Test</span>;
<span style="color: #00ffff;">import</span> <span style="color: #00ffff;">static</span> <span style="color: #7fffd4;">org</span>.<span style="color: #7fffd4;">junit</span>.<span style="color: #7fffd4;">Assert</span>.*;

<span style="color: #00ffff;">public</span> <span style="color: #00ffff;">class</span> <span style="color: #98fb98;">AppTest</span> {
    <span style="color: #7fffd4;">@Test</span> <span style="color: #00ffff;">public</span> <span style="color: #98fb98;">void</span> <span style="color: #87cefa;">testAppHasAGreeting</span>() {
        <span style="color: #98fb98;">App</span> <span style="color: #eedd82;">classUnderTest</span> = <span style="color: #00ffff;">new</span> <span style="color: #98fb98;">App</span>();
        assertNotNull(<span style="color: #ffa07a;">"app should have a greeting"</span>, classUnderTest.getGreeting());
    }
}
</pre>
</div>
</div>
</div>
</div>

<div id="outline-container-org734f38e" class="outline-2">
<h2 id="org734f38e"><span class="section-number-2">5</span> Buildando e Executando o projeto</h2>
<div class="outline-text-2" id="text-5">
<p>
Entre escrever um código e rodá-lo, precisa gerar os bytecodes
(buildar) empacotar.
Pra efeitos do nosso projetinho de exemplo, empacotar significa
gerar um arquivo jar que possa ser executável.
Não vai pensar que é todo jar que é executável heinn&#x2026; Você vai
lembrar que vários jars servem apenas como bibliotecas, lembra?
Então um jar pra ser executável mesmo vc precisar configuar no
MANIFEST.mf qual a
classe que tem o método main. Agente vai ver isso daqui a pouco.
</p>

<p>
Bom, pelo código java dá pra perceber que a funcionalidade dele é
emitir uma saudação, e a classe de teste testa  se a
saudação não é nula.
</p>


<div class="org-src-container">
<pre class="src src-shell" id="org1ab6001"><span style="color: #ff7f24;">#</span><span style="color: #ff7f24;">starts code</span>
<span style="color: #ff7f24;">#</span><span style="color: #ff7f24;">cd $GRADLE_PROJECTS_DIR/demojavaproj</span>
<span style="color: #ff7f24;">#</span><span style="color: #ff7f24;">echo "org.gradle.daemon=true" &gt; gradle.properties</span>
<span style="color: #ff7f24;">#</span><span style="color: #ff7f24;">echo "org.gradle.parallel=true" &gt;&gt; gradle.properties</span>
</pre>
</div>

<div class="org-src-container">
<pre class="src src-shell" id="org8665677"><span style="color: #ff7f24;">#</span><span style="color: #ff7f24;">starts code</span>
<span style="color: #b0c4de;">cd</span> $<span style="color: #eedd82;">GRADLE_PROJECTS_DIR</span>/demojavaproj &amp;&amp; ./gradlew build
</pre>
</div>


<div class="org-src-container">
<pre class="src src-shell" id="org9188da2"><span style="color: #ff7f24;">#</span><span style="color: #ff7f24;">starts code</span>
<span style="color: #b0c4de;">cd</span> $<span style="color: #eedd82;">GRADLE_PROJECTS_DIR</span>/demojavaproj &amp;&amp; ./gradlew tasks
</pre>
</div>


<pre class="example">
   [wagner@Unknown gradle-introduction]$ gradle -v

------------------------------------------------------------
Gradle 5.1.1
------------------------------------------------------------

Build time:   2019-01-10 23:05:02 UTC
Revision:     3c9abb645fb83932c44e8610642393ad62116807

Kotlin DSL:   1.1.1
Kotlin:       1.3.11
Groovy:       2.5.4
Ant:          Apache Ant(TM) version 1.9.13 compiled on July 10 2018
JVM:          1.8.0_201 (Oracle Corporation 25.201-b09)
OS:           Linux 4.20.5-200.fc29.x86_64 amd64

[wagner@Unknown gradle-introduction]$ gradle build
Starting a Gradle Daemon, 1 incompatible Daemon could not be reused, use --status for details

&gt; Task :buildEnvironment

------------------------------------------------------------
Root project
------------------------------------------------------------

classpath
No dependencies

A web-based, searchable dependency report is available by adding the --scan option.

BUILD SUCCESSFUL in 4s
1 actionable task: 1 executed
[wagner@Unknown gradle-introduction]$ 

</pre>


<p>
Mas a gente faz o build pra que mesmo? A resposta é: pra obter o
nosso projeto como um pacote, ou seja, um arquivo só que pode ser
utilizado. A maioria das pessoas já pensa num arquivo .exe mas o
java pode gerar vários tipos de arquivos inclusive um executável
embora a extensão não seja exe mas .jar, isso mesmo um arquivo
executável com a extensão .jar
Um jar pode ser um arquivo executável ou não, se a gente quer que
ele seja a gente configura o arquivo MANIFEST dele pra que ele seja e se a
gente não quer que ele seja executável a gente não configura.
É muito comum que um arquivo jar não seja executável. As
dependencias dos nossos projetos java, e vc vai lembrar quando a
gente trabalha com jdbc, por exemplo, que tem que usar a
dependencia jdbc do banco que é um jar.. aquele jar do jdbc não era
executável. Aquele jar do jdbc nada mais era que código java empacotado que serve pra gente usar nos
nossos projetos.
Se vc não entendeu isso o professor escalarece pra vc na sala de
aula.
Então a gente deu um gradle build e ele deve então ter gerado o
nosso projeto como um pacote certo? Vamos ver&#x2026;
</p>

<div class="org-src-container">
<pre class="src src-shell" id="org3a35b33"><span style="color: #ff7f24;">#</span><span style="color: #ff7f24;">starts code</span>
<span style="color: #b0c4de;">cd</span> $<span style="color: #eedd82;">GRADLE_PROJECTS_DIR</span>/demojavaproj
ls -l 
ls -l build
ls -l build/distributions
</pre>
</div>

<pre class="example">

[wagner@Unknown demojavaproj]$ total 32
drwxrwxr-x. 9 wagner wagner 4096 fev  3 14:21 build
-rw-rw-r--. 1 wagner wagner  949 fev  3 14:16 build.gradle
drwxrwxr-x. 3 wagner wagner 4096 fev  3 14:16 gradle
-rwxrwxr-x. 1 wagner wagner 5305 fev  3 14:16 gradlew
-rw-rw-r--. 1 wagner wagner 2269 fev  3 14:16 gradlew.bat
-rw-rw-r--. 1 wagner wagner  363 fev  3 14:16 settings.gradle
drwxrwxr-x. 4 wagner wagner 4096 fev  3 14:16 src
total 28
drwxrwxr-x. 3 wagner wagner 4096 fev  3 14:21 classes
drwxrwxr-x. 2 wagner wagner 4096 fev  3 14:21 distributions
drwxrwxr-x. 2 wagner wagner 4096 fev  3 14:21 libs
drwxrwxr-x. 3 wagner wagner 4096 fev  3 14:21 reports
drwxrwxr-x. 2 wagner wagner 4096 fev  3 14:21 scripts
drwxrwxr-x. 3 wagner wagner 4096 fev  3 14:21 test-results
drwxrwxr-x. 5 wagner wagner 4096 fev  3 14:21 tmp
total 5488
-rw-rw-r--. 1 wagner wagner 3000320 fev  3 14:21 demojavaproject.tar
-rw-rw-r--. 1 wagner wagner 2615429 fev  3 14:21 demojavaproject.zip
</pre>

<p>
Acima a gente vê o resultado do nosso build. É um diretório chamado
build que dentro dele tem as compilação das classes java dentre
outros artefatos resultantes do build.
No diretório build/distributions tem o nosso projeto empacotado
como .tar e como .zip
O arquivo .tar é mais comumente utilizado no linux, e o zip com
certeza vc já conhece.
</p>



<div class="org-src-container">
<pre class="src src-sh" id="org1e7cffe"><span style="color: #ff7f24;">#</span><span style="color: #ff7f24;">starts code</span>
<span style="color: #b0c4de;">cd</span> $<span style="color: #eedd82;">GRADLE_PROJECTS_DIR</span>/demojavaproj/build/distributions            
unzip demojavaproject.zip 2&gt;&amp;1
<span style="color: #b0c4de;">cd</span> demojavaproject
ls -l
ls -l bin
<span style="color: #b0c4de;">cd</span> bin
<span style="color: #b0c4de;">pwd</span>
<span style="color: #b0c4de;">cd</span> ..
ls -l lib
</pre>
</div>

<pre class="example">

[wagner@Unknown distributions]$ Archive:  demojavaproject.zip
   creating: demojavaproject/
   creating: demojavaproject/lib/
  inflating: demojavaproject/lib/demojavaproject.jar  
  inflating: demojavaproject/lib/guava-26.0-jre.jar  
  inflating: demojavaproject/lib/jsr305-3.0.2.jar  
  inflating: demojavaproject/lib/checker-qual-2.5.2.jar  
  inflating: demojavaproject/lib/error_prone_annotations-2.1.3.jar  
  inflating: demojavaproject/lib/j2objc-annotations-1.1.jar  
  inflating: demojavaproject/lib/animal-sniffer-annotations-1.14.jar  
   creating: demojavaproject/bin/
  inflating: demojavaproject/bin/demojavaproject  
  inflating: demojavaproject/bin/demojavaproject.bat
[wagner@Unknown demojavaproject]$ total 8
drwxr-xr-x. 2 wagner wagner 4096 fev  3 15:22 bin
drwxr-xr-x. 2 wagner wagner 4096 fev  3 15:22 lib
total 12
-rwxr-xr-x. 1 wagner wagner 5504 fev  3 15:22 demojavaproject
-rwxr-xr-x. 1 wagner wagner 2496 fev  3 15:22 demojavaproject.bat
[wagner@Unknown bin]$ /home/wagner/wagnerdocri@gmail.com3/envs/env-dev/sources/somewritings/gradle-introduction/projetos/demojavaproj/build/distributions/demojavaproject/bin
[wagner@Unknown demojavaproject]$ total 2928
-rw-rw-r--. 1 wagner wagner    3482 jan  5 22:51 animal-sniffer-annotations-1.14.jar
-rw-rw-r--. 1 wagner wagner  193322 fev  3 13:10 checker-qual-2.5.2.jar
-rw-rw-r--. 1 wagner wagner    1064 fev  3 15:22 demojavaproject.jar
-rw-rw-r--. 1 wagner wagner   13704 fev  3 13:10 error_prone_annotations-2.1.3.jar
-rw-rw-r--. 1 wagner wagner 2740721 fev  3 13:10 guava-26.0-jre.jar
-rw-rw-r--. 1 wagner wagner    8764 jan  5 22:51 j2objc-annotations-1.1.jar
-rw-rw-r--. 1 wagner wagner   19936 fev  3 13:10 jsr305-3.0.2.jar
</pre>


<p>
Pessoal, vamos lá compreender nosso build&#x2026;
Unzipei o projeto que gerou uma pasta do proje com o diretório bin
e o diretório lib
O diretório bin tem dois arquivos um bat e ouhtro pra executar no
linux.
A pasta lib tem alguns jars de que nosso projeto depende e muito
interessante tem o demojavaproject.jar
Cada um deles, obviamente, tem sua razão de estar alí. Não vou
entrar em cada um mas vou passar uns links&#x2026;
</p>

<ul class="org-ul">
<li><p>
jsr305-3.0.2.jar
</p>

<p>
Disponibiliza anotações para qualidade de código
<a href="https://www.infoq.com/news/2008/06/jsr-305-update">https://www.infoq.com/news/2008/06/jsr-305-update</a>
<a href="https://www.youtube.com/watch?v=J2fgb8nWUo8">https://www.youtube.com/watch?v=J2fgb8nWUo8</a>
</p></li>

<li><p>
animal-sniffer-annotations-1.14.jar
</p>

<p>
Útil qdo vc tem código de uma versão do java que precisa rodar em
uma versão diferente que sem o animal-siffer seria incompatível.
<a href="https://www.baeldung.com/maven-animal-sniffer">https://www.baeldung.com/maven-animal-sniffer</a>
</p></li>

<li><p>
checker-qual-2.5.2.jar
</p>

<p>
Ferramenta de qualidade de código
<a href="https://checkerframework.org/manual/#installation">https://checkerframework.org/manual/#installation</a>
</p></li>

<li>demojavaproject.jar
Esse é o jar do nosso projeto. Infelizmente o gradle não
configurou ele pra ser um executável, conforme demostra o código
abaixo.
Entretanto, o gradle te dá maneiras que, a meu veu, eles acham
que é mais prática pra executar o seu projeto que são os arquivos
executáveis que a gente já viu anteriormente neste texto.</li>
</ul>
<div class="org-src-container">
<pre class="src src-shell" id="org103cfd8"><span style="color: #ff7f24;">#</span><span style="color: #ff7f24;">starts code</span>
<span style="color: #b0c4de;">cd</span> $<span style="color: #eedd82;">GRADLE_PROJECTS_DIR</span>/demojavaproj/build/distributions/demojavaproject/lib
java -jar demojavaproject.jar
</pre>
</div>

<pre class="example">

[wagner@Unknown lib]$ nenhum atributo de manifesto principal em demojavaproject.jar

</pre>

<ul class="org-ul">
<li>error<sub>prone</sub><sub>annotations</sub>-2.1.3.jar
Análise estática do código pra melhora da qualidade. Tem um
exemplo fácil de entendem em <a href="https://github.com/google/error-prone">https://github.com/google/error-prone</a></li>
</ul>


<ul class="org-ul">
<li>guava-26.0-jre.jar
Esse jar é uma biblioteca do criada pela google pra facilitar
algumas tarefas em java com collections etc.
Esse link abaixo mostra como se configura ela no seu projeto    
<a href="https://github.com/google/guava/wiki/UseGuavaInYourBuild">https://github.com/google/guava/wiki/UseGuavaInYourBuild</a></li>
</ul>


<ul class="org-ul">
<li>j2objc-annotations-1.1.jar
Esse é o site do projeto desse jar:
<a href="https://developers.google.com/j2objc/">https://developers.google.com/j2objc/</a>
A utilidade desse jar é transformar código java em código
objective-C atraves de seus comandos. Como a gente não vai
desenvolver pra IOS não vamos usar essa biblioteca na prática.</li>
</ul>



<p>
Vamos dar uma olhada nos arquivos do diretório bin primeiro, o .bat
Abaixo segue o arquivo, parece meio complicadinho mas a gente não
vei editar ele pra nada, a gente só vai usar pra executar nosso
programa. Se tiver curiosidade, dá uma olhada nele depois.
</p>

<p>
Agora o outro pra ser executado no linux
Mesma coisa, vc não precisa entender shellscript pra executar ele
certo? No futuro estude shellscript que vale a pena&#x2026;   Depois vc
pode dar uma olhada nele também.
</p>
</div>

<div id="outline-container-org29c80c9" class="outline-3">
<h3 id="org29c80c9"><span class="section-number-3">5.1</span> Executando o nosso programa</h3>
<div class="outline-text-3" id="text-5-1">
<p>
Bom vamos executar nosso programa então&#x2026;
</p>

<div class="org-src-container">
<pre class="src src-shell" id="orgb7870af"><span style="color: #ff7f24;">#</span><span style="color: #ff7f24;">starts code</span>
<span style="color: #b0c4de;">cd</span> $<span style="color: #eedd82;">GRADLE_PROJECTS_DIR</span>/demojavaproj/build/distributions/demojavaproject/bin
./demojavaproject
</pre>
</div>

<pre class="example">

[wagner@Unknown bin]$ Hello world.

</pre>

<p>
Executando esse arquivo dá pra perceber que o programa foi
executado.
</p>


<p>
To me sentindo culpado por não ter rodado o teste antes, mas
eis aí.. Na nossa disciplina sobre qualidade de software vcs vão
entender o por quê?
</p>

<div class="org-src-container">
<pre class="src src-shell" id="orge2b61d6"><span style="color: #ff7f24;">#</span><span style="color: #ff7f24;">starts code</span>
<span style="color: #b0c4de;">cd</span> $<span style="color: #eedd82;">GRADLE_PROJECTS_DIR</span>/demojavaproj
./gradlew test
</pre>
</div>

<pre class="example">
   [wagner@Unknown demojavaproj]$ ./gradlew test
&gt; Task :compileJava UP-TO-DATE
&gt; Task :processResources NO-SOURCE
&gt; Task :classes UP-TO-DATE
&gt; Task :compileTestJava UP-TO-DATE
&gt; Task :processTestResources NO-SOURCE
&gt; Task :testClasses UP-TO-DATE
&gt; Task :test UP-TO-DATE

BUILD SUCCESSFUL in 0s
3 actionable tasks: 3 up-to-date
[wagner@Unknown demojavaproj]$ 
</pre>

<p>
Claro que a gente vai escrever muitos testes na nossa disciplina,
neste momento a agente apenas rodou esse né&#x2026; daqui a pouco a
gente vai estudar e modifcar esse teste.
</p>

<p>
Tem um relatório dos testes em html, vamos ver?
</p>



<div class="org-src-container">
<pre class="src src-shell" id="orge99c589"><span style="color: #ff7f24;">#</span><span style="color: #ff7f24;">starts code</span>
firefox /home/wagner/wagnerdocri@gmail.com3/envs/env-dev/sources/somewritings/gradle-introduction/projetos/demojavaproj/build/reports/tests/test/index.html
</pre>
</div>
</div>
</div>
</div>

<div id="outline-container-org7e8cf4a" class="outline-2">
<h2 id="org7e8cf4a"><span class="section-number-2">6</span> Fluxo de trabalho dom o gradle</h2>
<div class="outline-text-2" id="text-6">
<p>
Quando vc tiver trabalhando com o seu projeto que usa gradle as taks
que vc usará em geral são;
gradle clean, pra limpar tudo que tiver sido construído
gradle build pra buildar
gradle test pra testar
gradle run pra rodar 
gradle distZip pra gerar um zip do projeto 
</p>
</div>
</div>


<div id="outline-container-orgabe9ec2" class="outline-2">
<h2 id="orgabe9ec2"><span class="section-number-2">7</span> Tasks do gradle</h2>
<div class="outline-text-2" id="text-7">
<p>
O que vem depois do gradle&#x2026; o clean o init o build etc&#x2026; são
tasks do gradle
</p>

<p>
O comando gradle tasks mostra as tasks que estão disponíveis pra vc
utilizar.
</p>


<div class="org-src-container">
<pre class="src src-shell" id="org9eed51c">      <span style="color: #ff7f24;">#</span><span style="color: #ff7f24;">starts code</span>
      [wagner@Unknown demojavaproj]$ gradle tasks

&gt; Task :tasks

------------------------------------------------------------
Tasks runnable from root project
------------------------------------------------------------

Application tasks
-----------------
run - Runs this project as a JVM application

Build tasks
-----------
assemble - Assembles the outputs of this project.
build - Assembles and tests this project.
buildDependents - Assembles and tests this project and all projects that depend on it.
buildNeeded - Assembles and tests this project and all projects it depends on.
classes - Assembles main classes.
clean - Deletes the build directory.
jar - Assembles a jar archive containing the main classes.
testClasses - Assembles test classes.

Build Setup tasks
-----------------
init - Initializes a new Gradle build.
wrapper - Generates Gradle wrapper files.

Distribution tasks
------------------
assembleDist - Assembles the main distributions
distTar - Bundles the project as a distribution.
distZip - Bundles the project as a distribution.
installDist - Installs the project as a distribution as-is.

Documentation tasks
-------------------
javadoc - Generates Javadoc API documentation for the main source code.

Help tasks
----------
buildEnvironment - Displays all buildscript dependencies declared<span style="color: #00ffff;"> in</span> root project <span style="color: #ffa07a;">'demojavaproject'</span>.
components - Displays the components produced by root project <span style="color: #ffa07a;">'demojavaproject'</span>. [incubating]
dependencies - Displays all dependencies declared<span style="color: #00ffff;"> in</span> root project <span style="color: #ffa07a;">'demojavaproject'</span>.
dependencyInsight - Displays the insight into a specific dependency<span style="color: #00ffff;"> in</span> root project <span style="color: #ffa07a;">'demojavaproject'</span>.
dependentComponents - Displays the dependent components of components<span style="color: #00ffff;"> in</span> root project <span style="color: #ffa07a;">'demojavaproject'</span>. [incubating]
<span style="color: #b0c4de;">help</span> - Displays a help message.
model - Displays the configuration model of root project <span style="color: #ffa07a;">'demojavaproject'</span>. [incubating]
projects - Displays the sub-projects of root project <span style="color: #ffa07a;">'demojavaproject'</span>.
properties - Displays the properties of root project <span style="color: #ffa07a;">'demojavaproject'</span>.
tasks - Displays the tasks runnable from root project <span style="color: #ffa07a;">'demojavaproject'</span>.

Verification tasks
------------------
check - Runs all checks.
<span style="color: #b0c4de;">test</span> - Runs the unit tests.

Rules
-----
Pattern: clean&lt;TaskName&gt;: Cleans the output files of a task.
Pattern: build&lt;ConfigurationName&gt;: Assembles the artifacts of a configuration.
Pattern: upload&lt;ConfigurationName&gt;: Assembles and uploads the artifacts belonging to a configuration.

To see all tasks and more detail, run gradle tasks --all

To see more detail about a task, run gradle help --task &lt;task&gt;

BUILD SUCCESSFUL<span style="color: #00ffff;"> in</span> 0s
1 actionable task: 1 executed
[wagner@Unknown demojavaproj]$ 

</pre>
</div>

<p>
Tem bastante né? Com o tempo a gente vai se acostumando com as
funcionalidades de cada uma. A verdade é que elas é que salvam a
patria qdo vc tiver enroscado com alguma questão específica do seu
projeto. Isso vai acontecer quando vc tiver trabalhando na área&#x2026;
</p>
</div>
</div>


<div id="outline-container-org62a13b2" class="outline-2">
<h2 id="org62a13b2"><span class="section-number-2">8</span> Referencias</h2>
<div class="outline-text-2" id="text-8">
<p>
tarfileWikiPedia <a href="https://pt.wikipedia.org/wiki/Tar_(computa%C3%A7%C3%A3o)">https://pt.wikipedia.org/wiki/Tar_(computação)</a>
gradleCodsInitPlugin <a href="https://docs.gradle.org/current/userguide/build_init_plugin.html">https://docs.gradle.org/current/userguide/build_init_plugin.html</a>
<a href="http://professorramos.com/index.php/script-bat-2-como-criar-um-menu-em-arquivos-bat/">http://professorramos.com/index.php/script-bat-2-como-criar-um-menu-em-arquivos-bat/</a>
</p>
</div>
</div>
