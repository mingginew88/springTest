package syj.board.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import syj.board.model.BoardVo;
import syj.board.service.BoardServiceInf;

@RequestMapping("/board")
@Controller
public class BoardController {
	
	@Resource(name="boardService")
	private BoardServiceInf boardService;
	
	
	//left에 게시판 조회
	@RequestMapping(value="/boardList")
	public String boardList(Model model){
		
		List<BoardVo> boardList = boardService.getAllBoard();
		model.addAttribute("boardList", boardList);
		
		return "board/boardList";
	}
	
	
	//게시판 생성
	@RequestMapping(value="/addBoard")
	public String addBoard(BoardVo boardVo){
		
		boardService.addBoard(boardVo);
		return "redirect:/board/boardList";
	}
	
	
	//게시판 수정
	@RequestMapping(value="/updateBoard")
	public String updateBoard(BoardVo boardVo){
		
		boardService.updateBoard(boardVo);
		return "redirect:/board/boardList";
	}
	
	
	//해당 게시판 조회
	@RequestMapping(value="/showBoardList")
	public String showBoardList(@RequestParam("board_no") int board_no
							   ,@RequestParam(value="page", defaultValue="1") int page
							   ,@RequestParam(value="pageSize", defaultValue="10") int pageSize
							   ,Model model){
		
		Map<String, Integer> paramMap = new HashMap<String, Integer>();
		paramMap.put("board_no", board_no);
		paramMap.put("page", page);
		paramMap.put("pageSize", pageSize);
		
		String board_name = boardService.getBoardName(board_no);
		Map<String, Object> resultMap = boardService.getAllArticle(paramMap);
		
		model.addAllAttributes(resultMap);
		model.addAttribute("board_name", board_name);
		return "board/showBoardList";
	}
	
	
	
	
	

}
