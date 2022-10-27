package ru.mse.service.Dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.mse.service.Models.Person;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PersonDaoJdbs implements PersonDAO{
    private final NamedParameterJdbcOperations jdbs;

    public PersonDaoJdbs(NamedParameterJdbcOperations jdbs) {
        this.jdbs = jdbs;
    }

    @Override
    public List<Person> notEva(){
        return jdbs.query("select * from PalEvaRemd where Palliative='true' and DateAnd=''", new PersonMapper());
    }
    @Override
    public List<Person> ErrorDays(){
        return jdbs.query("select * from PalEvaRemd where Palliative='true' and error='more than 3 days'", new PersonMapper());
    }

    @Override
    public List<Person> ErrorNotes(){
        return jdbs.query("select * from PalEvaRemd where Palliative='true' and errorNotes='Not notes'", new PersonMapper());
    }

    private static class PersonMapper implements RowMapper<Person> {
        @Override
        public Person mapRow(ResultSet rs, int rowNum) throws SQLException {

            return Person.builder()
                    .Id(rs.getInt("Id"))
                    .RemdId(rs.getString("RemdId"))
                    .Palliative(rs.getString("Palliative"))
                    .DateRemd(rs.getString("DateRemd"))
                    .DateEva(rs.getString("DateEva"))
                    .DateAnd(rs.getString("DateAnd"))
                    .Days(rs.getInt("Days"))
                    .Bool(rs.getString("Bool"))
                    .Snils(rs.getString("Snils"))
                    .error(rs.getString("error"))
                    .SpecialNotesXml(rs.getString("errorNotes"))
                    .Buro(rs.getString("Buro"))
                    .build();
        }
    }
}
