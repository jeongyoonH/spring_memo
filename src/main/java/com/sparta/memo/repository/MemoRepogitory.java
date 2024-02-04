package com.sparta.memo.repository;

import com.sparta.memo.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface MemoRepogitory extends JpaRepository<Memo,Long>{
//    List<Memo> findAllByOrderByModifiedAtDesc();
//    List<Memo> findAllOrderByIdAtDesc();
//    List<Memo> findAllByContentsContainingOrderByIdAtDesc(String keyword);
    List<Memo> findAllByContentsOrderByModifiedAtDesc(String keyword);
//    List<Memo> findAllByKeyword(String content);
}



//
//@Repository
//@Component
//public class MemoRepogitory {
//    private final JdbcTemplate jdbcTemplate;
//
//    public MemoRepogitory(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    public Memo save(Memo memo) {
//        // DB 저장
//        KeyHolder keyHolder = new GeneratedKeyHolder(); // 기본 키를 반환받기 위한 객체
//
//        String sql = "INSERT INTO memo (username, contents) VALUES (?, ?)";
//        jdbcTemplate.update( con -> {
//                    PreparedStatement preparedStatement = con.prepareStatement(sql,
//                            Statement.RETURN_GENERATED_KEYS);
//
//                    preparedStatement.setString(1, memo.getUsername());
//                    preparedStatement.setString(2, memo.getContents());
//                    return preparedStatement;
//                },
//                keyHolder);
//
//        // DB Insert 후 받아온 기본키 확인
//        Long id = keyHolder.getKey().longValue();
//        memo.setId(id);
//        return memo;
//    }
//
//    public List<MemoResponseDto> findAll() {
//        // DB 조회
//        String sql = "SELECT * FROM memo";
//        return jdbcTemplate.query(sql, new RowMapper<MemoResponseDto>() {
//            @Override
//            public MemoResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {
//                // SQL 의 결과로 받아온 Memo 데이터들을 MemoResponseDto 타입으로 변환해줄 메서드
//                Long id = rs.getLong("id");
//                String username = rs.getString("username");
//                String contents = rs.getString("contents");
//                return new MemoResponseDto(id, username, contents);
//            }
//        });
//    }
//
//
//    public Memo findById(Long id) {
//        // DB 조회
//        String sql = "SELECT * FROM memo WHERE id = ?";
//
//        return jdbcTemplate.query(sql, resultSet -> {
//            if(resultSet.next()) {
//                Memo memo = new Memo();
//                memo.setUsername(resultSet.getString("username"));
//                memo.setContents(resultSet.getString("contents"));
//                return memo;
//            } else {
//                return null;
//            }
//        }, id);
//    }
//
//    public void update(Long id, MemoRequestDto requestDto) {
//        String sql = "UPDATE memo SET username = ?, contents = ? WHERE id = ?";
//        jdbcTemplate.update(sql, requestDto.getUsername(), requestDto.getContents(), id);
//
//    }
//
//    public void delete(Long id) {
//        String sql = "DELETE FROM memo WHERE id = ?";
//        jdbcTemplate.update(sql, id);
//    }
//
//    @Transactional
//    public Memo createMemo(EntityManager em) {
//        Memo memo = em.find(Memo.class, 1);
//        memo.setUsername("Robbie");
//        memo.setContents("@Transactional 전파 테스트 중!");
//
//        System.out.println("createMemo 메서드 종료");
//        return memo;
//    }
//}

