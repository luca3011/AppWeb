package it.unibo.paw.dao;

import java.util.List;

import it.unibo.paw.dto.PiattoDTO;
import it.unibo.paw.dto.RistoranteDTO;

public class Db2RistoranteDTOProxy extends RistoranteDTO {

    public Db2RistoranteDTOProxy()
    {
        super();
    }



    @Override
    public List<PiattoDTO> getPiatti() {
        return 0;
    }
    
}
