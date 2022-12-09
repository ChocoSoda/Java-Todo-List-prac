package org.example.service;

import lombok.AllArgsConstructor;
import org.example.model.TodoEntity;
import org.example.model.TodoRequest;
import org.example.repository.TodoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor

public class TodoService {
    private final TodoRepository todoRepository;

    public TodoEntity add(TodoRequest request){
        TodoEntity todoEntity = new TodoEntity();
        TodoEntity.setTitle(request.getTitle());
        TodoEntity.setOrder(request.getOrder());
        TodoEntity.setCompleted(request.getCompleted());
        //TodoEntity entity = this.todoRepository.save(todoEntity);
        return this.todoRepository.save(todoEntity);
    }
    //1	todo 리스트 목록에 아이템을 추가
    //비 static 메서드 해결하기. 일단 강의를 추가적으로 듣고 난 이후에 문제가 생길 시 돌아와서 다시 작업하기    
    public TodoEntity searchById(Long id){
        return this.todoRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    //2	todo 리스트 목록 중 특정 아이템을 조회
    public List<TodoEntity> searchAll(){
        return this.todoRepository.findAll();
    }
    //3	todo 리스트 전체 목록을 조회
    // 리스트 빨간 불 들어온 것을 Quick Fix를 통해 해결할 수 없어 그냥 직접 import함
    public TodoEntity updatebyId(Long id, TodoRequest request){
        TodoEntity todoEntity = this.searchById(id);
        if(request.getTitle() !=null){
            todoEntity.setTitle(request.getTitle());
        }
        if(request.getOrder() != null){
            todoEntity.setOrder(request.getOrder());
        }
        if(request.getCompleted() != null){
            todoEntity.setCompleted((request.getCompleted()));
        }
        return this.todoRepository.save(todoEntity);
    }
    //4	todo 리스트 목록 중 특정 아이템을 수정
    public void deleteByid(Long id){
        this.todoRepository.deleteById(id);
    }
    //5	todo 리스트 목록 중 특정 아이템을 삭제
    public void deleteAll(){
        this.todoRepository.deleteAll();
    }
    //6	todo 리스트 전체 목록을 삭제
}
