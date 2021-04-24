package it.unibo.paw.dao;

import java.util.List;

import it.unibo.paw.dto.PiattoDTO;
import it.unibo.paw.dto.RistoranteDTO;

public class Db2RistoranteDTOProxy extends RistoranteDTO {

    private boolean isLoaded = false;

    public Db2RistoranteDTOProxy() {
        super();
    }

    @Override
    public List<PiattoDTO> getPiatti() {
        if (isAlreadyLoaded())
            return super.getPiatti();
        else {
            RistorantePiattoMappingDAO rpm = new Db2RistorantePiattoMappingDAO();
            isAlreadyLoaded(true);
            return rpm.getPiattiFromRestaurant(this.getId());
        }

    }

    private void isAlreadyLoaded(boolean b) {
        isLoaded = b;
    }

    private boolean isAlreadyLoaded() {
        return isLoaded;
    }

}
