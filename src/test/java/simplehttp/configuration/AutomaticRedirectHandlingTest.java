/*
 * Copyright (c) 2011-2019, simple-http committers
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package simplehttp.configuration;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Test;

public class AutomaticRedirectHandlingTest {

    private final Mockery context = new JUnit4Mockery();
    private final Configurable<Boolean> configurable = context.mock(Configurable.class);

    @Test
    public void configuresRedirectHandling() {
        AutomaticRedirectHandling redirectHandling = AutomaticRedirectHandling.on();
        context.checking(new Expectations() {{
            oneOf(configurable).setTo(true);
        }});
        redirectHandling.applyTo(configurable);
    }

    @Test
    public void disablesRedirectHandling() {
        AutomaticRedirectHandling redirectHandling = AutomaticRedirectHandling.off();
        context.checking(new Expectations() {{
            oneOf(configurable).setTo(false);
        }});
        redirectHandling.applyTo(configurable);
    }
}
