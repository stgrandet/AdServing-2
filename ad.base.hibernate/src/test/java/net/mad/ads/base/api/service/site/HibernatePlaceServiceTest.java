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
package net.mad.ads.base.api.service.site;

import static org.junit.Assert.*;

import java.io.File;
import java.util.List;

import net.mad.ads.base.api.BaseContext;
import net.mad.ads.base.api.model.site.Place;
import net.mad.ads.base.api.model.site.Site;
import net.mad.ads.base.api.service.HibernateService;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HibernatePlaceServiceTest {
	
	private SessionFactory sessionFactory;
	private PlaceService places;
	private SiteService sites;
	
	@Before
	public void  before () throws Exception {
		try {
			File hibernateConfig = new File("src/etc/hibernate.cfg.xml");
			sessionFactory = new Configuration().configure(hibernateConfig).buildSessionFactory();
			
			BaseContext context = new BaseContext();
			context.put(HibernateService.SESSION_FACTORY, sessionFactory);
			
			places = new HibernatePlaceService();
			places.open(context);
			
			sites = new HibernateSiteService();
			sites.open(context);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@After
	public void after () {
		sessionFactory.close();
	}
	

	@Test
	public void testAdd() throws Exception {
		Site s1 = new Site();
		s1.setDescription("seite 1");
		s1.setName("name 1");
		s1.setUrl("http://eins.de");
		sites.add(s1);
		
		
		Place p = new Place();
		p.setDescription("test place");
		p.setName("place1");
		p.setSite(s1);
		places.add(p);
	
		
		p = places.findByPrimaryKey(p.getId());
		
		assertNotNull(p);
		assertEquals("wrong description", "test place", p.getDescription());
		assertEquals("wrong name", "place1", p.getName());
	}

	@Test
	public void testUpdate() throws Exception {
		Site s1 = new Site();
		s1.setDescription("seite 1");
		s1.setName("name 1");
		s1.setUrl("http://eins.de");
		sites.add(s1);
		
		Place p = new Place();
		p.setDescription("test place");
		p.setName("place1");
		p.setSite(s1);
		places.add(p);
	
		p = places.findByPrimaryKey(p.getId());
		
		p.setDescription("demo place");
		p.setName("place 2");
		
		places.update(p);
		
		assertNotNull(p);
		assertEquals("wrong description", "demo place", p.getDescription());
		assertEquals("wrong name", "place 2", p.getName());
	}

	@Test
	public void testDelete() throws Exception {
		Site s1 = new Site();
		s1.setDescription("seite 1");
		s1.setName("name 1");
		s1.setUrl("http://eins.de");
		sites.add(s1);
		
		
		Place p = new Place();
		p.setDescription("test place");
		p.setName("place1");
		p.setSite(s1);
		places.add(p);
	
		
		p = places.findByPrimaryKey(p.getId());
		places.delete(p);
		
		p = places.findByPrimaryKey(p.getId());
		
		assertNull(p);
	}

	@Test
	public void testFindByPrimaryKey() throws Exception {
		Site s1 = new Site();
		s1.setDescription("seite 1");
		s1.setName("name 1");
		s1.setUrl("http://eins.de");
		sites.add(s1);
		
		
		
		Place p = new Place();
		p.setDescription("test place");
		p.setName("place1");
		p.setSite(s1);
		places.add(p);
	
		
		p = places.findByPrimaryKey(p.getId());
		
		assertNotNull(p);
	}

	@Test
	public void testFindAll() throws Exception {
		Site s1 = new Site();
		s1.setDescription("seite 1");
		s1.setName("name 1");
		s1.setUrl("http://eins.de");
		sites.add(s1);
		
		
		
		Place p = new Place();
		p.setDescription("test place");
		p.setName("place1");
		p.setSite(s1);
		places.add(p);		
		
		
		p = new Place();
		p.setDescription("test place");
		p.setName("place1");
		p.setSite(s1);
		places.add(p);
		
		assertEquals("", 2, places.findAll().size());
	}

	@Test
	public void testFindAllIntInt() throws Exception {
		Site s1 = new Site();
		s1.setDescription("seite 1");
		s1.setName("name 1");
		s1.setUrl("http://eins.de");
		sites.add(s1);
		
		
		
		Place p = new Place();
		p.setDescription("test place");
		p.setName("place1");
		p.setSite(s1);
		places.add(p);
		p = new Place();
		p.setDescription("test place");
		p.setName("place2");
		p.setSite(s1);
		places.add(p);
		
		
		
		List<Place> result = places.findAll(1, 1);
		
		assertEquals(1, result.size());
		assertEquals("place1", result.get(0).getName());
		
		result = places.findAll(2, 1);
		
		assertEquals(1, result.size());
		assertEquals("place2", result.get(0).getName());
		
		
		result = places.findAll(1, 2);
		
		assertEquals(2, result.size());
	}

	@Test
	public void testFindBySite() throws Exception {
		Site s1 = new Site();
		s1.setDescription("seite 1");
		s1.setName("name 1");
		s1.setUrl("http://eins.de");
		sites.add(s1);
		
		Site s2 = new Site();
		s2.setDescription("seite 2");
		s2.setName("name 2");
		s2.setUrl("http://zwei.de");
		sites.add(s2);
		
		
		Place p = new Place();
		p.setDescription("test place");
		p.setName("place1");
		p.setSite(s1);
		places.add(p);
		
		p = new Place();
		p.setDescription("test place");
		p.setName("place1");
		p.setSite(s2);
		places.add(p);
		
		List<Place> result = places.findBySite(s1);
		
		assertEquals(1, result.size());
		assertEquals(s1.getId(), result.get(0).getSite().getId());
		
		result = places.findBySite(s2);
		
		assertEquals(1, result.size());
		assertEquals(s2.getId(), result.get(0).getSite().getId());
	}
	
	@Test
	public void testCascade() throws Exception {
		Site s1 = new Site();
		s1.setDescription("seite 1");
		s1.setName("name 1");
		s1.setUrl("http://eins.de");
		sites.add(s1);
		
		Place p = new Place();
		p.setDescription("test place");
		p.setName("place1");
		p.setSite(s1);
		places.add(p);
	
		
		sites.delete(s1);
		
		assertEquals("site note deleted", 0, sites.findAll().size());
		assertEquals("place note deleted", 0, places.findAll().size());
	}

	@Test
	public void testCount() throws Exception {
		Site s1 = new Site();
		s1.setDescription("seite 1");
		s1.setName("name 1");
		s1.setUrl("http://eins.de");
		sites.add(s1);
		
		
		Place p = new Place();
		p.setDescription("test place");
		p.setName("place1");
		p.setSite(s1);
		places.add(p);
	
		
		assertEquals(1, sites.count());
		assertEquals(1, places.count());
	}
}
