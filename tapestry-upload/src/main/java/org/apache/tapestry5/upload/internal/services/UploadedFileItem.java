// Copyright 2007, 2008 The Apache Software Foundation
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

package org.apache.tapestry5.upload.internal.services;

import org.apache.commons.fileupload2.core.*;
import org.apache.commons.io.FilenameUtils;
import org.apache.tapestry5.upload.services.UploadedFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.*;

/**
 * Implentation of {@link org.apache.tapestry5.upload.services.UploadedFile} for FileItems.
 */
public class UploadedFileItem implements UploadedFile
{
    private final FileItem item;

    public UploadedFileItem(FileItem item)
    {
        this.item = item;
    }

    @Override
    public String getContentType()
    {
        return item.getContentType();
    }

    @Override
    public String getFileName()
    {
        return FilenameUtils.getName(getFilePath());
    }

    @Override
    public String getFilePath()
    {
        return item.getName();
    }

    @Override
    public long getSize()
    {
        return item.getSize();
    }

    @Override
    public InputStream getStream()
    {
        try
        {
            return item.getInputStream();
        }
        catch (IOException e)
        {
            throw new RuntimeException(UploadMessages.unableToOpenContentFile(this), e);
        }
    }

    @Override
    public boolean isInMemory()
    {
        return item.isInMemory();
    }

    @Override
    public void write(File file)
    {
        try
        {
            item.write(file.toPath());
        }
        catch (Exception e)
        {
            throw new RuntimeException(UploadMessages.writeFailure(file), e);
        }
    }

    public void cleanup()
    {
        try
        {
            item.delete();
        }
        catch (IOException e)
        {
            // ignore
        }
    }
    /** Gets the Path for the FileItem's data's temporary location on the disk. Note that for FileItems that have their data stored in memory, this method will return null. When handling large files, you can use Files.move(Path, Path, CopyOption...) to move the file to new location without copying the data, if the source and destination locations reside within the same logical volume.
     *  Returns:
     *  The data file, or null if the data is stored in memory.
     */
    public Path getPath() {
        return ((DiskFileItem)item).getPath();
    }
}
