// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package org.apache.tapestry5.ioc.annotations;

import java.lang.annotation.*;


/**
 * Annotation for methods that should be invoked after injection. This occurs last: after constructor injection and
 * after field injection. It should be placed on a <strong>public method</strong>. Any return value from the method is
 * ignored. The order of invocation for classes with multiple marked methods (including methods inherited from
 * super-classes) is not, at this time, defined.
 *
 * Tapestry also honors the {@link jakarta.annotation.PostConstruct} annotation, and treats it identically to
 * PostInjection. This is both more flexible than PostConstruct (in that methods may have parameters, and multiple methods
 * may be annotated) but also falls short (Tapestry will only seek out public methods).
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@UseWith(AnnotationUseContext.SERVICE)
public @interface PostInjection
{
}
