package org.example.springprepare.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.springprepare.dto.MemoRequestDto;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Memo extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String contents;

    public Memo(MemoRequestDto reqeustDto) {
        this.username = reqeustDto.getUsername();
        this.contents = reqeustDto.getContents();
    }

    public void update(MemoRequestDto memo) {
        this.username = memo.getUsername();
        this.contents = memo.getContents();
    }
}
