package com.sparta.memo.dto;

import com.sparta.memo.entity.Memo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class MemoResponseDto {
    private Long id;
    private String username;
    private String contents;
    private LocalDateTime createAt;
    private LocalDateTime modiFiedAt;

    public MemoResponseDto(Memo memo) {
        this.id= memo.getId();
        this.username= memo.getUsername();
        this.contents= memo.getContents();
        this.createAt= memo.getCreatedAt();
        this.modiFiedAt= memo.getModifiedAt();
    }

}
