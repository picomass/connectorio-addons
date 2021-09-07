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
package org.connectorio.addons.profile.quantity.internal.transform;

import javax.measure.Unit;
import org.openhab.core.library.types.DecimalType;
import org.openhab.core.library.types.QuantityType;
import org.openhab.core.transform.TransformationException;
import org.openhab.core.transform.TransformationService;
import org.openhab.core.types.util.UnitUtils;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Helper transformation to turn value into quantity.
 */
@Component(immediate = true, property = {"openhab.transform=QUANTITY"})
public class QuantityTransformationService implements TransformationService {

  private final Logger logger = LoggerFactory.getLogger(QuantityTransformationService.class);

  @Override
  public String transform(String unit, String source) throws TransformationException {
    DecimalType decimalValue = DecimalType.valueOf(source);

    Unit<?> desiredUnit = UnitUtils.parseUnit(unit);
    if (desiredUnit == null) {
      throw new TransformationException("Invalid configuration, " + unit + " is not known");
    }

    logger.debug("Attempting to transform '{}' to quantity value in '{}'", decimalValue, desiredUnit);
    return QuantityType.valueOf(decimalValue.doubleValue(), desiredUnit).toString();
  }

}
