package com.example.inventorymaterial.data.db.repository;


import com.example.inventorymaterial.data.db.dao.SectorDao;
import com.example.inventorymaterial.data.db.model.Sector;

import java.util.ArrayList;

/**
 * Created by usuario on 30/10/17.
 */

public class SectorRepository {
    //Declaracion
    private ArrayList<Sector> sectors;
    private static SectorRepository sectorRepository;
    private SectorDao dao;

    //Inicializacion
    //Inicializar todos los atributos de ámbito statico o de clase
    static {
        sectorRepository = new SectorRepository();
    }

    //El metodo ha de ser privado para garantizar que sólo hay una instancia de Repository
    private SectorRepository() {
        this.sectors = new ArrayList<>();
        dao = new SectorDao();
    }

    public static SectorRepository getInstance() {
        if (sectorRepository == null)
            sectorRepository = new SectorRepository();
        return sectorRepository;
    }

    public int getSectorBy(String name, String shortname){
        for (int i = 0;i<sectors.size();i++){
            if (sectors.get(i).getName().equals(name) && sectors.get(i).getShortname().equals(shortname)){
                return sectors.get(i).get_ID();
            }
        }
        return -1;
    }

    public void editSectorById(int id,String name, String shortname, String description){
        dao.update(new Sector(id,name,shortname,description,1,true,false));
    }
    public void addSector(Sector sector) {
        dao.add(sector);
    }

    public void deleteSector(Sector sector) {
        dao.delete(sector);
    }

    public ArrayList<Sector> getSectors() {
        sectors = dao.loadAll();
        return sectors;
    }
}
