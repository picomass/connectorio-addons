/*
 * Copyright (C) 2019-2021 ConnectorIO Sp. z o.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 */
package org.connectorio.addons.norule.internal.context;

import org.connectorio.addons.norule.Rule;
import org.connectorio.addons.norule.StateDispatcher;
import org.connectorio.addons.norule.ThingActionsRegistry;
import org.connectorio.addons.norule.Trigger;
import org.connectorio.addons.norule.context.ItemStateUpdateContext;
import org.openhab.core.items.ItemRegistry;
import org.openhab.core.types.State;

public class ItemStateUpdateRuleContext extends BaseItemRuleContext implements ItemStateUpdateContext {

  private final State currentState;

  public ItemStateUpdateRuleContext(Rule rule, ItemRegistry itemRegistry, ThingActionsRegistry actionsRegistry,
    StateDispatcher stateDispatcher, Trigger trigger, String itemName, State currentState) {
    super(rule, itemRegistry, actionsRegistry, stateDispatcher, trigger, itemName);
    this.currentState = currentState;
  }

  @Override
  public State currentState() {
    return currentState;
  }

}
