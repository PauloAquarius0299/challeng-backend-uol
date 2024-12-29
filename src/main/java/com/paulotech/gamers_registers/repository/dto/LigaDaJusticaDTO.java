package com.paulotech.gamers_registers.repository.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "liga_da_justica")
public record LigaDaJusticaDTO(
        @JacksonXmlProperty(localName = "codinomes")
        CodinomeDTO codinomes
) implements CodinomeDTO {
    @Override
    public List<String> getCodinomes() {
        return codinomes.getCodinomes();
    }
}
record CodinomesDTO(
        @JacksonXmlElementWrapper(useWrapping = false)
        @JacksonXmlProperty(localName = "codinome")
        List<String> codinomes
){}