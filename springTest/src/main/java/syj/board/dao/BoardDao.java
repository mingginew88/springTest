package syj.board.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import syj.article.model.ArticleVo;
import syj.board.model.BoardVo;

@Repository("boardDao")
public class BoardDao implements BoardDaoInf {
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;

	
	/**
	* Method : getAllBoard
	* 최초작성일 : 2018. 8. 8.
	* 작성자 : PC17
	* 변경이력 :
	* @return
	* Method 설명 : 모든 게시판 정보 조회
	*/
	@Override
	public List<BoardVo> getAllBoard() {
		List<BoardVo> boardList = template.selectList("board.getAllBoard");
		return boardList;
	}

	
	/**
	* Method : getAllArticle
	* 최초작성일 : 2018. 8. 8.
	* 작성자 : PC17
	* 변경이력 :
	* @param board_no
	* @return
	* Method 설명 : 게시판번호에 해당하는 모든 게시글 조회
	*/
	@Override
	public List<ArticleVo> getAllArticle(int board_no) {
		List<ArticleVo> articleList = template.selectList("article.getAllArticle", board_no);
		return articleList;
	}

	
	/**
	* Method : getAllArticleList
	* 최초작성일 : 2018. 8. 8.
	* 작성자 : PC17
	* 변경이력 :
	* @param map
	* @return
	* Method 설명 : 게시글 전체리스트 정보 조회
	*/
	@Override
	public List<ArticleVo> getAllArticleList(Map<String, Integer> map) {
		List<ArticleVo> articleList = template.selectList("article.getAllArticleList", map);
		return articleList;
	}

	
	/**
	* Method : getArticleTotCnt
	* 최초작성일 : 2018. 8. 8.
	* 작성자 : PC17
	* 변경이력 :
	* @param board_no
	* @return
	* Method 설명 : 전체 게시글 갯수 조회
	*/
	@Override
	public int getArticleTotCnt(int board_no) {
		int count = template.selectOne("article.getArticleTotCnt", board_no);
		return count;
	}
	
	
	/**
	* Method : getBoardName
	* 최초작성일 : 2018. 8. 8.
	* 작성자 : PC17
	* 변경이력 :
	* @param board_no
	* @return
	* Method 설명 : 게시판번호에 해당하는 게시판명 검색
	*/
	@Override
	public String getBoardName(int board_no) {
		String board_name = template.selectOne("board.getBoardName", board_no);
		return board_name;
	}

	
	/**
	* Method : addBoard
	* 최초작성일 : 2018. 8. 8.
	* 작성자 : PC17
	* 변경이력 :
	* @param boardVo
	* @return
	* Method 설명 : 게시판 추가
	*/
	@Override
	public int addBoard(BoardVo boardVo) {
		int addResult = template.insert("board.addBoard", boardVo);
		return addResult;
	}

	
	/**
	* Method : updateBoard
	* 최초작성일 : 2018. 8. 8.
	* 작성자 : PC17
	* 변경이력 :
	* @param boardVo
	* @return
	* Method 설명 : 게시판정보 수정
	*/
	@Override
	public int updateBoard(BoardVo boardVo) {
		int updateResult = template.update("board.updateBoard", boardVo);
		return updateResult;
	}




}
