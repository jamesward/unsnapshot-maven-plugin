package com.jamesward.unsnapshot;

import org.apache.maven.plugin.testing.stubs.MavenProjectStub;

public class RevisionProjectStub extends MavenProjectStub {

    public RevisionProjectStub() {
        setGroupId("foo");
        setArtifactId("bar");
        setVersion("0.0.0-1-SNAPSHOT");
        setName("foobar");
    }

}
