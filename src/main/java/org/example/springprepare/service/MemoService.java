package org.example.springprepare.service;

import org.example.springprepare.dto.MemoRequestDto;
import org.example.springprepare.dto.MemoResponseDto;
import org.example.springprepare.entity.Memo;
import org.example.springprepare.repository.MemoJpaRepository;
import org.example.springprepare.repository.MemoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MemoService {

    private final MemoJpaRepository memoJpaRepository;

    public MemoService(MemoJpaRepository memoJpaRepository) {
        this.memoJpaRepository = memoJpaRepository;
    }

    public MemoResponseDto createMemo(MemoRequestDto requestDto) {
        return new MemoResponseDto(memoJpaRepository.save(new Memo(requestDto)));
    }

    public List<MemoResponseDto> getMemos() {
        return memoJpaRepository.findAll().stream().map(MemoResponseDto::new).toList();
    }

    @Transactional
    public Long updateMemo(Long id, MemoRequestDto requestDto) {
        memoJpaRepository.findById(id).orElseThrow().update(requestDto);
        return id;
    }

    public Long deleteMemo(Long id) {
        memoJpaRepository.delete(memoJpaRepository.findById(id).orElseThrow());
        return id;
    }

    public List<MemoResponseDto> getContents(String content){
        return memoJpaRepository.findAllByContentsContainsOrderByModifiedAtDesc(content).stream().map(MemoResponseDto::new).toList();
    }


}

