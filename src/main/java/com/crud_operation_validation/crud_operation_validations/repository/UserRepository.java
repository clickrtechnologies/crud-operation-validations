package com.crud_operation_validation.crud_operation_validations.repository;


import com.crud_operation_validation.crud_operation_validations.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<User> rowMapper = (rs, rowNum) -> {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setName(rs.getString("name"));
        user.setAge(rs.getInt("age"));
        user.setMobileNumber(rs.getString("mobile_number"));
        user.setEmail(rs.getString("email"));
        user.setAddress(rs.getString("address"));
        return user;
    };

    public int save(User user) {
        return jdbcTemplate.update(
                "INSERT INTO users (name, age, mobile_number, email, address) VALUES (?, ?, ?, ?, ?)",
                user.getName(), user.getAge(), user.getMobileNumber(), user.getEmail(), user.getAddress()
        );
    }

    public List<User> findAll(String sortBy, String filter) {
        String sql = "SELECT * FROM users";
        if (filter != null && !filter.isEmpty()) {
            sql += " WHERE name LIKE ?";
        }
        if (sortBy != null && !sortBy.isEmpty()) {
            sql += " ORDER BY " + sortBy;
        }
        return filter != null ?
                jdbcTemplate.query(sql, rowMapper, "%" + filter + "%") :
                jdbcTemplate.query(sql, rowMapper);
    }

    public User findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM users WHERE id = ?", rowMapper, id);
    }

    public int update(User user) {
        return jdbcTemplate.update(
                "UPDATE users SET name=?, age=?, mobile_number=?, email=?, address=? WHERE id=?",
                user.getName(), user.getAge(), user.getMobileNumber(), user.getEmail(), user.getAddress(), user.getId()
        );
    }

    public int delete(int id) {
        return jdbcTemplate.update("DELETE FROM users WHERE id=?", id);
    }

    public boolean existsByEmailOrMobile(String email, String mobileNumber) {
        Integer count = jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM users WHERE email=? OR mobile_number=?",
                Integer.class, email, mobileNumber
        );
        return count != null && count > 0;
    }
}
