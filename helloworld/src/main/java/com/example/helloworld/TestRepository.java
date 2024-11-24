package com.example.helloworld;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

/**
 * リポジトリクラス
 */
@Repository
@RequiredArgsConstructor
public class TestRepository {

    private final NamedParameterJdbcTemplate jdbc;

    /**
     * 検索
     * @return 検索結果
     */
    public String select() {

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT");
        sql.append(" kamoku_name ");
        sql.append("FROM m_test ");
        sql.append("WHERE kamoku_cd = :kamokuCd ");

        Map<String,Object> params =new HashMap<String,Object>();
        params.put("kamokuCd", "100");

        String kamokuName = jdbc.queryForObject(sql.toString(), params, String.class);
        return kamokuName;
    }
}
