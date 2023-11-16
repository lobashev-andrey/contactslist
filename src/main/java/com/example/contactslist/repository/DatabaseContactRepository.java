//package com.example.contactslist.repository;
//
//import com.example.contactslist.Contact;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
//import org.springframework.dao.support.DataAccessUtils;
//import org.springframework.jdbc.core.ArgumentPreparedStatementSetter;
//import org.springframework.jdbc.core.BatchPreparedStatementSetter;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapperResultSetExtractor;
//import org.springframework.stereotype.Repository;
//
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.util.List;
//
//@Repository
//@RequiredArgsConstructor
//@ConditionalOnProperty(value = "app.database.source", havingValue = "db")
//@Slf4j
//public class DatabaseContactRepository implements ContactRepository{
//
//    private final JdbcTemplate jdbcTemplate;
//
//    @Override
//    public List<Contact> findAll() {
//        log.debug("Calling DatabaseContactRepository -> findAll");
//        String sql = "SELECT * FROM contacts";
//        return jdbcTemplate.query(sql,new ContactRowMapper());
//    }
//
//    @Override
//    public Contact findById(long id) {
//        log.debug("Calling DatabaseContactRepository -> findById with id: " + id);
//        String sql = "SELECT * FROM contacts WHERE id = ?";
//        Contact contact = DataAccessUtils.singleResult(
//                jdbcTemplate.query(
//                        sql,
//                        new ArgumentPreparedStatementSetter(new Object[] {id}),
//                        new RowMapperResultSetExtractor<>(new ContactRowMapper(), 1)
//                )
//        );
//        return contact;
//    }
//
//    @Override
//    public void saveContact(Contact contact) {
//        log.debug("Calling DatabaseContactRepository -> saveContact with Contact " + contact);
//        String sql = "UPDATE contacts SET firstName = ?, lastName = ?, email = ?, phone = ? WHERE id = ?";
//        jdbcTemplate.update(sql, contact.getFirstName(), contact.getLastName(), contact.getEmail(), contact.getPhone(), contact.getId());
//    }
//
//    @Override
//    public void addContact(Contact contact) {
//        log.debug("Calling DatabaseContactRepository -> addContact " + contact);
//        String sql = "INSERT INTO contacts (id, firstName, lastName, email, phone) VALUES (?, ?, ?, ?, ?)";
//        jdbcTemplate.update(sql, contact.getId(), contact.getFirstName(), contact.getLastName(), contact.getEmail(), contact.getPhone());
//    }
//
//    @Override
//    public void deleteContact(Contact contact) {
//        log.debug("Calling DatabaseContactRepository -> deleteContact" + contact);
//        String sql = "DELETE FROM contacts WHERE id = ?";
//        jdbcTemplate.update(sql, contact.getId());
//
//
//    }
//
//    @Override
//    public void batchUpdate(List<Contact> contacts) {
//        log.debug("Calling DatabaseContactRepository -> batchUpdate");
//        String sql = "INSERT INTO contacts (id, firstName, lastName, email, phone) VALUES (?, ?, ?, ?, ?)";
//        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter(){
//            @Override
//            public void setValues(PreparedStatement ps, int i) throws SQLException {
//                Contact contact = contacts.get(i);
//                ps.setLong(1, contact.getId());
//                ps.setString(2, contact.getFirstName());
//                ps.setString(3, contact.getLastName());
//                ps.setString(4, contact.getEmail());
//                ps.setString(5, contact.getPhone());
//            }
//
//            @Override
//            public int getBatchSize() {
//                return contacts.size() ;
//            }
//        });
//    }
//}
//..