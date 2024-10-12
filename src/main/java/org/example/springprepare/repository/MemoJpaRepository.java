package org.example.springprepare.repository;

import org.example.springprepare.dto.MemoResponseDto;
import org.example.springprepare.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemoJpaRepository extends JpaRepository<Memo, Long> {
    public List<Memo> findAllByContentsContainsOrderByModifiedAtDesc(String contents);
}
