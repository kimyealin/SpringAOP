package yeling.spring.board.dao;

import yeling.spring.board.vo.ArticleVO;

public interface ArticleDAO {
	void insert(ArticleVO article);
	void updateReadCount(int id);
}
