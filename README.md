# JaggeryJS java module boilerplate 

![](http://jaggeryjs.org/images/jaglogo.png)

> An boilerplate for build your own jaggery module using Java with WSO2 Custom Host Object.

## Instructions
### 1. Install [Jaggery](http://jaggeryjs.org/) using [this quick start](http://jaggeryjs.org/howto.jag#settingup)

### 2. Create a folder to your module

### 3. Now clone it inside your module folder:
```bash
git clone git@github.com:cesarwbr/boilerplate-jaggery-java-module.git
```

### 4. Compile
There are a lib folder which contains all needed jars, org folder contains Java source, at the root folder of our sample package, there is file named manifest.txt which contains the bundle headers that need to be added. Assuming that you are in the sample directory, please execute the following command (if you are in windows, please replace ":" in the command with ";").
```bash
javac -classpath lib/js-1.7.0.R4.wso2v1.jar:lib/org.jaggeryjs.scriptengine-0.9.0-SNAPSHOT.jar org/jaggeryjs/hostobjects/test/TestHostObject.java
```

### 5. Packaging
Host Objects should reside within an OSGi bundle. A bundle can have many Host Objects. The bundle manifest should contain a header with the class names of its Host Objects.

The headers that need to be added into the bundle manifest in order to act as a bundle can be put in a file and that file can be specified to be used as MANIFEST.MF at the packaging phase of our Java classes using the command below.

```bash
jar cmf <path-to-manifest-file> <bundle-name> <package-root-folder>
```
NOTE: Before using this command you should change your directory to the same directory as your package root directory.

For our sample code, assuming that you are in the samples folder, please execute the following command.

```bash
jar cmf manifest.txt org.jaggeryjs.hostobjects.test.jar org/
```

### 6. Deploying

Copy the above packaged jar or the org.jaggeryjs.hostobjects.test.jar which is in the same directory into the JAGGERY_HOME/carbon/repository/components/dropins directory.

5. Now start Jaggery server:
```bash
sh JAGGERY_HOME/bin/server.sh
```