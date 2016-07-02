package com.jamesward.unsnapshot;

import org.apache.maven.plugin.testing.stubs.MavenProjectStub;

public class NonSnapshotProjectStub extends MavenProjectStub {

    public NonSnapshotProjectStub() {
        setGroupId("foo");
        setArtifactId("bar");
        setVersion("0.0.0");
        setName("foobar");
    }

}
