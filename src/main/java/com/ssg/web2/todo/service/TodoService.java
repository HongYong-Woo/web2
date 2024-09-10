package com.ssg.web2.todo.service;

import com.ssg.web2.todo.dao.TodoDAO;
import com.ssg.web2.todo.domain.TodoVO;
import com.ssg.web2.todo.dto.TodoDTO;
import com.ssg.web2.todo.util.ModelUtil;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Log4j2
public enum TodoService {
    INSTANCE;

    private TodoDAO dao;
    private ModelMapper modelMapper;
    
    TodoService() { //생성자 주입
        dao = new TodoDAO(); // 직접 dao 주입
        modelMapper = ModelUtil.INSTANCE.get();
    }

    public void register(TodoDTO dto) throws Exception{
        TodoVO vo = modelMapper.map(dto,TodoVO.class);
        //System.out.println("todoVo : " + vo);
        log.info(vo);
        dao.insert(vo);
    }


    public List<TodoDTO> listAll() throws Exception{

        List<TodoVO> voList = dao.selectAllList();

        List<TodoDTO> dtoList = voList.stream().map(vo->modelMapper.map(vo, TodoDTO.class)).collect(Collectors.toList());

        return dtoList;
    }

    public TodoDTO get(Long tno) throws Exception {
        dao = new TodoDAO();

        TodoVO vo = dao.selectOne(tno);

        TodoDTO dto = modelMapper.map(vo, TodoDTO.class);

        return dto;
    }

    public void remove(Long tno) throws Exception {
        log.info(tno);

        dao.delete(tno);
    }

    public void modify(TodoDTO dto) throws Exception {
        log.info(dto);

        TodoVO vo = modelMapper.map(dto, TodoVO.class);
        dao.updateOne(vo);
    }


    
//    //글 하나를 등록하는 기능
//    public void register(TodoVO vo) throws Exception{
//
//        System.out.println("Debug...." + vo);
//        TodoDAO dao = new TodoDAO();
//        dao.insert(vo);
//    }
//
//    //등록된 글 목록을 반환하는 기능 10개의 TodoDTO를 만들어서 리스트 객체로 반환
///*    public List<TodoDTO> getList() {
//        List<TodoDTO> todoDTOS = IntStream.range(0,10).mapToObj(i-> {
//            TodoDTO dto = new TodoDTO();
//            dto.setTno((long)i);
//            dto.setTitle("todo..." + i);
//            dto.setDueDate(LocalDate.now());
//            return dto;
//        }).collect(Collectors.toList());
//        return todoDTOS;
//    }*/
//    public List<TodoVO> getList() throws Exception {
//        List<TodoVO> list;
//        TodoDAO dao = new TodoDAO();
//        list = dao.selectAllList();
//
//        return list;
//    }
//
//    public TodoVO get(Long tno) throws Exception {
//        TodoDAO dao = new TodoDAO();
//
//        TodoVO vo = dao.selectOne(tno);
//
//
//        return vo;
//    }
//
//    public void update(TodoVO vo) throws Exception{
//        TodoDAO dao = new TodoDAO();
//        dao.updateOne(vo);
//    }
//
//    public void delete(Long tno) throws Exception{
//        TodoDAO dao = new TodoDAO();
//        dao.delete(tno);
//
//    }
}
