/*
 * Copyright 2011 the original author or authors.
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
package org.gradle.api.internal.artifacts

import spock.lang.Specification
import static org.gradle.util.Matchers.strictlyEqual

class DefaultResolvedModuleIdTest extends Specification {
    def "has useful toString()"() {
        def module = new DefaultResolvedModuleId("group", "module", "version")

        expect:
        module.toString() == "[group: group, module: module, version: version]"
    }

    def "ids are equal when group, module and version are equal"() {
        def module = new DefaultResolvedModuleId("group", "module", "version")
        def same = new DefaultResolvedModuleId("group", "module", "version")
        def differentGroup = new DefaultResolvedModuleId("other", "module", "version")
        def differentModule = new DefaultResolvedModuleId("group", "other", "version")
        def differentVersion = new DefaultResolvedModuleId("group", "module", "other")

        expect:
        module strictlyEqual(same)
        module != differentGroup
        module != differentModule
        module != differentVersion
    }
}
