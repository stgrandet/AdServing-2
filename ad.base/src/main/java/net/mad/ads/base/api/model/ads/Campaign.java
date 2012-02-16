/**
 * Mad-Advertisement
 * Copyright (C) 2011 Thorsten Marx <thmarx@gmx.net>
 *
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package net.mad.ads.base.api.model.ads;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.mad.ads.base.api.model.BaseModel;
import net.mad.ads.base.api.model.ExtendedBaseModel;
import net.mad.ads.base.api.model.ads.condition.DateCondition;
import net.mad.ads.base.api.model.ads.condition.TimeCondition;
import net.mad.ads.db.definition.ConditionDefinition;
import net.mad.ads.db.enums.ConditionDefinitions;

/**
 * Die Kampagne ist das Mutter-Objekt der Banner. Jedes
 * Banner liegt in einer Kampagne und übernimmt die Einstellung, die dort 
 * gemacht werden. So können Bedingung, wann die Banner angezeigt werden sollen
 * global konfiguriert werden.
 * 
 * 
 * @author thorsten
 *
 */
public class Campaign extends ExtendedBaseModel {
	
	/*
	 * The times this campaign is valid
	 */
	private Set<TimeCondition> timeConditions = new HashSet<TimeCondition>();
	/*
	 * The dates this campaign is valid
	 */
	private Set<DateCondition> dateConditions = new HashSet<DateCondition>();

	
	public Campaign () {
		
	}


	/**
	 * @return the timeConditions
	 */
	public Set<TimeCondition> getTimeConditions() {
		return timeConditions;
	}


	/**
	 * @param timeConditions the timeConditions to set
	 */
	public void setTimeConditions(Set<TimeCondition> timeConditions) {
		this.timeConditions = timeConditions;
	}


	/**
	 * @return the dateConditions
	 */
	public Set<DateCondition> getDateConditions() {
		return dateConditions;
	}


	/**
	 * @param dateConditions the dateConditions to set
	 */
	public void setDateConditions(Set<DateCondition> dateConditions) {
		this.dateConditions = dateConditions;
	}
	
	
	
	
	
	
}