# Unsnapshot Maven Plugin

This plugin makes a new property *${version.unsnapshot}* available to your Maven project.
This is useful if you wish to publish your artifacts as SNAPSHOT versions, but the upstream code you're depending on is an official release.

## How to use it ?

Simply add this plugin to your project/build/plugins POM element :
```xml
<plugin>
     <groupId>com.jamesward</groupId>
     <artifactId>unsnapshot-maven-plugin</artifactId>
     <version>0.2</version>
     <executions>
         <execution>
             <phase>initialize</phase>
             <goals><goal>unsnapshot</goal></goals>
         </execution>
     </executions>
</plugin>
```

A new property *${version.unsnapshot}* will be exposed, containing your project version number without any potential **SNAPSHOT** suffix.
