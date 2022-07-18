package yeling.spring.board.service;

import yeling.spring.board.vo.ArticleNotFoundException;
import yeling.spring.board.vo.ArticleVO;

public interface ReadArticleService {
	ArticleVO getArticleAndIncreaseReadCount(int id) throws ArticleNotFoundException;
}
