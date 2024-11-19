package com.lt.spring.labs.Repo;
import com.lt.spring.labs.entities.Portfolio;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class PortfolioRepositoryImpl implements PortfolioRepository{
    private JdbcTemplate jdbcTemplate;
    public PortfolioRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public void addPortfolio(String name, Long userId) {
        String query = "INSERT INTO portfolios (\"name\", \"user_id\") VALUES(?,?) ";
        jdbcTemplate.update(query,
                new Object[]{name, userId});

    }

    @Override
    public Portfolio getPortfolio(Long id) {
        String query = "SELECT * FROM portfolios WHERE id = ?";
        return jdbcTemplate.queryForObject(query,
                getRowMapper(), id);
    }

    @Override
    public Iterable<Portfolio> getPortfolios() {
        String query = "SELECT \"id\", \"name\", \"user_id\" FROM portfolios";
        return jdbcTemplate.query(query,
                getRowMapper());
    }
    public RowMapper<Portfolio> getRowMapper() {
        return new RowMapper<Portfolio>() {
            @Override
            public Portfolio mapRow(ResultSet rs, int rowNum) throws SQLException {
                Portfolio p = new Portfolio();
                p.setId(rs.getLong("id"));
                p.setName(rs.getString("name"));
                p.setUserId(rs.getLong("user_id"));
                return p;
            }
        };
    }
}
