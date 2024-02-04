package com.sparta.memo.controller;


import com.sparta.memo.dto.MemoRequestDto;
import com.sparta.memo.dto.MemoResponseDto;
import com.sparta.memo.entity.Memo;

import com.sparta.memo.service.MemoService;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.web.bind.annotation.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MemoController {

    private final MemoService memoService;

    public MemoController(MemoService memoService) {
        this.memoService = memoService;
    }

    @PostMapping("/memos")
    public MemoResponseDto createMemo(@RequestBody MemoRequestDto requestDto) {
        return memoService.createMemo(requestDto);


    }

    @GetMapping("/memos")
    public List<MemoResponseDto> getMemos() {
//        String keyword = "1";
//        List<MemoResponseDto> lm  = memoService.getMemosByKeyword(keyword);
//        System.out.println(lm);
//        List<MemoResponseDto> l = memoService.getMemosByKeyword("1");
//        System.out.println(l);
        return memoService.getMemos();

    }

    @PutMapping("/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        return memoService.updateMemo(id, requestDto);

    }

    @DeleteMapping("/memos/{id}")
    public Long deleteMemo(@PathVariable Long id) {
        return memoService.deleteMemo(id);

    }

    @GetMapping("/memos/contents")
    public List<MemoResponseDto> getMemosByKeyword(String keyword) {

        // memoService 클래스의 getMemosByKeyword 메서드를 호출하고,
        // keyword라는 변수를 메서드의 매개변수로 전달하는 코드를 완성하세요.
        List<MemoResponseDto> l = memoService.getMemosByKeyword(keyword);
//        System.out.println(l);
        return l;
    }

}
