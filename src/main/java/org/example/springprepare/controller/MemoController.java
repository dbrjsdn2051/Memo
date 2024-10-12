package org.example.springprepare.controller;

import org.example.springprepare.dto.MemoRequestDto;
import org.example.springprepare.dto.MemoResponseDto;
import org.example.springprepare.service.MemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/memos")
public class MemoController {

    @Autowired
    private MemoService memoService;


    @PostMapping()
    public MemoResponseDto createMemo(@RequestBody MemoRequestDto requestDto) {
        // RequestDto -> Entity
        return memoService.createMemo(requestDto);
    }

    @GetMapping()
    public List<MemoResponseDto> getMemos() {
        // DB 조회
        return memoService.getMemos();
    }

    @PutMapping("/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        // 해당 메모가 DB에 존재하는지 확인
        return memoService.updateMemo(id, requestDto);
    }

    @DeleteMapping("/{id}")
    public Long deleteMemo(@PathVariable Long id) {
        // 해당 메모가 DB에 존재하는지 확인
        return memoService.deleteMemo(id);
    }

    @GetMapping("/contents")
    public ResponseEntity<List<MemoResponseDto>> keyword(@RequestParam String keyword){
        return ResponseEntity.ok(memoService.getContents(keyword));
    }
}