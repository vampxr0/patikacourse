

<h2 id="project-overview">Project Overview</h2>
  <p style="max-width:600px; margin:auto; text-align:center;">
    This project is a complex library management system that allows you to manage book storage, users, and transactions efficiently.
  </p>
</div>

<h1 id="library-management-app">Library Management App</h1>

<h2 id="contents">Contents</h2>
<ul>
  <li><a href="#project-overview">Project Overview</a></li>
  <li><a href="#features">Features</a></li>
  <li><a href="#requirements">Requirements</a></li>
  <li><a href="#how-to-run">How to Build &amp; Run</a></li>
  <li><a href="#contact">Contact</a></li>
</ul>


<h2 id="features">Features</h2>
<ul>
  <li>Add, remove, and track books in various bookcases and shelves.</li>
  <li>Manage users and their permissions.</li>
  <li>Persist data using JSON files.</li>
  <li>Easy-to-use CLI interface.</li>
</ul>

<h2 id="requirements">Requirements</h2>
<ul>
  <li>Java 24 (OpenJDK or Oracle JDK)</li>
  <li>Maven</li>
</ul>

<h2 id="badges">Badges</h2>
<p align="center">
  <img src="https://img.shields.io/badge/java-24.0.1-blue?logo=java&logoColor=white" alt="Java Version" />
  <img src="https://img.shields.io/badge/maven-3.9.4-red?logo=apache-maven&logoColor=white" alt="Maven Version" />
  <img src="https://img.shields.io/badge/gson-2.10.1-green?logo=google&logoColor=white" alt="Gson Version" />
</p>


## How to Build & Run


### Open terminal
### Go to project directory
```bash
cd path/to/your/LibraryManagement
```
### Build the project using Maven
```bash
mvn clean install
```
### Run the project
```bash
mvn exec:java -Dexec.mainClass="Pages.Main"
```





