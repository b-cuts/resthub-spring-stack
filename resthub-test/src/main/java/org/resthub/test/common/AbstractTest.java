package org.resthub.test.common;

import org.junit.runner.RunWith;
import org.resthub.test.context.ResthubXmlContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Base class for your non transactional Spring aware unit tests
 * ContextConfiguration is preconfigured to scan your applicationContext.xml
 * files from classpath
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = ResthubXmlContextLoader.class, locations = { "classpath*:resthubContext.xml",
        "classpath*:applicationContext.xml" })
public abstract class AbstractTest {

}