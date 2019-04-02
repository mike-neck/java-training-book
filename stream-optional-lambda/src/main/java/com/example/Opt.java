/*
 * Copyright 2019 Shinya Mochida
 *
 * Licensed under the Apache License,Version2.0(the"License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,software
 * Distributed under the License is distributed on an"AS IS"BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example;

import java.util.Map;
import java.util.Optional;

class Opt {

  private final String name;

  private final Map<String, String> map =
      Map.of("本隊", "石田三成",
          "奥羽本隊", "上杉景勝",
          "大津城攻撃部隊", "毛利元康",
          "田辺城攻撃部隊", "小野木重勝",
          "美濃・尾張守備隊", "織田秀信",
          "大阪城留守居", "豊臣秀頼"
      );

  Opt(String name) {
    this.name = name;
  }

  Optional<String> name() {
    throw new UnsupportedOperationException("not implemented");
  }

  Optional<String> teamName() {
    throw new UnsupportedOperationException("not implemented");
  }

  Optional<String> fromMap(final String key) {
    throw new UnsupportedOperationException("not implemented");
  }
}
