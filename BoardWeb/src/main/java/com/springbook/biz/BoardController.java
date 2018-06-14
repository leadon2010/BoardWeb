package com.springbook.biz;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {
	
	@Autowired
	// BoardDAO boardDAO;
	BoardService boardService;

	@RequestMapping("/getBoardList")
	public String getBoardList(Model model) {
		List<Map<String, Object>> list = boardService.getBoardList();
		model.addAttribute("list", list);
		return "/board/getBoardList";
	}

	@RequestMapping("/insertBoardForm")
	public String insertBoardForm() {
		
		return "";
	}

	@RequestMapping("/insertBoard")
	public String insertBoard() {
		return "sendredirect:getBoardList";
	}

	@RequestMapping("/getBoard")
	public String getBoard() {
		return "/board/getBoard";
	}

}
