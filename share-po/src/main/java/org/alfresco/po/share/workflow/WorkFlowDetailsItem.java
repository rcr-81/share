/*
 * #%L
 * share-po
 * %%
 * Copyright (C) 2005 - 2016 Alfresco Software Limited
 * %%
 * This file is part of the Alfresco software. 
 * If the software was purchased under a paid Alfresco license, the terms of 
 * the paid license agreement will prevail.  Otherwise, the software is 
 * provided under the following open source license terms:
 * 
 * Alfresco is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * Alfresco is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with Alfresco. If not, see <http://www.gnu.org/licenses/>.
 * #L%
 */
package org.alfresco.po.share.workflow;

import org.alfresco.po.share.FactoryPage;
import org.alfresco.po.share.ShareLink;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Representation of WorkFlow Item on Workflow details page
 * 
 * @author Ranjith Manyam
 * @since 1.9.0
 */
public class WorkFlowDetailsItem
{
    private String itemName;
    private ShareLink itemNameLink;
    private String description;
    private DateTime dateModified;

    private static final By ITEM_NAME = By.cssSelector("h3.name");
    private static final By ITEM_NAME_LINK = By.cssSelector("h3.name a");
    private static final By ITEM_DESCRIPTION = By.cssSelector("div.description");
    private static final By ITEM_DATE_MODIFIED = By.cssSelector("div.viewmode-label");

    public WorkFlowDetailsItem(WebElement element, WebDriver driver, FactoryPage factoryPage)
    {
        itemName = element.findElement(ITEM_NAME).getText();
        description = element.findElement(ITEM_DESCRIPTION).getText().split("Description: ")[1];
        dateModified = DateTimeFormat.forPattern("E d MMM yyyy HH:mm:ss").parseDateTime(element.findElement(ITEM_DATE_MODIFIED).getText().split("on:")[1].trim());
        itemNameLink = new ShareLink(element.findElement(ITEM_NAME_LINK), driver, factoryPage);
    }

    public String getItemName()
    {
        return itemName;
    }

    public String getDescription()
    {
        return description;
    }

    public DateTime getDateModified()
    {
        return dateModified;
    }

    public ShareLink getItemNameLink()
    {
        return itemNameLink;
    }
}
