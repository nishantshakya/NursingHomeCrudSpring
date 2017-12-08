package com.siue.nursingHome;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class NursingHomeDAOImpl implements NursingHomeDAO {

    private JdbcTemplate jdbcTemplate;

    // JdbcTemplate setter
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Saving a new NursingHome
    public void saveNursingHome(NursingHome nursingHome) {
        String sql = "insert into nursing_home values(?,?,?,?,?,?)";
        System.out.println("dao called");
        jdbcTemplate.update(sql, new Object[]
                {nursingHome.getProvider_number(),
                        nursingHome.getName(),
                        nursingHome.getPhone_number(),
                        nursingHome.getProvider_type(),
                        nursingHome.getOwnership_type(),
                        nursingHome.getOverall_rating()});
    }

    // Getting a particular NursingHome
    public NursingHome getNursingHomeById(String provider_number) {
        String sql = "select * from nursing_home where provider_number=?";
        NursingHome employee = (NursingHome) jdbcTemplate.queryForObject(sql, new Object[]
                {provider_number}, new RowMapper<NursingHome>() {
            public NursingHome mapRow(ResultSet rs, int rowNum) throws SQLException {
                NursingHome nursingHome = new NursingHome();
                nursingHome.setProvider_number(rs.getString("provider_number"));
                nursingHome.setName(rs.getString("name"));
                nursingHome.setPhone_number(rs.getLong("phone_number"));
                nursingHome.setProvider_type(rs.getString("provider_type"));
                nursingHome.setOwnership_type(rs.getString("ownership_type"));
                nursingHome.setOverall_rating(rs.getInt("overall_rating"));
                return nursingHome;
            }
        });
        return employee;
    }

    // Getting all the Employees
    public List<NursingHome> getAllNursingHomes() {
        String sql = "select * from nursing_home";

        List<NursingHome> employeeList = jdbcTemplate.query(sql, new ResultSetExtractor<List<NursingHome>>() {
            public List<NursingHome> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<NursingHome> list = new ArrayList<NursingHome>();
                while (rs.next()) {
                    NursingHome nursingHome = new NursingHome();
                    nursingHome.setProvider_number(rs.getString("provider_number"));
                    nursingHome.setName(rs.getString("name"));
                    nursingHome.setPhone_number(rs.getLong("phone_number"));
                    nursingHome.setProvider_type(rs.getString("provider_type"));
                    nursingHome.setOwnership_type(rs.getString("ownership_type"));
                    nursingHome.setOverall_rating(rs.getInt("overall_rating"));
                    list.add(nursingHome);
                }
                return list;
            }

        });
        return employeeList;
    }

    public List<Fines> getFinesData(String number, String name, String type, int orating, int srating) {
        String sql = "select p.provider_number, n.provider_type, n.name, p.fines, p.amount_of_fines, s" +
                ".staffing_rating, n.overall_rating from penalty_counts p, nursing_home n, staffing s where " +
                "n.provider_number=s.provider_number and " +
                "n.provider_number=p.provider_number and " +
                "n.name like '%" + name + "%' and " +
                "p.provider_number like '%" + number + "%' and " +
                "n.provider_type like '%" + type + "%' and " +
                "n.overall_rating=" + orating +
                " and s.staffing_rating=" + srating +
                " and p.fines != 0";
        List<Fines> fines = jdbcTemplate.query(sql, new ResultSetExtractor<List<Fines>>() {
            public List<Fines> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<Fines> list = new ArrayList<Fines>();
                while (rs.next()) {
                    Fines nursingHome = new Fines();
                    nursingHome.setName(rs.getString("name"));
                    nursingHome.setNumber(rs.getString("provider_number"));
                    nursingHome.setType(rs.getString("provider_type"));
                    nursingHome.setOrating(rs.getInt("overall_rating"));
                    nursingHome.setFines(rs.getDouble("fines"));
                    nursingHome.setAmountFines(rs.getDouble("amount_of_fines"));
                    nursingHome.setSrating(rs.getInt("staffing_rating"));

                    list.add(nursingHome);
                }
                return list;
            }

        });
        return fines;
    }

    public List<Deficiency> getDeficienyData(String name, int td, int ic) {
        String sql = "select n.name, count(tag_number) as total_deficiencies, d.inspection_cycle from nursing_home n," +
                " deficiency d where " +
                "n.provider_number= d.provider_number and " +
                "d.inspection_cycle=" + ic + " and " +
                "n.name like '%" + name + "%' " +
                "group by n.name " +
                "having count(tag_number)= " + td;
        List<Deficiency> deficiencies = jdbcTemplate.query(sql, new ResultSetExtractor<List<Deficiency>>() {
            public List<Deficiency> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<Deficiency> list = new ArrayList<Deficiency>();
                while (rs.next()) {
                    Deficiency nursingHome = new Deficiency();
                    nursingHome.setName(rs.getString("name"));
                    nursingHome.setInspection_cycle(rs.getInt("inspection_cycle"));
                    nursingHome.setTotal_defiencies(rs.getInt("total_deficiencies"));
                    list.add(nursingHome);
                }
                return list;
            }

        });
        return deficiencies;
    }

    // Updating a particular NursingHome
    @Override
    public void updateNursingHome(NursingHome nursingHome,String id) {
        String sql = "update nursing_home set provider_number =?, name=?,phone_number=? ,provider_type=?," +
                "ownership_type=?,overall_rating=? where " +
                "provider_number=?";
        jdbcTemplate.update(sql, new Object[]
                {nursingHome.getProvider_number(),
                        nursingHome.getName(),
                        nursingHome.getPhone_number(), nursingHome
                        .getProvider_type(),
                        nursingHome.getOwnership_type(),
                        nursingHome.getOverall_rating(),
                        id});
    }

    // Deletion of a particular NursingHome
    public void deleteNursingHome(String provider_number) {
        List<String> tableList = new ArrayList<>(Arrays.asList("nursing_home_address", "survey_summary",
                "deficiency", "quality_measure", "quality_measure_claims", "penalty_counts", "staffing",
                "nursing_home"));
        for (int i = 0; i < tableList.size(); i++) {
            String sql = "delete from " + tableList.get(i) + " where provider_number=?";
            jdbcTemplate.update(sql, new Object[]
                    {provider_number});
        }
    }

    @Override
    public List<TopNursingHome> getStateListSearchData(String state) {
        String query = "select nh.provider_number,nh.name, nh.overall_rating, nha.city " +
                "from nursing_home nh, nursing_home_address nha where " +
                "nh.provider_number=nha.provider_number and " +
                "nha.state=?" +
                "order by nh.overall_rating desc, nh.provider_number desc limit 20;";
        return jdbcTemplate.query(query, new Object[]{state}, new ResultSetExtractor<List<TopNursingHome>>() {
            @Override
            public List<TopNursingHome> extractData(ResultSet resultSet) throws SQLException {
                List<TopNursingHome> topNursingHomes = new LinkedList<>();

                while (resultSet.next()) {
                    TopNursingHome topNursingHome = new TopNursingHome();
                    topNursingHome.setProvider_number(resultSet.getString("provider_number"));
                    topNursingHome.setProvider_name(resultSet.getString("name"));
                    topNursingHome.setOverall_rating(resultSet.getInt("overall_rating"));
                    topNursingHome.setCity(resultSet.getString("city"));
                    topNursingHomes.add(topNursingHome);

                }

                return topNursingHomes;
            }
        });
    }
}
