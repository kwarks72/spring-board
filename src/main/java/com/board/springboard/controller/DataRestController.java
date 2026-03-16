package com.board.springboard.controller;

import com.board.springboard.model.dto.Board;
import com.board.springboard.model.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

//@Controller
//@ResponseBody

/**
 * @RestControler=@Controller+@ResponseBody
 * 하나의 컨트롤러에서 view페이지 반환을 작성하지 않으며
 * 오직 서비스에서 데이터를 처리하거나, 개발자가 필요한 작업의 결과에 대한 정보만 전달할때 사용
 *
 */
@RestController
@RequiredArgsConstructor
public class DataRestController {

    private final BoardService boardService;
@GetMapping("/dataCheck")
    public List<Board> 데이터확인(){
    return boardService.findAllBoard();
}

}
