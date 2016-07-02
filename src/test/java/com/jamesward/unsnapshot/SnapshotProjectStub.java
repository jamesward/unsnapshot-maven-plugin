package com.jamesward.unsnapshot;

import org.apache.maven.plugin.testing.stubs.MavenProjectStub;

public class SnapshotProjectStub extends MavenProjectStub {

    public SnapshotProjectStub() {
        setGroupId("foo");
        setArtifactId("bar");
        setVersion("0.0.0-SNAPSHOT");
        setName("foobar");
    }

}
