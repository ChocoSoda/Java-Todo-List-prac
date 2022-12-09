package org.example.repository;

import org.example.model.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// TodoRequest나 TodoResponse 같은 경우는 요청과 응답의 모델이기 때문에 데이터베이스에 저장할 필요 x
// 그렇기 때문에 TodoEntity만 기록
@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, Long> {

}
// 저장소 구현 연습, 어떻게 동작하는지, 왜 사용하는지, 개발하는 모든 부분에 대해 공부를 하는게 큰 도움이 된다.