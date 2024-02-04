package com.sparta.memo.service;

import com.sparta.memo.dto.MemoRequestDto;
import com.sparta.memo.dto.MemoResponseDto;
import com.sparta.memo.entity.Memo;
import com.sparta.memo.repository.MemoRepogitory;
import jakarta.transaction.Transactional;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Service
public class MemoService {
    private final MemoRepogitory memoRepogitory;

    public MemoService(MemoRepogitory memoRepogitory) {
        this.memoRepogitory = memoRepogitory;
    }

    // 다른 방법


    public MemoResponseDto createMemo(MemoRequestDto requestDto) {

        // RequestDto -> Entity
        Memo memo = new Memo(requestDto);

        // DB 저장
        Memo saveMemo = memoRepogitory.save(memo);


        // Entity -> ResponseDto
        MemoResponseDto memoResponseDto = new MemoResponseDto(memo);

        return memoResponseDto;
    }


    public List<MemoResponseDto> getMemos() {
        // DB 조회
        return memoRepogitory.findAll().stream().map(MemoResponseDto::new).toList();
    }

    @Transactional
    public Long updateMemo(Long id, MemoRequestDto requestDto) {
        // 해당 메모가 DB에 존재하는지 확인
        Memo memo = findMemo(id);
        if(memo != null) {
            // memo 내용 수정
            memo.update(requestDto);
            return id;
        } else {
            throw new IllegalArgumentException("선택한 메모는 존재하지 않습니다.");
        }
    }



    public Long deleteMemo(Long id) {
        // 해당 메모가 DB에 존재하는지 확인
        Memo memo = findMemo(id);
        if(memo != null) {
            // memo 삭제
            memoRepogitory.delete(memo);


            return id;
        } else {
            throw new IllegalArgumentException("선택한 메모는 존재하지 않습니다.");
        }
    }

    private Memo findMemo(Long id){
        return  memoRepogitory.findById(id).orElseThrow(()->
                new IllegalArgumentException("선택한 메모는 존재하지 않습니다.")
        );
    }


    public List<MemoResponseDto> getMemosByKeyword(String keyword) {

        // DB 조회
        // 메모 내용에 특정 키워드를 포함하는 메모와 modifiedAt 속성을 기준으로 내림차순으로 정렬하는 메서드를 호출하여,
        // 각 메모를 MemoResponseDto 클래스의 객체로 변환하고 이를 스트림으로 처리한 뒤 리스트로 반환하는 코드를 완성하세요.
//        return memoRepogitory.findAllByOrderModifiedDesc().stream().map(MemoResponseDto::new).toList();
        return memoRepogitory.findAllByContentsOrderByModifiedAtDesc(keyword).stream().map(MemoResponseDto::new).toList();
//        return null;
    }


}
