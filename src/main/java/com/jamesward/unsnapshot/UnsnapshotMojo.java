package com.jamesward.unsnapshot;

import org.apache.maven.model.Model;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Component;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.project.MavenProject;

import java.util.Properties;

@Mojo(name = "unsnapshot")
public class UnsnapshotMojo extends AbstractMojo {

    static final String VERSION_UNSNAPSHOT = "version.unsnapshot";

    @Component
    protected MavenProject project;

    public void execute() throws MojoExecutionException {
        String version = project.getVersion();
        String unsnapshotVersion = version.replaceAll("-SNAPSHOT", "");
        project.getProperties().setProperty(VERSION_UNSNAPSHOT, unsnapshotVersion);
        project.getModel().getProperties().setProperty(VERSION_UNSNAPSHOT, unsnapshotVersion);
        /*
        Model model = project.getModel();
        Properties props = model.getProperties();
        props.setProperty("version.unsnapshot", unsnapshotVersion);
        getLog().info(props.getProperty("version.unsnapshot"));
        model.setProperties(props);
        getLog().info(model.getProperties().getProperty("version.unsnapshot"));
        project.setModel(model);
        getLog().info(project.getProperties().getProperty("version.unsnapshot"));
        getLog().info(project.getModel().getProperties().getProperty("version.unsnapshot"));
        */
    }
}
