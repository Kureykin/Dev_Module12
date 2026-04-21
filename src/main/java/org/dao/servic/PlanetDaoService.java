package org.dao.servic;

import org.entity.Planet;

public interface PlanetDaoService {
    public Planet read(String id);
    public void add(Planet planet);
}
