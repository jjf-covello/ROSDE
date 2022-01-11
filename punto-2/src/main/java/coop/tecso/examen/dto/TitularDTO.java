package coop.tecso.examen.dto;

import coop.tecso.examen.model.titular.Titular;

public class TitularDTO {
    private String RUT;

    public TitularDTO(String rut) {
        this.RUT = rut;
    }

    public String getRUT() {
        return RUT;
    }

    public void setRUT(String RUT) {
        this.RUT = RUT;
    }

    public TitularDTO() {
    }

    public static TitularDTO GenerateFrom(Titular titular) {
        return new TitularDTO(titular.getRUT());
    }
}
