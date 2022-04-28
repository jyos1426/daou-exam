package com.example.demo.repository;

import java.util.List;
import com.example.demo.vo.City;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class CityRepository {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public CityRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<City> findList() {
        String sql = "select * from city limit 1000";
        System.out.println(sql);

        log.debug("query : {}", sql);

        RowMapper<City> cityMapper = (rs, rowNum) -> {
            City city = new City();
            city.setId(rs.getInt("ID"));
            city.setName(rs.getString("Name"));
            city.setCountryCode(rs.getString("CountryCode"));
            city.setDistrict(rs.getString("District"));
            city.setPopulation(rs.getInt("Population"));
            return city;
        };
        System.out.println(cityMapper);

        return namedParameterJdbcTemplate.query(sql, new MapSqlParameterSource(), cityMapper);
    }
}
