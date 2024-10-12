package org.example.springprepare.repository;

import jakarta.persistence.EntityManager;
import org.example.springprepare.dto.MemoRequestDto;
import org.example.springprepare.dto.MemoResponseDto;
import org.example.springprepare.entity.Memo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Repository
public class MemoRepository {

    private final EntityManager em;

    public MemoRepository(EntityManager em) {
        this.em = em;
    }

    public Memo save(Memo memo) {
        em.persist(memo);
        return memo;
    }

    public List<MemoResponseDto> findAll() {
        return em.createQuery("select m.username, m.contents from Memo m", MemoResponseDto.class).getResultList();
    }

    public void update(Long id, MemoRequestDto requestDto) {
        Memo findMemo = em.find(Memo.class, id);
        findMemo.setUsername(requestDto.getUsername());
        findMemo.setContents(requestDto.getContents());
    }

    public void delete(Long id) {
        em.createQuery("delete from Memo m where id = :id", Memo.class)
                .setParameter("id", id)
                .executeUpdate();
    }

    public Memo findByid(Long id) {
        return em.find(Memo.class, id);
    }
}
