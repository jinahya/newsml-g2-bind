/*
 * Copyright 2016 Jin Kwon &lt;onacit at gmail.com&gt;.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.jinahya.newsml.g2.bind;

import java.io.File;
import java.io.IOException;
import static java.lang.invoke.MethodHandles.lookup;
import java.net.URISyntaxException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.iptc.std.nar._2006_10_01.ContentSet;
import org.iptc.std.nar._2006_10_01.GroupSet;
import org.iptc.std.nar._2006_10_01.NewsItem;
import org.slf4j.Logger;
import static org.slf4j.LoggerFactory.getLogger;
import org.testng.annotations.Test;

/**
 *
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
public class UnmarshalTest {

    private static final Logger logger = getLogger(lookup().lookupClass());

    @Test
    public void unmarshal()
            throws JAXBException, URISyntaxException, IOException {
        JAXBContext context = JAXBContext.newInstance(
                NewsItem.class, ContentSet.class, GroupSet.class);
        for (File file : new File(getClass().getResource("/").toURI())
                .listFiles(f -> f.isFile() && f.getName().endsWith(".xml"))) {
            logger.debug("file: {}", file);
            final Unmarshaller unmarshaller = context.createUnmarshaller();
            unmarshaller.unmarshal(file);
        }
    }

}
