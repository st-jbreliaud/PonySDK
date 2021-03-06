/*
 * Copyright (c) 2011 PonySDK
 *  Owners:
 *  Luciano Broussal  <luciano.broussal AT gmail.com>
 *	Mathieu Barbier   <mathieu.barbier AT gmail.com>
 *	Nicolas Ciaravola <nicolas.ciaravola.pro AT gmail.com>
 *  
 *  WebSite:
 *  http://code.google.com/p/pony-sdk/
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.ponysdk.ui.server.list2.renderer.cell;

import com.ponysdk.core.UIContext;
import com.ponysdk.core.place.Place;
import com.ponysdk.core.place.PlaceChangeRequestEvent;
import com.ponysdk.ui.server.basic.IsPWidget;
import com.ponysdk.ui.server.basic.PAnchor;
import com.ponysdk.ui.server.basic.event.PClickEvent;
import com.ponysdk.ui.server.basic.event.PClickHandler;

public class PlaceChangeCellRenderer extends AbstractCellRenderer<String> {

    private final Place place;

    public PlaceChangeCellRenderer(final Place place) {
        this.place = place;
    }

    @Override
    public IsPWidget render0(final int row, final String value) {
        final PAnchor anchor = new PAnchor(value);
        anchor.addClickHandler(new PClickHandler() {

            @Override
            public void onClick(final PClickEvent event) {
                UIContext.fireEvent(new PlaceChangeRequestEvent(PlaceChangeCellRenderer.this, place));
            }
        });
        return anchor;
    }
}
