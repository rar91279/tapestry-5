// Copyright 2007, 2008, 2011 The Apache Software Foundation
//
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

package org.apache.tapestry5.integration.app1.pages;

import org.apache.tapestry5.MarkupWriter;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Grid;
import org.apache.tapestry5.integration.app1.data.Track;
import org.apache.tapestry5.integration.app1.services.MusicLibrary;
import org.apache.tapestry5.ioc.annotations.Inject;

import java.util.List;

public class GridDemo
{
    @Inject
    private MusicLibrary library;

    @Property
    private Track track;

    @InjectComponent
    private Grid grid;

    public List<Track> getTracks()
    {
        return library.getTracks();
    }

    void onActionFromReset()
    {
        grid.reset();
    }

    void onActionFromSortRating()
    {
        grid.getSortModel().updateSort("rating");
    }
    
//    public void afterRender(MarkupWriter writer)
//    {
//        writer.getDocument().find("html/body").elementAt(1, "p").text("bbbbb");
//    }
}
