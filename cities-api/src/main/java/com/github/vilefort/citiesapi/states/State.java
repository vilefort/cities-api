package com.github.vilefort.citiesapi.states;

import com.github.vilefort.citiesapi.countries.Country;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.List;

@Entity(name = "State")
    @Table(name = "estado")
    @TypeDefs({
            @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
    })
    public class State {

    @Id
        private Long id;

        @Column(name = "nome")
        private String name;

        private String uf;

        private Integer ibge;

    // 1st
  /*  @Column(name = "pais")
    private Integer countryId;*/


        // 2nd - @ManyToOne
        @ManyToOne
        @JoinColumn(name = "pais", referencedColumnName = "id")
        private Country country;

        @Type(type = "jsonb")
        @Basic(fetch = FetchType.LAZY)
        @Column(name = "ddd", columnDefinition = "jsonb")
        private List<Integer> ddd;

        public State() {
        }



        public Long getID() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getUF() {
            return uf;
        }

        public Integer getCodigoIBGe() {
            return ibge;
        }

        public List<Integer> getDDD() {
            return ddd;
        }

        public Country getCountry() {
            return country;
        }

/*  public Integer getCountryId() {
      return countryId;
  }*/

}
