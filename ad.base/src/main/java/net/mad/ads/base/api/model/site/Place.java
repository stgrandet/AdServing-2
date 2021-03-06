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
package net.mad.ads.base.api.model.site;

import net.mad.ads.base.api.model.ExtendedBaseModel;

/**
 * Ein Place ist die kleinste Einheit um eine Zone weiter 
 * zu unterteilen
 * 
 * Beispiele:
 * - Header
 * - Footer
 * - rechter Bereich
 * 
 * @author thorsten
 *
 */
public class Place extends ExtendedBaseModel {
	
	/*
	 * the parent site this place is in
	 */
	private Site site;
	
	public Place () {
		
	}

	/**
	 * @return the site
	 */
	public Site getSite() {
		return site;
	}

	/**
	 * @param site the site to set
	 */
	public void setSite(Site site) {
		this.site = site;
	}
	
	

}
