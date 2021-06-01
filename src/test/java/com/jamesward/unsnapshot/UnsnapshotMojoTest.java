package com.jamesward.unsnapshot;

import org.apache.maven.plugin.testing.AbstractMojoTestCase;

import java.io.File;

public class UnsnapshotMojoTest extends AbstractMojoTestCase {

    protected void setUp() throws Exception {
        super.setUp();
    }

    public void testWithSnapshot() throws Exception {
        File testPom = getTestFile("src/test/resources/with-snapshot/pom.xml");
        assertNotNull(testPom);
        assertTrue(testPom.exists());

        UnsnapshotMojo mojo = (UnsnapshotMojo) lookupMojo("unsnapshot", testPom);
        assertNotNull(mojo);

        mojo.execute();

        assertEquals("0.0.0", mojo.project.getModel().getProperties().getProperty(UnsnapshotMojo.VERSION_UNSNAPSHOT));
        assertEquals("0.0", mojo.project.getModel().getProperties().getProperty(UnsnapshotMojo.VERSION_NOPATCH));
    }

    public void testNonSnapshot() throws Exception {
        File testPom = getTestFile("src/test/resources/non-snapshot/pom.xml");
        assertNotNull(testPom);
        assertTrue(testPom.exists());

        UnsnapshotMojo mojo = (UnsnapshotMojo) lookupMojo("unsnapshot", testPom);
        assertNotNull(mojo);

        mojo.execute();

        assertEquals("0.0.0", mojo.project.getModel().getProperties().getProperty(UnsnapshotMojo.VERSION_UNSNAPSHOT));
        assertEquals("0.0", mojo.project.getModel().getProperties().getProperty(UnsnapshotMojo.VERSION_NOPATCH));
    }

    public void testWithRevision() throws Exception {
        File testPom = getTestFile("src/test/resources/with-revision/pom.xml");
        assertNotNull(testPom);
        assertTrue(testPom.exists());

        UnsnapshotMojo mojo = (UnsnapshotMojo) lookupMojo("unsnapshot", testPom);
        assertNotNull(mojo);

        mojo.execute();

        assertEquals("0.0.0", mojo.project.getModel().getProperties().getProperty(UnsnapshotMojo.VERSION_UNREVISE));
        assertEquals("0.0", mojo.project.getModel().getProperties().getProperty(UnsnapshotMojo.VERSION_NOPATCH));
    }

}
