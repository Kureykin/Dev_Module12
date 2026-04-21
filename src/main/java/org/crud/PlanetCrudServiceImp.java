package org.crud;

import org.dao.servic.PlanetDaoService;
import org.dao.servic.PlanetDaoServiceImp;
import org.entity.Planet;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernatePlanetUtil;

public class PlanetCrudServiceImp implements PlanetCrudService {

    private PlanetDaoService planetDaoService = new PlanetDaoServiceImp();

    public PlanetCrudServiceImp(PlanetDaoService planetDaoService) {
        this.planetDaoService = planetDaoService;
    }

    public Planet read(String id) {
        return planetDaoService.read(id);
    }
    public void add(Planet planet) {
        planetDaoService.add(planet);
    }
}
