package com.jamesward.unsnapshot;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Component;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.project.MavenProject;

@Mojo(name = "unsnapshot")
public class UnsnapshotMojo extends AbstractMojo {

    static final String VERSION_UNSNAPSHOT = "version.unsnapshot";
    static final String VERSION_UNREVISE = "version.unrevise";

    @Component
    protected MavenProject project;

    public void execute() throws MojoExecutionException {
        String version = project.getVersion();
        String unsnapshotVersion = version.replaceAll("-SNAPSHOT", "");
        project.getProperties().setProperty(VERSION_UNSNAPSHOT, unsnapshotVersion);
        project.getModel().getProperties().setProperty(VERSION_UNSNAPSHOT, unsnapshotVersion);

        String unreviseVersion = unsnapshotVersion;
        int lastDash = unsnapshotVersion.lastIndexOf("-");
        if (lastDash >= 0) {
            unreviseVersion = unsnapshotVersion.substring(0, lastDash);
        }

        project.getProperties().setProperty(VERSION_UNREVISE, unreviseVersion);
        project.getModel().getProperties().setProperty(VERSION_UNREVISE, unreviseVersion);
    }
}
