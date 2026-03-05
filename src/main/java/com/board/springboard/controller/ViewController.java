package com.board.springboard.controller;
import com.board.springboard.model.dto.Board;
import com.board.springboard.model.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller // jsp 나 html 템플릿과 소비자가 연결해야하는 api 주소 작성
@RequiredArgsConstructor // 이 한줄이 생성자 코드를 자동생성해준다
public class ViewController {

    private final BoardService boardService;

    /*public ViewController(BoardService boardService) {
        this.boardService = boardService;
        서비스를 매개변수로 받겠다
    }*/

    @GetMapping("/")
    public String indexView() {
        return "index";
    }

    /*
    <a href="/board/detail?no=${board.board_no}">
        ${board.title}
    </a>
     */
    /*@GetMapping("/board/detail")
    public String detailView(@RequestParam("no") int board_no, Model model) {
        // 조회수 증가 및 상세 데이터 가져오기 처리
        // 가져온 데이터를 board 폴더 내에 있는 detail 전달

        Board boardData = boardService.boardDetail(board_no);
        model.addAttribute("board", boardData);
        return "board/detail";
    }*/


    // /board/list
    @GetMapping("/board/list")
    public String listView(Model model) {
        List<Board> boardListData = boardService.findAllBoard();
        model.addAttribute("boardLists", boardListData);
        /*
        Model model 모듈 사용해서 SQL에서 가져온 전체 게시물을 board/list 전달
        list.jsp에 전달할 변수이름 : boardLists
        service에서 데이터를 담아올 변수이름 : boardListData
         */
        return "board/list";
    }

    // /board/write
    @GetMapping("/board/write")
    public String writeView() {
        return "board/write";
    }

    @PostMapping("/board/write")
    public String wrtieBoard(Board board) {
        boardService.writeBoard(board);
        return "redirect:/board/list";
    }

    // ViewController.java 일부
    @GetMapping("/board/detail")
    public String boardDetail(@RequestParam("no") int board_no, Model model) {
        // 1. 서비스 호출 (조회수 증가 및 데이터 가져오기)
        Board boardData = boardService.boardDetail(board_no);

        // 2. 모델에 데이터 담기 (JSP에서: "board")
        model.addAttribute("board", boardData);

        return "board/detail";
    }

    // ViewController.java

// TODO 1. 수정 화면을 보여주기 위한 GET 매핑 주소를 작성하시오.
    @GetMapping("/board/edit")
    public String editView(@RequestParam("no") int board_no, Model model) {

        // TODO 2. 기존 게시물 데이터를 불러와 수정창에 미리 채워주기 위해 서비스를 호출하시오.
        // 힌트: 상세보기와 동일하게 단일 게시물 조회 메서드를 사용합니다.
        Board board = boardService.boardDetail(board_no);

        // TODO 3. 모델(Model)을 사용해 가져온 데이터를 "board"라는 이름으로 전달하시오.
        model.addAttribute("board", board);

        // TODO 4. board 폴더 안의 edit.jsp 파일을 열도록 리턴값을 작성하시오.
        return "board/edit";
    }


    // TODO 5. 삭제 처리를 위한 GET 매핑 주소를 작성하시오. (상세보기의 삭제 버튼 링크 참고)
    @GetMapping("/board/delete")
    public String deleteBoard(@RequestParam("no") int board_no) {

        // TODO 6. 서비스의 삭제 기능을 호출하여 DB에서 해당 번호의 글을 삭제하시오.
        boardService.deleteBoard(board_no);

        // TODO 7. 삭제가 완료된 후 게시물 목록(/board/list)으로 화면을 강제 이동(리다이렉트) 시키시오.
        return "redirect:/board/list";
    }


}